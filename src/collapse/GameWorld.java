package collapse;

import java.awt.Point;
import java.util.Random;

public class GameWorld {
    private static final Random RANDOM = new Random();
    private int[][] blocks = null;
    private int cellRows;
    private int cellCols;
    private int gameScore;

    public GameWorld(int cellRows, int cellCols) {
        this.cellRows = cellRows;
        this.cellCols = cellCols;
        this.gameScore = 0;
        blocks = new int[cellRows][cellCols];
        fillWithBlocks();
        newRow();
    }

    public boolean clickBlock(Point cell) {
        System.out.println("clickBlock: " + cell.toString());
        if (blocks[cell.x][cell.y] >= 0) {
            int points = destroy(cell.x, cell.y, blocks[cell.x][cell.y]);
            gameScore += points;
            System.out.println("+ " + points + ": " + gameScore);
            gravity(points);
            moveRows();
            newRow();
            return true;
        } else {
            return false;
        }
    }

    private void gravity(int n) {
        while (n-- > 0) {
            for (int i = cellRows - 2; i > 0; i--) {
                for (int j = 0; j < cellCols; j++) {
                    if (blocks[i + 1][j] == -1) {
                        blocks[i + 1][j] = blocks[i][j];
                        blocks[i][j] = -1;
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
            blocks[x][y] = -1;
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
                blocks[i][j] = -1;
            }
        }
    }

    private void newRow() {
        for (int j = 0; j < cellCols; j++)
            blocks[cellRows - 1][j] = RANDOM.nextInt(4);
    }

    private void moveRows() {
        for (int i = 0; i < cellRows - 1; i++) {
            for (int j = 0; j < cellCols; j++) {
                blocks[i][j] = blocks[i + 1][j];
            }
        }
    }

    public int getType(int i, int j) {
        return blocks[i][j];
    }

}