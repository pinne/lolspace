package collapse;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements ActionListener, MouseListener {

    private GameWorld gameworld = null;
    private View view;
    private Point cell;

    public Control(GameWorld gameworld, View view, Point cell) {
        this.gameworld = gameworld;
        this.view = view;
        this.cell = cell;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        gameworld.clickBlock(cell);
        view.updateCells();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
