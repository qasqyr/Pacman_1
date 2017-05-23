/**
 * Created by Yera on 09.05.2017.
 */
public class Position {
    private int x; // x pos
    private int y; // y pos

    public Position(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    // setters and getters

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // equals method compare positions
    public boolean equals(Position obj) {
        if(this.x == obj.x && this.y == obj.y)
            return true;
        return false;
    }
}
