package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {
    private JFrame frame;
    private View panel;
    private static final long serialVersionUID = -5617155576631422259L;
    private String[] instructionsText = { "lolspace!" + "\n\n",
            "A turn-based puzzle game." + "\n\n",

            "By clicking groups of 3 blocks or more,",
            "the group is destroyed and any blocks",
            "stacked above will collapse down.",
            "With each click a new row of blocks",
            " appear from the bottom, the game is ",
            "over when the blocks reach the top of",
            "the board." + "\n\n",

            "Each destroyed group gives a score of",
            "n^1.5 where n is the number of blocks,",
            "the decimal part always rounds down.",
            "Players compete to beat the high score." };

    private String[] creditsText = { "lolspace!", " ",
            "\u00a9 pinne - Varm kod", "STHD Fame - KTH 2011" };

    public Menu(View frame) {
        this.frame = frame;
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
        JMenuItem smallItem = new JMenuItem("Small 12x16");
        smallItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                panel.setSize(12, 16);
            }
        });
        JMenuItem mediumItem = new JMenuItem("Medium 24x32");
        mediumItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });
        JMenuItem largeItem = new JMenuItem("Large 64x64");
        largeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });
        JMenuItem highScoreItem = new JMenuItem("High score");
        highScoreItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

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
                JOptionPane.showMessageDialog(frame, instructionsText,
                        "Instructions", JOptionPane.PLAIN_MESSAGE, null);
            }
        });
        helpMenu.add(instructionsItem);

        JMenuItem creditsItem = new JMenuItem("Credits");
        creditsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(frame, creditsText, "Credits",
                        JOptionPane.PLAIN_MESSAGE, null);
            }
        });
        helpMenu.add(creditsItem);

        return helpMenu;
    }
}
