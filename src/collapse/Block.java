package collapse;

import java.awt.Point;
import java.util.Random;

public class Block {

    private static final Random RANDOM = new Random();
    private Point block;
    private boolean alive;
    private int cellType;

    public Block(int i, int j) {
        setDead();
        this.cellType = RANDOM.nextInt(4);
        block = new Point(i, j);
    }
    
    public void create() {
        alive = true;
        this.cellType = RANDOM.nextInt(4);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setDead() {
        alive = false;
        cellType = -1;
    }

    public void setPos(Point p) {
        this.block = p;
    }

    public void makePoint(int i, int j) {
        block.y = i;
        block.x = j;
    }

    public Point getPos() {
        return block;
    }

    public int compareTo(Block b1) {
        return this.cellType - b1.getCellType();
    }
    
    public int getCellType() {
        return cellType;
    }

    public void setCellType(int cellType) {
        this.cellType = cellType;
    }

    public void toggle() {
        if (isAlive())
            setDead();
        else
            alive = true;
    }

    public void moveUp() {
//        block.y--;
    }
}
