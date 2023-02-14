import java.util.ArrayList;
import java.util.Arrays;

public class GameMap {
    private int height, width;
    private char[][] map;

    private ArrayList<Ant> antList;

    public GameMap(int height, int width, ArrayList<Ant> antList) {
        this.height = height;
        this.width = width;

        this.antList = antList; // is this duping it in memory?

        map = new char[height][width];
    }

    @Override
    public String toString() {
        String output = "";
        for (char[] row : map) {
            output += String.format("%s\n", new String(row));
        }
        return output;
    }

    public void buildMap() {
        map = new char[height][width];
        for (char[] row : map) {
            Arrays.fill(row, '*');
        }

        for (Organism ant : antList) {
            int xPos = ant.getPosition()[0];
            int yPos = ant.getPosition()[1];

            map[yPos][xPos] = 'X';
        }

    }
}
