package collapse;

public class Block {
    private boolean alive;
    private int x;
    private int y;

    public enum Color {
        RED, GREEN, YELLOW, BLUE
    }

    public Block(int x, int y) {
        alive = true;
        this.x = x;
        this.y = y;
    }

    
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

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
}
