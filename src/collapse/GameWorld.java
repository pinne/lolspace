package collapse;

import java.awt.Point;

public class GameWorld {
    private Block[][] blocks = null;
    private int cellRows;
    private int cellCols;

    public GameWorld(int cellRows, int cellCols) {
        this.cellRows = cellRows;
        this.cellCols = cellCols;
        blocks = new Block[cellRows][cellCols];
        fillWithBlocks();
    }

    public void fillWithBlocks() {
        for (int i = 0; i < cellRows; i++) {
            for (int j = 0; j < cellCols; j++) {
                blocks[i][j] = new Block(i, j);
            }
        }
    }

    public boolean isAlive(int i, int j) {
        return blocks[i][j].isAlive();
    }

    public void clickBlock(Point cell) {
        System.out.println(cell.toString());
        blocks[cell.x][cell.y].toggle();
    }
}
