/*
 * GameWorld
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package lolspace;

import gui.MainPanel;

import java.util.Observable;
import java.util.Random;

/**
 * 
 * @author simon
 * 
 */
public class GameWorld extends Observable {
    private static final Random RANDOM = new Random();
    private static final int N_COLORS = 3;
    private static final int EMPTY = -1;
    private int[][] blocks;
    private int cellRows;
    private int cellCols;
    private boolean running;
    private boolean gameOver;

    public boolean isGameOver() {
        return gameOver;
    }

    private int gameScore;

    /*
     * 
     */
    public GameWorld(MainPanel panel, int cellRows, int cellCols) {
        running = true;
        gameOver = false;
        this.cellRows = cellRows;
        this.cellCols = cellCols;
        this.gameScore = 0;
        this.addObserver(panel);
        blocks = new int[cellRows][cellCols];

        fillWithBlocks();
        randomFill();
        newRow();
        moveRows();
        newRow();
        setChanged();
        notifyObservers();
    }

    public void clickBlock(int i, int j) {
        setChanged();
        if (blocks[i][j] >= 0) {
            int[][] tmp = copy2DArray(blocks);
            
            int nBlocks = destroy(i, j, blocks[i][j]);
            if (nBlocks < 3) {
                blocks = copy2DArray(tmp);
                this.notifyObservers();
                return;
            }
            if (running)
                score(nBlocks);

            gravity(nBlocks);
            moveRows();
            newRow();
            gameOver = gameOverCheck();
            this.notifyObservers();
        }
    }
    
    public int[][] copy2DArray(int array[][]) {
        int[][] copy = new int[array.length][];
        
        for (int i = 0; i < array.length; i++)
            copy[i] = array[i].clone();
        
        return copy;
    }

    public int getScore() {
        if (running)
            return gameScore;
        else
            return 0;
    }

    public int getType(int i, int j) {
        return blocks[i][j];
    }

    public boolean isRunning() {
        return running;
    }

    private boolean gameOverCheck() {
        for (int j = 0; j < cellCols; j++)
            if (blocks[0][j] != EMPTY)
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
                    if (blocks[i + 1][j] == EMPTY) {
                        blocks[i + 1][j] = blocks[i][j];
                        blocks[i][j] = EMPTY;
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
            blocks[x][y] = EMPTY;
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
                blocks[i][j] = EMPTY;
            }
        }
    }

    private void newRow() {
        for (int j = 0; j < cellCols; j++)
            blocks[cellRows - 1][j] = RANDOM.nextInt(N_COLORS);
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
                if (RANDOM.nextInt(8) == 0) {
                    blocks[i][j] = RANDOM.nextInt(N_COLORS);
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

    public void setRunning(boolean b) {
        running = b;
    }
}