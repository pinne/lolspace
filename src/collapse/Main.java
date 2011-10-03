/*
 * Main
 * 
 * Copyright Simon Kers - KTH 2011.
 */

package collapse;

import javax.swing.JFrame;

/**
 *  
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model(0, 100);
        View view = new View(model);

        JFrame frame = new JFrame("Collapse");
        frame.getContentPane().add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(384, 512);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
