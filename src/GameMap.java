import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GameMap {
    public final char ANT_CHAR = 'o';
    public final char BUG_CHAR = 'x';
    public final char EMPTY_CHAR = ' ';

    private ArrayList<Ant> antArrayList;
    private ArrayList<Doodlebug> doodleArrayList;

    private int height;
    private int width;
    private static char[][] map;

    public GameMap(int height_, int width_, int numOfAnts, int numOfDoodle) {
        height = height_;
        width = width_;

        map = new char[height][width];
        antArrayList= new ArrayList<>();
        doodleArrayList= new ArrayList<>();

        buildMap();
        generateCreatureLists(numOfAnts, numOfDoodle);
    }

    @Override
    public String toString() {
        buildMap(); //Update map to insure correct printing
        String output = "";
        for (char[] row : map) {
            output += String.format("%s\n", new String(row));
        }
        return output;
    }

    public void buildMap() {
        //Set map to empty cells
        for (char[] row : map) {
            Arrays.fill(row, EMPTY_CHAR);
        }

        for (Ant ant : antArrayList) {
            Position p = ant.getPosition();
            changeMapAt(p, ANT_CHAR);
        }

        for (Doodlebug doodle : doodleArrayList) {
            Position p = doodle.getPosition();
            changeMapAt(p, BUG_CHAR);
        }
    }

    private void generateCreatureLists(int numOfAnts, int numOfDoodle) {
        antArrayList = new ArrayList<>();
        doodleArrayList = new ArrayList<>();

        int l = Math.max(numOfAnts, numOfDoodle);
        for (int i = 0; i < l; i++) {

            if (i < numOfAnts) {
                Position p = getEmptyPos();
                changeMapAt(p, ANT_CHAR);
                antArrayList.add(new Ant(p));
            }

            if (i < numOfDoodle) {
                Position p = getEmptyPos();
                changeMapAt(p, BUG_CHAR);
                doodleArrayList.add(new Doodlebug(p));
            }
        }
    }

    public void moveStep() {
        ArrayList<Organism> orgList = new ArrayList<>();
        orgList.addAll(antArrayList);
        orgList.addAll(doodleArrayList);

        for (Organism organism : orgList) {
            Position p = getEmptyAdjPos(organism.getPosition());
            organism.move(p);

            if (organism.getClass().getName().equals("Ant"))
                changeMapAt(organism.getPosition(), ANT_CHAR);
            else
                changeMapAt(organism.getPosition(), BUG_CHAR);
        }
    }

    //As the grid fills up this is going to slow down
    public Position getEmptyPos() {
        SecureRandom secureRandom = new SecureRandom();
        Position p = new Position();

        //Loops until tmpPos is a valid position (on grid)
        while (!(isValidPos(p) && isEmpty(p))) {
            p.setX(secureRandom.nextInt(0, width));
            p.setY(secureRandom.nextInt(0, height));
        }
        return p.copy();
    }

    public Position getEmptyAdjPos(Position currentPos) {
        SecureRandom secureRandom = new SecureRandom();
        ArrayList<Position> validPos = getAdjPos(currentPos);

        //because validPos gets passed in order we shuffle to ensure random moves
        Collections.shuffle(validPos);

        for (Position p : validPos) {
            if (isEmpty(p)) return p.copy();
        }
        //No Empty Adj pos
        return null;
    }

    private ArrayList<Position> getAdjPos(Position currentPos) {
        SecureRandom secureRandom = new SecureRandom();
        ArrayList<Position> validPosList = new ArrayList<>();

        ArrayList<Position.Direction> validDirections = new ArrayList<>(Arrays.asList(Position.Direction.values()));

        for (int i = 0; i < 4; i++) {
            //Picks a move from validMoves
            Position p = new Position(currentPos);

            //Shift tmpPos in direction of chosen move
            p.shift(validDirections.get(i));

            //If position is valid and empty return
            if (isValidPos(p)) validPosList.add(new Position(p));
        }
        //Returns all on grid adj positions
        return validPosList;
    }

    private boolean isValidPos(Position p) {
        try {
            getMapAt(p);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    private boolean isEmpty(Position p) {
        return getMapAt(p) == EMPTY_CHAR;
    }

    private static char getMapAt(Position pos) {
        return map[pos.getY()][pos.getX()];
    }

    //not needed.. but I was so proud of the generic use
    private static <T extends Organism> void copyOrgList(ArrayList<T> dest, ArrayList<T> source) {
        dest.clear();
        for (T antToCopy : source) {
            dest.add((T) antToCopy.copy());
        }
    }

    /**
     * Public Static Methods
     **/
    public static void changeMapAt(Position pos, char c) {
        map[pos.getY()][pos.getX()] = c;
    }

}
