package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {
    private JFrame frame;
    private static final long serialVersionUID = -5617155576631422259L;

    public Menu(JFrame frame) {
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
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        helpMenu.add(aboutItem);

        return helpMenu;
    }
}
