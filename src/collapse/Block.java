package collapse;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Block {

    private static final Random RANDOM = new Random();
    private ArrayList<Block> group;
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

    public ArrayList<Block> groupBlocks(Block that) {
        if (visited) {
            System.out.println("Visited");
            return null;
        } else {
            System.out.println("Not visited");
            group = new ArrayList<Block>();
        }

        if (this.compareTo(that) == 0)
            group.add(that);

        return group;
    }

    public Block getObject() {
        return this;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
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
