/*
 * Main
 * 
 * Copyright Simon Kers - KTH 2011.
 */

package lolspace;

import gui.MainPanel;

/**
 * 
 * @author simon
 * 
 */
public class Main {
    private final static String title = "lolspace!";
    private final static String filename = "lolspace.highscore";
    private final static int CELLROWS = 16;
    private final static int CELLCOLS = 12;
    private final static int CELLWIDTH = 32;
    private final static int CELLHEIGHT = 32;

    public static void main(String[] args) {
        new MainPanel(title, filename, CELLROWS, CELLCOLS, CELLWIDTH,
                CELLHEIGHT);
    }
}
