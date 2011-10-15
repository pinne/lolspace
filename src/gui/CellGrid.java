/*
 * View
 * 
 * Copyright Simon Kers - KTH 2011.
 */

package gui;

import java.awt.*;

import javax.swing.*;

/**
 * 
 * @author simon
 *
 */
public class CellGrid extends JPanel {

    private static final long serialVersionUID = 1L;
    private Cell[][] cells;
    private View view;
    private int cellRows;
    private int cellCols;
    private static final int DEAD = -1;

    public CellGrid(View view, int cellrows, int cellcols, int cellwidth,
            int cellheight) {
        super();
        this.setBackground(Color.DARK_GRAY);
        this.view = view;
        this.cellRows = cellrows;
        this.cellCols = cellcols;
        this.setLayout(new GridLayout(cellrows, cellcols));
        this.setPreferredSize(new Dimension(cellwidth * cellcols, cellheight
                * cellrows));

        cells = new Cell[cellrows][cellcols];
        this.initCells(cellrows, cellcols, cellwidth, cellheight);
        updateCells();
    }

    public void updateCells() {
        for (int i = 0; i < cellRows - 0; i++) {
            for (int j = 0; j < cellCols; j++) {
                if (view.getType(i, j) >= 0) {
                    cells[i][j].setAlive();
                    cells[i][j].setColor(view.getType(i, j));
                } else {
                    cells[i][j].setDead();
                    cells[i][j].setColor(DEAD);
                }
            }
        }
    }

    public void gameOver() {
        for (int i = 0; i < cellRows - 0; i++) {
            for (int j = 0; j < cellCols; j++) {
                if (view.getType(i, j) >= 0) {
                    cells[i][j].setColor(view.getType(i, j));
                } else {
                    cells[i][j].setColor(-3);
                }
            }
        }
    }

    private void initCells(int cellrows, int cellcols, int cellwidth,
            int cellheight) {
        for (int i = 0; i < cellrows; i++) {
            for (int j = 0; j < cellcols; j++) {
                cells[i][j] = new Cell(view, i, j);
                cells[i][j].setPreferredSize(new Dimension(cellwidth,
                        cellheight));
                this.add(cells[i][j]);
            }
        }
    }
}