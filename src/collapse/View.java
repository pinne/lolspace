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

class View extends JPanel {

    private Model model;
    private ArrayList<Block> blocks;

    public View(Model m) {
        super();
        this.model = m;

        // En grafisk representation av värdet
        blocks = new ArrayList<Block>();
        for (Block b : blocks)
            this.setPreferredSize(new Dimension(64, 64));

        // Skapa controllern, d v s lyssnaren
        Controller con = new Controller(model, this);

        this.add(new JLabel("Block "));
        // this.add(blocks);
        this.updateView();
    }

    // Metod för att uppdatera vyn
    public void updateView() {
        int val = model.getValue();
        for (Block b : blocks) {
            this.repaint();
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRect(0, 0, 32, 32);
    }
}