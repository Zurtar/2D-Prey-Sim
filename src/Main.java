import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ethan Cook
 * 1163071
 * 2-D Prey Sim
 **/

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Ugly Test Code!!! Not final at all
        GameMap gameMap = new GameMap(20, 20);
        generateAntList(100);


        /**Awful test code!!!!**/
        while (true) {
            gameMap.buildMap();

            for (Ant a : Ant.getAntArrayList()) {
                a.move();
            }
            System.out.println(gameMap);
            Thread.sleep(750);
        }
    }


    /**
     * Magic height width Value is dumb!
     **/
    public static void generateAntList(int numOfAnts) {
        Ant.getAntArrayList().clear();
        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < numOfAnts; i++) {

            boolean validPos = false;

            while (!validPos) {
                int xPos = secureRandom.nextInt(0, GameMap.getWidth());
                int yPos = secureRandom.nextInt(0, GameMap.getHeight());

                if (GameMap.getMap()[yPos][xPos] == '*') {
                    GameMap.changeMap(xPos, yPos, 'o');
                    Ant.getAntArrayList().add(new Ant(xPos, yPos));
                    validPos = true;
                }

            }
        }
    }

}

/**
 * Sometimes ants can just walk off the map... I don't know why
 **/

