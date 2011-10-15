/*
 * GameWorld
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package lolspace;

import java.util.Observable;
import java.util.Random;

/**
 * 
 * @author simon
 * 
 */
public class GameWorld extends Observable {
    private static final Random RANDOM = new Random();
    private static final int DEAD = -1;
    private int[][] blocks;
    private int cellRows;
    private int cellCols;
    private boolean running;

    private int gameScore;

    public GameWorld(int cellRows, int cellCols) {
        running = true;
        this.cellRows = cellRows;
        this.cellCols = cellCols;
        this.gameScore = 0;
        blocks = new int[cellRows][cellCols];
        fillWithBlocks();
        randomFill();
        newRow();
        moveRows();
        newRow();

        setChanged();
        notifyObservers();
    }

    public boolean clickBlock(int i, int j) {
        setChanged();
        if (blocks[i][j] >= 0 && running) {
            int nBlocks = destroy(i, j, blocks[i][j]);
            if (nBlocks < 3)
                return false;

            score(nBlocks);
            gravity(nBlocks);
            moveRows();
            newRow();
            if (gameOverCheck())
                running = false;

            this.notifyObservers();
            return true;
        } else {
            this.notifyObservers();
            return false;
        }
    }

    public int getScore() {
        return gameScore;
    }

    public int getType(int i, int j) {
        return blocks[i][j];
    }

    public boolean isRunning() {
        return running;
    }

    public boolean gameOverCheck() {
        for (int j = 0; j < cellCols; j++)
            if (blocks[0][j] != DEAD)
                return true;

        return false;
    }

    public boolean almostGameOver() {
        for (int j = 0; j < cellCols; j++)
            if (blocks[1][j] >= 0)
                return true;

        return false;
    }

    private void score(int nBlocks) {
        gameScore += Math.pow(nBlocks, 1.5);
    }

    private void gravity(int n) {
        while (n-- > 0) {
            for (int i = cellRows - 2; i > 0; i--) {
                for (int j = 0; j < cellCols; j++) {
                    if (blocks[i + 1][j] == DEAD) {
                        blocks[i + 1][j] = blocks[i][j];
                        blocks[i][j] = DEAD;
                    }
                }
            }
        }
    }

    private int destroy(int x, int y, int target) {
        int points = 0;

        if (y < 0 || x < 0 || x > cellRows - 1 || y > cellCols - 1
                || blocks[x][y] != target) {
            return 0;
        } else {
            blocks[x][y] = DEAD;
            points++;
            points += destroy(x - 1, y, target);
            points += destroy(x + 1, y, target);
            points += destroy(x, y - 1, target);
            points += destroy(x, y + 1, target);
            return points;
        }
    }

    private void fillWithBlocks() {
        for (int i = 0; i < cellRows - 1; i++) {
            for (int j = 0; j < cellCols; j++) {
                blocks[i][j] = DEAD;
            }
        }
    }

    private void newRow() {
        for (int j = 0; j < cellCols; j++)
            blocks[cellRows - 1][j] = RANDOM.nextInt(3);
    }

    private void moveRows() {
        for (int i = 0; i < cellRows - 1; i++) {
            for (int j = 0; j < cellCols; j++) {
                blocks[i][j] = blocks[i + 1][j];
            }
        }
    }

    private void randomFill() {
        int n = 0;
        for (int i = 0; i < cellRows - 1; i++) {
            for (int j = 0; j < cellCols; j++) {
                if (RANDOM.nextInt(10) == 0) {
                    blocks[i][j] = RANDOM.nextInt(3);
                    n++;
                }
            }
        }
        gravity(n * cellRows);
    }

    public int getCellRows() {
        return cellRows;
    }

    public int getCellCols() {
        return cellCols;
    }

    public void setSize(int i, int j) {
        cellRows = i;
        cellCols = j;
    }
}