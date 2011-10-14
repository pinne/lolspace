/*
 * View
 * 
 * Copyright Simon Kers - KTH 2011.
 */

package gui;

import java.awt.*;

import javax.swing.*;

import collapse.GameWorld;

/**
 * 
 * @author simon
 *
 */
public class View extends JPanel {

    private static final long serialVersionUID = 1L;
    private GameWorld gameworld;
    private ViewCell[][] cells;
    private WindowPanel panel;
    private int cellRows;
    private int cellCols;
    private static final int DEAD = -1;

    public View(GameWorld world, WindowPanel panel, int cellrows, int cellcols, int cellwidth,
            int cellheight) {
        super();
        this.setBackground(Color.DARK_GRAY);
        this.gameworld = world;
        this.panel = panel;
        this.cellRows = cellrows;
        this.cellCols = cellcols;
        this.setLayout(new GridLayout(cellrows, cellcols));
        this.setPreferredSize(new Dimension(cellwidth * cellcols, cellheight
                * cellrows));

        cells = new ViewCell[cellrows][cellcols];
        this.initCells(cellrows, cellcols, cellwidth, cellheight);
        updateCells();
    }

    public void updateCells() {
        if (!gameworld.isRunning())
            gameOver();
        for (int i = 0; i < cellRows - 0; i++) {
            for (int j = 0; j < cellCols; j++) {
                if (gameworld.getType(i, j) >= 0) {
                    cells[i][j].setAlive();
                    cells[i][j].setColor(gameworld.getType(i, j));
                } else {
                    cells[i][j].setDead();
                    cells[i][j].setColor(DEAD);
                }
            }
        }
    }

    private void gameOver() {
        
    }

    private void initCells(int cellrows, int cellcols, int cellwidth,
            int cellheight) {
        for (int i = 0; i < cellrows; i++) {
            for (int j = 0; j < cellcols; j++) {
                cells[i][j] = new ViewCell(gameworld, panel, i, j);
                cells[i][j].setPreferredSize(new Dimension(cellwidth,
                        cellheight));
                this.add(cells[i][j]);
            }
        }
    }
}