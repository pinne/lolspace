/*
 * Main
 * 
 * Copyright Simon Kers - KTH 2011.
 */

package collapse;

import gui.View;

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
        GameWorld gw = new GameWorld(CELLROWS, CELLCOLS);
        new View(title, gw, CELLROWS, CELLCOLS, CELLWIDTH, CELLHEIGHT);

        System.out.println("Main done.");
    }
}
