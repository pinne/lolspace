/** Model-View-Controller exempel: Vyn.
 *  Denna klass visar flera vyer av modellen och
 *  gör det möjligt för användaren att på två olika sätt
 *  ändra i modellen.
 */

package collapse;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

public class View extends JPanel {

    private static final long serialVersionUID = 1L;
    private GameWorld gameworld;
    private JButton[][] buttons;

    private final static int CELLROWS = 16;
    private final static int CELLCOLS = 12;
    private final static int CELLWIDTH = 32;
    private final static int CELLHEIGHT = 32;

    public View(GameWorld m) {
        super();
        this.setLayout(new GridLayout(16, 12));
        this.setPreferredSize(new Dimension(CELLWIDTH * CELLCOLS, CELLHEIGHT
                * CELLROWS));

        buttons = new Cell[CELLROWS][CELLCOLS];
        this.initCells();
    }

    private void initCells() {
        for (int i = 0; i < CELLROWS; i++) {
            for (int j = 0; j < CELLCOLS; j++) {
                buttons[i][j] = new Cell(i, j);
                buttons[i][j].setPreferredSize(new Dimension(CELLWIDTH,
                        CELLHEIGHT));
                this.add(buttons[i][j]);
            }
        }
    }
}