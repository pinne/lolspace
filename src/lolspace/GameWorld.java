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
 * The class GameWorld holds the game engine, this is the Model in the
 * MVC design. The game engine has an array of different types of
 * ints, corresponding to different colored blocks in the "View".
 * 
 * An int of value 0..* is alive, the value -1 means that the cell is
 * empty.
 * 
 * @author skers@kth.se
 * 
 */
public class GameWorld extends Observable {
    private static final Random RANDOM = new Random();
    private static int N_COLORS = 3;
    private static final int EMPTY = -1;
    private static final double SCORE_EXPONENT = 1.5;
    private int[][] blocks;
    private int cellRows;
    private int cellCols;
    private boolean running;
    private boolean gameOver;
    private boolean almostGameOver;
    private static int gameScore;

    /**
     * Initializes the grid and fills it randomly with blocks of
     * random type.
     * 
     * @param panel
     * @param cellRows
     * @param cellCols
     */
    public GameWorld(MainPanel panel, int cellRows, int cellCols) {
        running = true;
        gameOver = false;
        almostGameOver = false;

        this.cellRows = cellRows;
        this.cellCols = cellCols;
        blocks = new int[cellRows][cellCols];

        fillWithEmptyBlocks();
        randomFill();
        newRow();
        moveRows();
        newRow();
        setChanged();
        notifyObservers();
        this.addObserver(panel);
    }

    public boolean isRunning() {
        return running;
    }

    /**
     * This returns true when the blocks have reached the top of the
     * grid, it is Game Over.
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * This returns true when the blocks are one cell off from causing
     * a 'Game Over'.
     */
    public boolean isAlmostGameOver() {
        return almostGameOver;
    }

    /**
     * Returns the grid height.
     */
    public int getCellRows() {
        return cellRows;
    }

    /**
     * Returns the grid width.
     */
    public int getCellCols() {
        return cellCols;
    }

    /**
     * Start or stop the game engine.
     */
    public void setRunning(boolean b) {
        running = b;
    }

    /**
     * The clickBlock method receives the coordinates from the
     * CellListener and tries to remove grouped together blocks of the
     * same type.
     * 
     * If the number of adjacent blocks are less than three the
     * destroy command is undone.
     * 
     * The method invokes the gravity method and the observers are
     * notified.
     * 
     * @param i
     * @param j
     */
    public void clickBlock(int i, int j) {
        setChanged();
        if (blocks[i][j] >= 0 && running) {
            int[][] tmp = copy2DArray(blocks);

            int nBlocks = destroy(i, j, blocks[i][j]);
            if (nBlocks < 3) {
                blocks = copy2DArray(tmp);
                setChanged();
                this.notifyObservers();
                return;
            } else if (running) {
                score(nBlocks);
            }

            gravity(nBlocks);
            moveRows();
            newRow();

            if (!(gameOver = gameOverCheck()))
                almostGameOver = almostGameOverCheck();
        }
        this.notifyObservers();
    }

    /**
     * Returns a copy of an array.
     * 
     * @param array
     * @return copy
     */
    public int[][] copy2DArray(int array[][]) {
        int[][] copy = new int[array.length][];

        for (int i = 0; i < array.length; i++)
            copy[i] = array[i].clone();

        return copy;
    }

    /**
     * @return gameScore
     */
    public int getScore() {
        return gameScore;
    }

    /**
     * Return what type of block in the specific cell.
     * 
     * @param i
     * @param j
     * @return "type"
     */
    public int getType(int i, int j) {
        return blocks[i][j];
    }

    /**
     * Iterate through the field and check if the live blocks has
     * reached the top row.
     * 
     * @return boolean
     */
    private boolean gameOverCheck() {
        for (int j = 0; j < cellCols; j++)
            if (blocks[0][j] != EMPTY)
                return true;

        return false;
    }

    /**
     * Iterate through the field and check if the live blocks has
     * reached the second top row.
     * 
     * @return boolean
     */
    private boolean almostGameOverCheck() {
        for (int j = 0; j < cellCols; j++)
            if (blocks[1][j] >= 0)
                return true;

        return false;
    }

    /**
     * Calculates the score based on the number of blocks destroyed.
     * 
     * @param nBlocks
     */
    private void score(int nBlocks) {
        gameScore += Math.pow(nBlocks, SCORE_EXPONENT);
    }

    /**
     * Recursively destroys adjacent blocks of the same type. Undo is
     * implemented by the calling methods.
     * 
     * @param x
     * @param y
     * @param target
     * @return
     */
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

    /**
     * Enforce gravity across the entire grid. Blocks will fall down n
     * rows, the n value is usually from the number of blocks
     * destroyed guaranteeing a sufficient number of iterations.
     * 
     * @param n
     */
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

    /**
     * Set all cells EMPTY.
     * 
     */
    private void fillWithEmptyBlocks() {
        for (int i = 0; i < cellRows - 1; i++) {
            for (int j = 0; j < cellCols; j++) {
                blocks[i][j] = EMPTY;
            }
        }
    }

    /**
     * Randomly generate the live blocks, enforce enough gravity to
     * have them fall to the bottom of the grid.
     */
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

    /**
     * On the bottom row in the grid, generate a new set of blocks of
     * random type.
     */
    private void newRow() {
        for (int j = 0; j < cellCols; j++)
            blocks[cellRows - 1][j] = RANDOM.nextInt(N_COLORS);
    }

    /**
     * Shift the set of blocks upwards.
     */
    private void moveRows() {
        for (int i = 0; i < cellRows - 1; i++) {
            for (int j = 0; j < cellCols; j++) {
                blocks[i][j] = blocks[i + 1][j];
            }
        }
    }
}