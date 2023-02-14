import java.util.ArrayList;
import java.util.Arrays;

/**
 * Ethan Cook
 * 1163071
 * 2-D Prey Sim
 *
 * **/


public class Main {
    public static void main(String[] args) {
        ArrayList<Ant> antArrayList = new ArrayList<>();
        antArrayList.add(new Ant(4, 2));
        antArrayList.add(new Ant(0, 1));
        antArrayList.add(new Ant(2, 4));
        antArrayList.add(new Ant(1, 2));


        GameMap gameMap = new GameMap(5, 5, antArrayList);
        gameMap.buildMap();
        System.out.println(gameMap);

    }
}

