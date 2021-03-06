/*
 * Menu
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {
    private MainPanel panel;
    private static final long serialVersionUID = -5617155576631422259L;
    private static final String[] INSTRUCTIONS_TEXT = { "lolspace!" + "\n\n",
            "A turn-based puzzle game." + "\n\n",

            "By clicking groups of 3 blocks or more,",
            "the group is destroyed and any blocks",
            "stacked above will collapse down.",
            "With each click a new row of blocks",
            " appear from the bottom, the game is ",
            "over when the blocks reach the top of", "the board." + "\n\n",

            "Each destroyed group gives a score of",
            "n^1.5 where n is the number of blocks,",
            "the decimal part always rounds down." + "\n\n",

            "Players compete to beat the high score." };

    private static final String[] CREDITSTEXT = { "lolspace!", " ",
            "\u00a9 pinne - Varm kod", "STHD Fame - KTH 2011." + "\n\n",
            "thanks to", "linda, davve, koden,", "freppe & #styrelserummet." };

    public Menu(MainPanel panel) {
        this.panel = panel;
        JMenu fileMenu = getFileMenu();
        this.add(fileMenu);
        JMenu gameMenu = getGameMenu();
        this.add(gameMenu);
        JMenu helpMenu = getHelpMen();
        this.add(helpMenu);
    }

    private JMenu getFileMenu() {
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New game");
        newItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                panel.newGame();
            }
        });

        JMenuItem quitItem = new JMenuItem("Exit");
        quitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        fileMenu.add(newItem);
        fileMenu.add(quitItem);

        return fileMenu;
    }

    private JMenu getGameMenu() {
        JMenu gameMenu = new JMenu("Game");
        this.add(gameMenu);
        JMenu sizeItem = new JMenu("Size");
        JMenuItem smallItem = new JMenuItem("Small 8x12");
        smallItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                panel.setBoardSize(8, 12);
                panel.newGame();
            }
        });
        JMenuItem mediumItem = new JMenuItem("Medium 12x16");
        mediumItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                panel.setBoardSize(12, 16);
                panel.newGame();
            }
        });
        JMenuItem largeItem = new JMenuItem("Large 16x16");
        largeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                panel.setBoardSize(16, 16);
                panel.newGame();
            }
        });
        JMenuItem highScoreItem = new JMenuItem("High score");
        highScoreItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                panel.showHighscore();
            }
        });

        gameMenu.add(sizeItem);
        sizeItem.add(smallItem);
        sizeItem.add(mediumItem);
        sizeItem.add(largeItem);
        gameMenu.add(highScoreItem);

        return gameMenu;
    }

    private JMenu getHelpMen() {
        JMenu helpMenu = new JMenu("Help");
        this.add(helpMenu);

        JMenuItem instructionsItem = new JMenuItem("Instructions");
        instructionsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(panel, INSTRUCTIONS_TEXT,
                        "Instructions", JOptionPane.PLAIN_MESSAGE, null);
            }
        });
        helpMenu.add(instructionsItem);

        JMenuItem creditsItem = new JMenuItem("Credits");
        creditsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(panel, CREDITSTEXT, "Credits",
                        JOptionPane.PLAIN_MESSAGE, null);
            }
        });
        helpMenu.add(creditsItem);

        return helpMenu;
    }
}
