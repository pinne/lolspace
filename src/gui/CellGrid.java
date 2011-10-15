/*
 * View
 * 
 * Copyright Simon Kers - KTH 2011.
 */

package gui;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import lolspace.GameWorld;

/**
 * 
 * @author simon
 * 
 */
public class CellGrid extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;
    private GameWorld gw;
    private Cell[][] cells;
    private int cellRows;
    private int cellCols;

    public CellGrid(GameWorld gw, int cellcols, int cellrows, int cellwidth,
            int cellheight) {
        super();
        this.gw = gw;
        gw.addObserver(this);

        this.setBackground(Color.DARK_GRAY);
        this.cellRows = cellrows;
        this.cellCols = cellcols;
        this.setLayout(new GridLayout(cellrows, cellcols));
        this.setPreferredSize(new Dimension(cellwidth * cellcols, cellheight
                * cellrows));

        cells = new Cell[cellrows][cellcols];
        initCells(cellrows, cellcols, cellwidth, cellheight);
        update(gw, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        GameWorld gw = (GameWorld) o;
        if (gw.gameOverCheck())
            this.gameOver(gw);
        else
            updateCells(gw);
    }

    private void updateCells(GameWorld gw) {
        for (int i = 0; i < cellRows - 0; i++) {
            for (int j = 0; j < cellCols; j++) {
                if (gw.getType(i, j) >= 0) {
                    cells[i][j].setColor(gw.getType(i, j));
                } else {
                    cells[i][j].setDead();
                }
            }
        }
    }

    public void gameOver(GameWorld gw) {
        for (int i = 0; i < cellRows - 0; i++) {
            for (int j = 0; j < cellCols; j++) {
                if (gw.getType(i, j) >= 0) {
                    cells[i][j].setColor(gw.getType(i, j));
                } else {
                    cells[i][j].setColor(-2); // Magic number, learn2loveit
                }
            }
        }
    }

    private void initCells(int cellrows, int cellcols, int cellwidth,
            int cellheight) {
        for (int i = 0; i < cellrows; i++) {
            for (int j = 0; j < cellcols; j++) {
                cells[i][j] = new Cell(this, i, j);
                cells[i][j].setPreferredSize(new Dimension(cellwidth,
                        cellheight));
                this.add(cells[i][j]);
            }
        }
    }

    public void clickBlock(int i, int j) {
        gw.clickBlock(i, j);
    }
}