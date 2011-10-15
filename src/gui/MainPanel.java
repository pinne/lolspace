package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import lolspace.GameWorld;

public class MainPanel extends JFrame {

    private static final long serialVersionUID = 8250468227892863504L;

    public MainPanel(String title, int cellRows, int cellCols, int cellWidth,
            int cellHeight) {

        super(title);
        GameWorld gw = new GameWorld(cellRows, cellCols);
        CellGrid grid = new CellGrid(gw, cellCols, cellRows, cellWidth,
                cellHeight);
        ScoreView scores = new ScoreView(gw);
        Menu menu = new Menu(this, gw);
        new Control(gw, grid, scores);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(cellCols * cellWidth, cellRows * cellHeight + 32);
        this.getContentPane().add(menu, BorderLayout.NORTH);
        this.getContentPane().add(grid, BorderLayout.CENTER);
        this.getContentPane().add(scores, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
