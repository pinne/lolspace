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
    private ViewCell[][] cells;
    private int cellRows;
    private int cellCols;

    public View(GameWorld world, int cellrows, int cellcols, int cellwidth,
                                                  int cellheight) {
        super();
        this.setBackground(Color.DARK_GRAY);
        this.gameworld = world;
        this.cellRows = cellrows;
        this.cellCols = cellcols;
        this.setLayout(new GridLayout(cellrows, cellcols));
        this.setPreferredSize(new Dimension(cellwidth * cellcols, cellheight
                * cellrows));

        cells = new ViewCell[cellrows][cellcols];
        this.initCells(cellrows, cellcols, cellwidth, cellheight);
        updateCells();
    }

    private void initCells(int cellrows, int cellcols, int cellwidth,
            int cellheight) {
        for (int i = 0; i < cellrows; i++) {
            for (int j = 0; j < cellcols; j++) {
                cells[i][j] = new ViewCell(gameworld, this, i, j);
                cells[i][j].setPreferredSize(new Dimension(cellwidth,
                        cellheight));
                this.add(cells[i][j]);
            }
        }
    }

    public void updateCells() {
        for (int i = 0; i < cellRows - 0; i++) {
            for (int j = 0; j < cellCols; j++) {
                if (gameworld.getType(i, j) >= 0) {
                    cells[i][j].setAlive();
                    cells[i][j].setColor(gameworld.getType(i, j));
                } else {
                    cells[i][j].setDead();
                    cells[i][j].setColor(-1);
                }
            }
        }
    }
    
//    public void updateCells() {
//        for (int i = 0; i < cellRows - 0; i++) {
//            for (int j = 0; j < cellCols; j++) {
//                if (gameworld.isAlive(i, j)) {
//                    cells[i][j].setAlive();
//                    cells[i][j].setColor(gameworld.getType(i, j));
//                } else {
//                    cells[i][j].setDead();
//                    cells[i][j].setColor(-1);
//                }
//            }
//        }
//    }
}