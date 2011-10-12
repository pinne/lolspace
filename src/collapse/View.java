/** Model-View-Controller exempel: Vyn.
 *  Denna klass visar flera vyer av modellen och
 *  gör det möjligt för användaren att på två olika sätt
 *  ändra i modellen.
 */

package collapse;

import java.awt.*;

import javax.swing.*;

public class View extends JPanel {

    private static final long serialVersionUID = 1L;
    private GameWorld gameworld;
    private JButton[][] buttons;
    private int cellRows;
    private int cellCols;

    public View(GameWorld world, int cellrows, int cellcols, int cellwidth,
            int cellheight) {
        super();
        this.setBackground(Color.DARK_GRAY);
        this.gameworld = world;
        this.cellRows = cellrows;
        this.cellCols = cellcols;
        this.setLayout(new GridLayout(16, 12));
        this.setPreferredSize(new Dimension(cellwidth * cellcols, cellheight
                * cellrows));

        buttons = new ViewCell[cellrows][cellcols];
        this.initCells(cellrows, cellcols, cellwidth, cellheight);
    }

    public void updateCells() {
        for (int i = 0; i < cellRows-1; i++) {
            for (int j = 0; j < cellCols; j++) {
                if (gameworld.isAlive(i, j)) {
                    ((ViewCell) buttons[i][j]).setAlive();
                    ((ViewCell) buttons[i][j]).setColor(gameworld.getType(i, j));
                }
                else {
                    ((ViewCell) buttons[i][j]).setDead();
                    ((ViewCell) buttons[i][j]).setColor(-1);
                }
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
}