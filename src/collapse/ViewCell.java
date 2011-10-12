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
        setColor(gameworld.getType(x, y));
        this.addActionListener(new Control(gameworld, view, cell));
    }

    private void setColor(int type) {
        switch (type) {
        case 0:
            this.setBackground(Color.RED);
            break;
        case 1:
            this.setBackground(Color.BLUE);
            break;
        case 2:
            this.setBackground(Color.GREEN);
            break;
        case 3:
            this.setBackground(Color.WHITE);
            break;
        }
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
