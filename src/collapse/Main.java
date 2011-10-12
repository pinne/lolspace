/*
 * Main
 * 
 * Copyright Simon Kers - KTH 2011.
 */

package collapse;

import javax.swing.*;

/**
 *  
 */
public class Main {
    private final static int CELLROWS = 16;
    private final static int CELLCOLS = 12;
    private final static int CELLWIDTH = 32;
    private final static int CELLHEIGHT = 32;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Collapse");
        GameWorld world = new GameWorld(CELLROWS, CELLCOLS);
        View view = new View(world, CELLROWS, CELLCOLS, CELLWIDTH, CELLHEIGHT);
        JMenuBar menu = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        menu.add(fileMenu);
        JMenuItem newItem = new JMenuItem("New game");
        JMenuItem quitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(quitItem);

        JMenu helpMenu = new JMenu("Help");
        menu.add(helpMenu);
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menu);
        frame.add(view);
        frame.pack();
        frame.setVisible(true);

        System.out.println("Main done.");
    }
}
