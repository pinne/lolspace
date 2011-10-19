package gui;

import highscore.HighScore;
import lolspace.GameWorld;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MainPanel extends JFrame implements Observer {

    private static final long serialVersionUID = 8250468227892863504L;
    private GameWorld gw;
    private HighScore highscore;
    private Menu menu;
    private CellGrid grid;
    private ScoreView scores;
    private int CELLROWS;
    private int CELLCOLS;
    private int CELLWIDTH;
    private int CELLHEIGHT;

    public MainPanel(String title, String filename, int cellRows, int cellCols,
            int cellWidth, int cellHeight) {

        super(title);
        this.CELLROWS = cellRows;
        this.CELLCOLS = cellCols;
        this.CELLWIDTH = cellWidth;
        this.CELLHEIGHT = cellHeight;

        this.gw = new GameWorld(this, cellRows, cellCols);
        grid = new CellGrid(gw, CELLCOLS, CELLROWS, CELLWIDTH, CELLHEIGHT);
        scores = new ScoreView(gw);
        menu = new Menu(this, gw);

        newGame();
        initHighScore();
        populatePanel();
    }

    private void initHighScore() {
        this.highscore = new HighScore(this);
    }

    public void setBoardSize(int cellCols, int cellRows) {
        this.CELLCOLS = cellCols;
        this.CELLROWS = cellRows;
    }

    private void populatePanel() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(CELLCOLS * CELLWIDTH, CELLROWS * CELLHEIGHT + 32);
        this.getContentPane().add(menu, BorderLayout.NORTH);
        this.getContentPane().add(grid, BorderLayout.CENTER);
        this.getContentPane().add(scores, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void newGame() {
        this.getContentPane().remove(menu);
        this.getContentPane().remove(grid);
        this.getContentPane().remove(scores);

        this.gw = new GameWorld(this, CELLROWS, CELLCOLS);
        this.grid = new CellGrid(gw, CELLCOLS, CELLROWS, CELLWIDTH, CELLHEIGHT);
        this.scores = new ScoreView(gw);

        new Control(gw, grid, scores);

        populatePanel();
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
        if (gw.isGameOver() && gw.isRunning()) {
            highscore.gameOver(gw.getScore());
            gw.setRunning(false);
        }
    }
}
