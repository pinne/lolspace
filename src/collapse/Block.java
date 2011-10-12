package collapse;

import java.awt.Point;

public class Block {
    private Point block;
    private boolean alive;

    public Block(int x, int y) {
        alive = true;
        block = new Point(x, y);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive() {
        alive = true;
    }

    public void setDead() {
        alive = false;
    }

    public void setPos(Point p) {
        this.block = p;
    }

    public void makePoint(int x, int y) {
        block.x = x;
        block.y = y;
    }

    public Point getPos() {
        return block;
    }

    public void toggle() {
        if (isAlive())
            setDead();
        else
            setAlive();
    }
}
