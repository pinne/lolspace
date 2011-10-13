package collapse;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {

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
        if (gameworld.clickBlock(cell))
            view.updateCells();
    }
}
