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
public class WindowPanel extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private View view;
    private ScoreView scores;
    private Menu menu;

    public WindowPanel(String title, GameWorld gw, int cellrows, int cellcols,
            int cellwidth, int cellheight) {
        super(title);

        this.view = new View(gw, this, cellrows, cellcols, cellwidth,
                cellheight);
        this.scores = new ScoreView(gw);
        this.menu = new Menu(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(cellcols * cellheight, cellrows * cellwidth);
        this.getContentPane().add(view, BorderLayout.CENTER);
        this.getContentPane().add(scores, BorderLayout.SOUTH);
        this.getContentPane().add(menu, BorderLayout.NORTH);
        this.setVisible(true);
    }

    public void updateViews() {
        view.updateCells();
        scores.updateScore();
    }
}
