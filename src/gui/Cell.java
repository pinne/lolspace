/*
 * ViewCell
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 * 
 * @author simon
 * 
 */
public class Cell extends JButton {

    private static final long serialVersionUID = 1L;
    private static final int EMPTY = -1;
    private static final int GAMEOVER = -2;
    private static final int ALMOSTGAMEOVER = -3;

    public Cell(CellGrid grid, int i, int j) {
        this.setBackground(Color.LIGHT_GRAY);
        setBorderPainted(false);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackline);
        setDead();
        this.addActionListener(new CellListener(grid, this, i, j));
    }

    public void setDead() {
        setColor(EMPTY);
    }

    public void setColor(int type) {
        Color darkerlightcyan = new Color(212, 245, 245);
        Color lightcyan = new Color(224, 255, 255);
        Color grayish = new Color(175, 185, 185);
        Color hotpink = new Color(255, 105, 180);
        Color lightskyblue = new Color(135, 206, 250);
        Color orange = new Color(255, 165, 0);
        Color palegreen = new Color(152, 251, 152);

        switch (type) {
        case ALMOSTGAMEOVER:
            this.setBackground(darkerlightcyan);
            break;
        case GAMEOVER: // -2
            this.setBackground(grayish);
            break;
        case EMPTY: // -1
            this.setBackground(lightcyan);
            break;
        case 0:
            this.setBackground(hotpink);
            break;
        case 1:
            this.setBackground(lightskyblue);
            break;
        case 2:
            this.setBackground(orange);
            break;
        case 3:
            this.setBackground(palegreen);
            break;
        }
    }
}
