/*
 * Control
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author simon
 *
 */
public class Control implements ActionListener {

    private View view = null;
    private int i;
    private int j;

    public Control(View view, int i, int j) {
        this.view = view;
        this.i = i;
        this.j = j;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (view.clickBlock(i, j)) {
            view.updateViews();
        }
    }
}
