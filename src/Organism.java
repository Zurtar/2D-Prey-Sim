public abstract class Organism {
    private int[] position = {-1, -1};
    private int age;
    private boolean moved = false;
    private boolean alive = true;

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

    protected int[] getPosition() {
        return position;
    }

    protected boolean isAlive() {
        return alive;
    }

    protected boolean hasMoved() {
        return moved;
    }

    /**
     * Setter Methods
     **/
    protected void setPosition(int[] position) {
        this.position = position;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected void setMoved(boolean hasMoved) {
        moved = hasMoved;
    }


    /**
     * Abstract Methods to Override
     **/
    protected abstract void move();

    protected abstract Organism breed(); //Unsure if it should return the new object or not… hm

}
