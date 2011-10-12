package collapse;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;

public class ViewCell extends JButton {

    private static final long serialVersionUID = 1L;
    private boolean alive;
    private Point cell;

    public ViewCell(GameWorld gameworld, View view, int x, int y) {
        alive = true;
        cell = new Point(x, y);
        this.setBackground(Color.DARK_GRAY);
        this.setOpaque(true);
        this.addActionListener(new Control(gameworld, view, cell));
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive() {
        this.setOpaque(false);
        this.alive = true;
    }

    public void setDead() {
        this.setOpaque(true);
        this.alive = false;
    }
}
