import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ant extends Organism {

    //Because secureRandom will return a random value every time without reseeding we can make it static!
    static SecureRandom random = new SecureRandom();

    public Ant(Position p) {
        setPosition(new Position(p));
    }

    //Deep copy constructor
    public Ant(Ant a) {
        this(a.getPosition());
    }

    //Default ant constructor just calls our supers default
    public Ant() {
        super();
    }

    @Override
    public String toString() {
        //Print
        return String.format(
                "Cords (x,y): (%d,%d)",
                getPosition().getX(), getPosition().getY()
        );
    }

    @Override
    public Ant copy(){
        return new Ant(this);
    }

    @Override
    protected void move(Position p) {
        //if tmpPos is null, no valid move is possible
        if (p == null)
            return;
        this.setPosition(p);
        incrementAge();
    }

    @Override
    protected Organism breed() {
        return null;
    }
}
