import java.util.ArrayList;

public class Position {
    protected enum Direction {
        UP(1),
        DOWN(2),
        LEFT(3),
        RIGHT(4);
        private final int val;

        Direction(int val) {
            this.val = val;
        }
    }

    private int X;
    private int Y;

    public Position(int x, int y) {
        X = x;
        Y = y;
    }

    public Position(Position p) {
        this(p.getX(), p.getY());
    }

    /**
     * Default Constructor
     * Sets the position as invalid
     */
    public Position() {
        X = -1;
        Y = -1;
    }

    public boolean equals(Position p) {
        return this != p && (X == p.getX()) && (Y == p.getY());
    }

    protected int getY() {
        return Y;
    }

    protected int getX() {
        return X;
    }

    protected void setX(int x) {
        this.X = x;
    }

    protected void setY(int y) {
        this.Y = y;
    }

    protected void shift(Direction d) {
        switch (d) {
            case UP: // Up
                Y++;
                break;
            case DOWN:
                Y--;
                break;
            case LEFT:
                X--;
                break;
            case RIGHT:
                X++;
                break;
        }
    }

    public Position copy() {
        return new Position(this);
    }
    //Deep copy
}
