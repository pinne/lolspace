package collapse;

import java.awt.Point;
import java.util.ArrayList;

public class GameWorld {
    private Block[][] blocks = null;
    private ArrayList<GroupBlock> groupBlocks;
    private int cellRows;
    private int cellCols;

    public GameWorld(int cellRows, int cellCols) {
        this.cellRows = cellRows;
        this.cellCols = cellCols;
        blocks = new Block[cellRows][cellCols];
        groupBlocks = new ArrayList<GroupBlock>();
        fillWithBlocks();
        createGroup();
    }

    public void fillWithBlocks() {
        for (int i = 0; i < cellRows; i++) {
            for (int j = 0; j < cellCols; j++) {
                blocks[i][j] = new Block(i, j);
            }
        }
    }

    // TODO: big fucking todo, rekursiv algoritm?
    public void createGroup() {
        int k = 0;

        for (int i = 1; i < cellRows - 1; i++) {
            for (int j = 1; j < cellCols - 1; j++) {
                Block current = blocks[i][j];

                if (current.compareTo(blocks[i-1][j-1]) == 0)
                    ;
                if (current.compareTo(blocks[i-1][j]) == 0)
                    ;
                if (current.compareTo(blocks[i-1][j+1]) == 0)
                    ;
                if (current.compareTo(blocks[i][j-1]) == 0)
                    ;
                if (current.compareTo(blocks[i][j+1]) == 0)
                    ;
                if (current.compareTo(blocks[i+1][j]) == 0)
                    ;
                if (current.compareTo(blocks[i+1][j+1]) == 0)
                    ;
                if (!current.isVisited()) {
                    System.out.println("Found group");
                    groupBlocks.add(new GroupBlock(current));
                }
            }
        }
    }

    public boolean isAlive(int i, int j) {
        return blocks[i][j].isAlive();
    }
    
    public int getType(int i, int j) {
        return blocks[i][j].getType();
    }

    public void clickBlock(Point cell) {
        System.out.println(cell.toString());
        blocks[cell.x][cell.y].toggle();
    }
}
