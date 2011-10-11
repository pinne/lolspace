package collapse;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Cell extends JButton implements ActionListener {
    private Control controller;
    private boolean alive;
    private int cellX;
    private int cellY;

    public Cell(int x, int y) {
        alive = true;
        this.cellX = x;
        this.cellY = y;
        this.setBackground(Color.DARK_GRAY);
        this.setOpaque(true);
        this.addActionListener(this);
    }

    public boolean isAlive() {
        this.setOpaque(true);
        return alive;
    }

    public void setDead() {
        // this.setOpaque(false);
        this.setVisible(false);
        this.setEnabled(false);
        this.alive = false;
    }

    public void cellClicked() {
        controller.setClicked();
    }

    public void cellClicked(Object source) {
        System.out.println(source);
    }

    public void actionPerformed(ActionEvent e) {
        cellClicked();
    }
}
