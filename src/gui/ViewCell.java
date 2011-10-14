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

import collapse.GameWorld;

/**
 * 
 * @author simon
 *
 */
public class ViewCell extends JButton {

    private static final long serialVersionUID = 1L;
    private boolean alive;
    private static final int DEAD = -1;
    private static final int BLOOD = -2;

    public ViewCell(GameWorld gameworld, WindowPanel panel, int i, int j) {
        this.setBackground(Color.LIGHT_GRAY);
        setColor(gameworld.getType(i, j));
        setBorderPainted(false);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackline);
        setDead();
        this.addActionListener(new Control(gameworld, panel, i, j));
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
        case BLOOD:
            this.setBackground(Color.RED);
            break;
        case DEAD:
            this.setBackground(Color.LIGHT_GRAY);
            break;
        case 0:
            this.setBackground(hotpink);
            this.setForeground(palegreen);
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
