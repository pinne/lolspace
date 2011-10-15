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
    private boolean alive;
    private static final int EMPTY = -1;
    private static final int BLOOD = -2;
    private static final int BLACK = -3;

    public Cell(View view, int i, int j) {
        this.setBackground(Color.LIGHT_GRAY);
        setColor(view.getType(i, j));
        setBorderPainted(false);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackline);
        setDead();
        this.addActionListener(new Control(view, i, j));
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive() {
        this.setColor(2);
        this.setOpaque(true);
        this.alive = true;
    }

    public void setDead() {
        this.setOpaque(true);
        this.alive = false;
        this.setColor(-1);
    }

    public void setColor(int type) {
        Color hotpink = new Color(255, 105, 180);
        Color lightskyblue = new Color(135, 206, 250);
        Color orange = new Color(255, 165, 0);
        Color palegreen = new Color(152, 251, 152);

        switch (type) {
        case BLACK: // -3
            this.setBackground(Color.BLACK);
            break;
        case BLOOD: // -2
            this.setBackground(Color.RED);
            break;
        case EMPTY: // -1
            this.setBackground(Color.LIGHT_GRAY);
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
