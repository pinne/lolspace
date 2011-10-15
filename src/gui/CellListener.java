package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellListener implements ActionListener {

    private int i;
    private int j;
    private CellGrid grid;

    public CellListener(CellGrid grid, Cell cell, int i, int j) {
        this.i = i;
        this.j = j;
        this.grid = grid;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        grid.clickBlock(i, j);
    }
}
