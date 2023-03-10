import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Ethan Cook
 * 1163071
 * 2-D Prey Sim
 * <p>
 * <p>
 * TODO:
 *  - Before we add more features theres some technical debt accumulating
 *  - Doodlebug needs to move and eat
 *  - Breeding for Ant and Doodlebug
 *  - Starvation for Doodle
 *  - Prune Kill list
 *  - Cleanup/Optimization
 * <p>
 * <p>
 * March 6th, 2023
 * Coming back after a long break Im looking at all of this and questioning why we're doing half of it. I think there's a much cleaner solution
 * and that I've had to add so many ugly features to accommodate the choices I made at the start. really I should have just cut my losses and
 * reworked the initial approach.
 * <p>
 * Oh well, I'll start now.
 **/

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //if no args given set default
        //mild issue, users can hang the program by requesting more Organisms than we have space
        //We'll get stuck forever in generateAntList
        if (args.length == 0) {
            args = new String[]{"20", "20", "100", "0"};
        }

        Scanner in = new Scanner(System.in);

        GameMap gameMap = new GameMap(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]),
                Integer.parseInt(args[3])
        );

        while (true) {
            gameMap.moveStep();

            System.out.println(gameMap);
            in.nextLine();
        }

    }

    //Purely a debug function
    public static boolean doubleAntDebugCheck(ArrayList<Ant> aList) {
        for (Ant a1 : aList) {
            for (Ant a2 : aList) {
                if (!a1.equals(a2) && a1.getPosition().equals(a2.getPosition()))
                    System.out.println(a1 + " " + a2);
            }
        }
        return false;
    }
}


/**
 * Sometimes ants can just walk off the map... I don't know why... I haven't seen them do it again
 **/

