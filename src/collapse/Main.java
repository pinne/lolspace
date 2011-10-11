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
    public static void main(String[] args) {
        JFrame frame = new JFrame("Collapse");
        GameWorld world = new GameWorld();
        View view = new View(world);
        JMenuBar menu = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        menu.add(fileMenu);
        JMenuItem newItem = new JMenuItem("New game");
        JMenuItem quitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(quitItem);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menu);
        frame.add(view);
        frame.pack();
        frame.setVisible(true);

        System.out.println("Main done.");
    }
}
