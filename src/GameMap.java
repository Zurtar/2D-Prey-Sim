import java.util.ArrayList;
import java.util.Arrays;

public class GameMap {
    private static int height;
    private static int width;
    public static char[][] map;

    public GameMap(int height, int width) {
        this.height = height;
        this.width = width;

        map = new char[height][width];

        //Build map on creation of object
        this.buildMap();
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

        for (Organism ant : Ant.getAntArrayList()) {
            int xPos = ant.getPosition()[0];
            int yPos = ant.getPosition()[1];

            map[yPos][xPos] = 'o';
        }

    }

    public static void changeMap(int x, int y, char c) {
        map[y][x] = c;
    }

    public static char[][] getMap() {
        return map;
    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }
}
