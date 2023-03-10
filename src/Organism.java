import java.util.ArrayList;

public abstract class Organism {
    private Position position;
    private int age;
    private boolean alive;

    public Organism() {
        position = new Position();
        alive = true;
    }

    /**
     * Non-Abstract Methods
     **/
    protected void incrementAge() {
        age++;
    }

    protected void kill() {
        alive = false;
    }

    /**
     * Getter Methods
     **/
    protected int getAge() {
        return age;
    }

    protected Position getPosition() {
        return position.copy();
    }

    protected boolean isAlive() {
        return alive;
    }

    /**
     * Setter Methods
     **/
    protected void setPosition(Position p) {
        this.position = new Position(p);
    }

    protected void resetAge() {
        this.age = 0;
    }

    /**
     * Abstract Methods to Override
     **/
    protected abstract void move(Position p);

    protected abstract Organism breed(); //Unsure if it should return the new object or not… hm

    protected abstract Organism copy();
}



