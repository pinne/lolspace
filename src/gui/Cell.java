/*
 * ViewCell
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 * 
 * @author simon
 * 
 */
public class Cell extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;
    private CellGrid grid;
    private int i;
    private int j;
    private boolean alive;
    private static final int EMPTY = -1;
    private static final int BLOOD = -2;

    public Cell(CellGrid grid, int i, int j) {
        this.grid = grid;
        this.i = i;
        this.j = j;
        this.setBackground(Color.LIGHT_GRAY);
        setBorderPainted(false);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackline);
        setDead();
        this.addActionListener(new CellListener(grid, this, i, j));
    }

    public boolean isAlive() {
        return alive;
    }

    public void setDead() {
        setColor(EMPTY);
    }

    public void setColor(int type) {
        Color lightcyan = new Color(224, 255, 255);
        Color red = new Color(185, 40, 20);
        Color hotpink = new Color(255, 105, 180);
        Color lightskyblue = new Color(135, 206, 250);
        Color orange = new Color(255, 165, 0);
        Color palegreen = new Color(152, 251, 152);

        switch (type) {
        case BLOOD: // -2
            this.setBackground(red);
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

    public void actionPerformed(ActionEvent e) {
        grid.clickBlock(i, j);
    }
}
