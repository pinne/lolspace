package collapse;

import java.awt.Point;
import java.util.Random;

public class Block {

    private static final Random RANDOM = new Random();
    private Point block;
    private boolean alive;
    private int cellType;
    private boolean visited;

    public Block(int x, int y) {
        alive = true;
        visited = false;
        this.cellType = RANDOM.nextInt(4);
        block = new Point(x, y);
    }

    public boolean isVisited() {
        return visited;
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

    public int compareTo(Block b1) {
        return this.cellType - b1.getType();
    }

    public int getType() {
        return cellType;
    }
    public void toggle() {
        if (isAlive())
            setDead();
        else
            setAlive();
    }
}
