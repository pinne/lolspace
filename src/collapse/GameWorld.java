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
        newRow();
    }

    public void newRow() {
        for (int j = 0; j < cellCols; j++) {
            blocks[15][j].create();
        }
    }

    public void moveRows() {
        for (int i = 0; i < cellRows - 2; i++) {
            for (int j = 0; j < cellCols; j++) {
                blocks[i][j] = blocks[i + 1][j].getObject();
            }
        }
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

    public int getType(int i, int j) {
        return blocks[i][j].getType();
    }

    public void clickBlock(Point cell) {
        System.out.println("clickBlock: " + cell.toString());
        blocks[cell.x][cell.y].toggle();
        moveRows();
        newRow();
    }
}