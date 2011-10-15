/*
 * Main
 * 
 * Copyright Simon Kers - KTH 2011.
 */

package lolspace;

import java.awt.EventQueue;

import gui.MainPanel;

/**
 * 
 * @author simon
 * 
 */
public class Main {
    private final static String title = "lolspace!";
    private final static int CELLROWS = 16;
    private final static int CELLCOLS = 12;
    private final static int CELLWIDTH = 32;
    private final static int CELLHEIGHT = 32;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().create();
            }
        });

        System.out.println("Main done.");
    }

    private void create() {
        new MainPanel(title, CELLROWS, CELLCOLS, CELLWIDTH, CELLHEIGHT);
    }
}
