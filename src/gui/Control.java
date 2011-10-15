/*
 * Control
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lolspace.GameWorld;


/**
 * 
 * @author simon
 * 
 */
public class Control implements ActionListener {

    private GameWorld gw;
    private CellGrid view;
    private ScoreView viewScores;

    public Control(GameWorld gw, CellGrid grid, ScoreView scores) {
        this.gw = gw;
        this.view = grid;
        this.viewScores = scores;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.update(gw, null);
        viewScores.update(gw, null);
    }
}
