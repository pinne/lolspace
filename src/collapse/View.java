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

    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private JButton[] buttons;

    private final static int CELLROWS = 16;
    private final static int CELLCOLS = 12;
    private final static int CELLWIDTH = 32;
    private final static int CELLHEIGHT = 32;

    public View(GameWorld m) {
        super();
        frame = new JFrame("Collapse");
        this.setLayout(new GridLayout(16, 12));

        frame.add(this);

        buttons = new JButton[CELLROWS * CELLCOLS];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setPreferredSize(new Dimension(CELLWIDTH, CELLHEIGHT));
            // buttons[i].addActionListener(bl);
            this.add(buttons[i]);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}