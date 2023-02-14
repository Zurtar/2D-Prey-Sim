import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class Ant extends Organism {

    private static ArrayList<Ant> antArrayList = new ArrayList<>();

    //Because secureRandom will return a random value every time without reseeding we can make it static!
    static SecureRandom random = new SecureRandom();

    public Ant(int xPos, int yPos) {
        setPosition(new int[]{xPos, yPos});
    }

    @Override
    public String toString(){
        //Print
        return String.format(
                "Cords (x,y): %d , %d\nAge: %d\nMoved?: %b"
                ,getPosition()[1],getPosition()[0], getAge(), hasMoved()
        );
    }

    @Override
    protected void move() {
        int[] pos = getPosition();

        int xPos=pos[0];
        int yPos=pos[1];

        //0: Up, 2: Down
        // 1: Right, 3: Left
        int direction = random.nextInt(4);

        switch (direction) {
            case 0:
                yPos++;
                break;
            case 2:
                yPos--;
                break;
            case 3:
                xPos++;
                break;
            case 1:
                xPos--;
                break;
        }

        try {
            //Get char at the proposed new Position
            char tmp = GameMap.getMap()[yPos][xPos];
            if (tmp == '*')
                this.setPosition(new int[]{xPos,yPos});

        } catch (IndexOutOfBoundsException e){
            //Out of grid! cant move.
        }

    }

    @Override
    protected Organism breed() {
        return null;
    }

    public static ArrayList<Ant> getAntArrayList(){
    return antArrayList;
    }

    public static void setAntArrayList(ArrayList<Ant> newAntList){
        antArrayList= new ArrayList<>(newAntList);
        int i = 1+1;
    }
}
