/* 
 * WindowPanel
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package gui;

import javax.swing.*;
import collapse.GameWorld;
import java.awt.BorderLayout;

/**
 * 
 * @author simon
 * 
 */
public class View extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private GameWorld gw;
    private CellGrid grid;
    private ScoreView scores;
    private Menu menu;

    public View(String title, GameWorld gw, int cellRows, int cellCols,
            int cellWidth, int cellHeight) {
        super(title);

        this.gw = gw;
        this.grid = new CellGrid(this, cellRows, cellCols, cellWidth,
                cellHeight);

        this.scores = new ScoreView(this);
        this.menu = new Menu(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(cellCols * cellHeight, cellRows * cellWidth);
        this.getContentPane().add(grid, BorderLayout.CENTER);
        this.getContentPane().add(scores, BorderLayout.SOUTH);
        this.getContentPane().add(menu, BorderLayout.NORTH);
        this.setVisible(true);
    }

    public void updateViews() {
        if (gw.isRunning()) {
            grid.updateCells();
            scores.updateScore();
        } else {
            grid.gameOver();
            scores.gameOver();
        }
    }

    public int getScore() {
        return gw.getScore();
    }

    public boolean clickBlock(int i, int j) {
        return gw.clickBlock(i, j);
    }

    public int getType(int i, int j) {
        return gw.getType(i, j);
    }
}
