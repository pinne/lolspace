/*
 * Control
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import collapse.GameWorld;

/**
 * 
 * @author simon
 *
 */
public class Control implements ActionListener {

    private GameWorld gameworld = null;
    private WindowPanel panel = null;
    private int i;
    private int j;

    public Control(GameWorld gameworld, WindowPanel panel, int i, int j) {
        this.gameworld = gameworld;
        this.panel = panel;
        this.i = i;
        this.j = j;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameworld.clickBlock(i, j)) {
            panel.updateViews();
        }
    }
}
