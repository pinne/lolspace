/** Model-View-Controller exempel: Vyn.
 *  Denna klass visar flera vyer av modellen och
 *  gör det möjligt för användaren att på två olika sätt
 *  ändra i modellen.
 */

package collapse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private GameWorld gameworld;
    private JButton[][] buttons;
    private int cellrows;
    private int cellcols;

    public View(GameWorld world, int cellrows, int cellcols, int cellwidth,
            int cellheight) {
        super();
        this.setBackground(Color.DARK_GRAY);
        this.gameworld = world;
        this.cellrows = cellrows;
        this.cellcols = cellcols;
        this.setLayout(new GridLayout(16, 12));
        this.setPreferredSize(new Dimension(cellwidth * cellcols, cellheight
                * cellrows));

        buttons = new ViewCell[cellrows][cellcols];
        this.initCells(cellrows, cellcols, cellwidth, cellheight);
    }

    public void updateCells() {
        for (int i = 0; i < this.cellrows; i++)
            for (int j = 0; j < this.cellcols; j++) {
                if (gameworld.isAlive(i, j)) {
                    buttons[i][j].setOpaque(true);
                } else {
                    buttons[i][j].setOpaque(false);
                }
            }
    }

    private void initCells(int cellrows, int cellcols,
                              int cellwidth, int cellheight) {
        for (int i = 0; i < cellrows; i++) {
            for (int j = 0; j < cellcols; j++) {
                buttons[i][j] = new ViewCell(gameworld, this, i, j);
                buttons[i][j].setPreferredSize(new Dimension(cellwidth,
                        cellheight));
                this.add(buttons[i][j]);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action View");
        this.updateCells();
    }
}