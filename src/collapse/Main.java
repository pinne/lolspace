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
        GameWorld world = new GameWorld();
        View view = new View(world);

        System.out.println("Main done.");
    }
}
