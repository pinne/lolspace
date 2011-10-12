package collapse;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;

public class ViewCell extends JButton {

    private static final long serialVersionUID = 1L;
    private boolean alive;
    private Point cell;

    public ViewCell(GameWorld gameworld, View view, int i, int j) {
        cell = new Point(i, j);
        this.setBackground(Color.LIGHT_GRAY);
        setColor(gameworld.getType(i, j));
        setBorderPainted(false);
        setDead();
        this.addMouseListener(new Control(gameworld, view, cell));
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive() {
        this.setOpaque(true);
        this.alive = true;
    }

    public void setDead() {
        this.setOpaque(false);
        this.alive = false;
        this.setColor(-1);
    }

    public void setColor(int type) {
        Color hotpink = new Color(255, 105, 180);
        Color lightskyblue = new Color(135, 206, 250);
        Color orange = new Color(255, 165, 0);
        Color palegreen = new Color(152, 251, 152);

        switch (type) {
        case -1:
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
