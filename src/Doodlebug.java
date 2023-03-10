import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class Doodlebug extends Organism {
    private int hunger;

    public Doodlebug(Position p) {
        this();
        setPosition(p.copy());
    }

    public Doodlebug(Doodlebug b) {
        this(b.getPosition());
    }

    //Default constructor
    public Doodlebug() {
        hunger = 0;
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
    public Doodlebug copy() {
        return new Doodlebug(this);
    }

    @Override
    protected void move(Position p) {
        incrementAge();
    }

    @Override
    protected Organism breed() {
        return null;
    }
}
