/*
 * MainPanel
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package gui;

import highscore.HighScore;
import lolspace.GameWorld;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * 
 */
public class MainPanel extends JFrame implements Observer {

    private static final long serialVersionUID = 8250468227892863504L;
    private final static String TITLE = "lolspace!";
    private String FILENAME = "lolspace.highscore";
    private int CELLROWS = 16;
    private int CELLCOLS = 12;
    private final static int CELLWIDTH = 32;
    private final static int CELLHEIGHT = 32;
    private GameWorld gw;
    private CellGrid grid;
    private HighScore highscore;
    private Menu menu;
    private ScoreView scoreBar;

    public MainPanel() {
        super(TITLE);
        this.menu = new Menu(this);
        this.highscore = new HighScore(this, FILENAME);
        newGame();
    }

    public void newGame() {
        if (grid != null)
            this.getContentPane().remove(grid);
        if (scoreBar != null)
            this.getContentPane().remove(scoreBar);

        this.gw = new GameWorld(this, CELLROWS, CELLCOLS);
        this.grid = new CellGrid(CELLCOLS, CELLROWS, CELLWIDTH, CELLHEIGHT);
        this.scoreBar = new ScoreView();

        new Control(gw, grid, scoreBar);

        populatePanel();
        grid.update(gw);
    }

    public void setBoardSize(int cellCols, int cellRows) {
        this.CELLCOLS = cellCols;
        this.CELLROWS = cellRows;
    }

    public void showHighscore() {
        JTextArea scoreTextArea = new JTextArea(highscore.getHighscoreString());
        scoreTextArea.setOpaque(false);
        scoreTextArea.setEditable(false);
        JOptionPane.showMessageDialog(this, (scoreTextArea), "High Score",
                JOptionPane.PLAIN_MESSAGE, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.gw = (GameWorld) o;

        scoreBar.update(gw);
        grid.update(o);

        if (gw.isGameOver() && gw.isRunning()) {
            highscore.gameOver(gw.getScore());
            gw.setRunning(false);
        }
    }
    
    private void populatePanel() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(CELLCOLS * CELLWIDTH, CELLROWS * CELLHEIGHT + 32);
        this.getContentPane().add(menu, BorderLayout.NORTH);
        this.getContentPane().add(grid, BorderLayout.CENTER);
        this.getContentPane().add(scoreBar, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
