package collapse;

public class GameWorld {
    private Cell[][] blocks = new Cell[16][12];

    public GameWorld() {
        
    }

    public Cell getBlocks(int x, int y) {
        return blocks[x][y];
    }
}
