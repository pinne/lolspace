package collapse;

import java.awt.List;
import java.util.ArrayList;

public class GroupBlock extends List {

    private static final long serialVersionUID = 1L;
    private ArrayList<Block> blocks;

    public GroupBlock(Block newBlock) {
        blocks = new ArrayList<Block>();
        blocks.add(newBlock);
        System.out.println("Created new GroupBlock");
        System.out.println("Added first block " + newBlock.toString());
    }

    public void add(Block b) {
        System.out.println("Added block to group " + this.getName());
        blocks.add(b);
    }
}
