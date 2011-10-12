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
        nextRound();
    }

    private void nextRound() {
        for (int j = 0; j < cellCols; j++) {
            blocks[15][j] = new Block(15, j);
        }
    }

    // private void regroup() {
    // for (int i = 0; i < cellRows; i++) {
    // for (int j = 0; j < cellCols; j++) {
    // Block current = blocks[i][j];
    // // current.groupBlocks(blocks[i][j-1]);
    // // current.groupBlocks(blocks[i][j+1]);
    // // current.groupBlocks(blocks[i-1][j]);
    // // current.groupBlocks(blocks[i+1][j]);
    // }
    // }
    // }

    public void fillWithBlocks() {
        for (int i = 0; i < cellRows; i++) {
            for (int j = 0; j < cellCols; j++) {
                blocks[i][j] = new Block(i, j);
            }
        }
    }

    public boolean isAlive(int i, int j) {
        try {
            return blocks[i][j].isAlive();
        } catch (NullPointerException e) {
            return false;
        }
    }

    public int getType(int i, int j) {
        try {
            return blocks[i][j].getType();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public void clickBlock(Point cell) {
        System.out.println(cell.toString());
        blocks[cell.x][cell.y].toggle();
        nextRound();
    }
}