/* Model-View-Controller: Controller.
 * Controllern är länken mellan det grafiska gränsnittet, vyn,
 * och modellen. Kontrollern tar emot händelser från vyn och
 * uppdaterar modellen. Kontrollern ser också till att vyn
 * uppdateras då modellen ändrats.
 */

package collapse;

import javax.swing.JOptionPane;
import java.awt.event.*;

import javax.swing.event.*;

// JSlider -> ChangeEvent och ChangeListener

public class Controller implements ActionListener, ChangeListener {

    private View view;
    private Model model;

    public Controller(Model m, View v) {
        this.model = m;
        this.view = v;
    }

    // Denna metod kommer att anropas av javatolken
    // då användaren rör slidern
    public void stateChanged(ChangeEvent e) {
        view.updateView();
    }

    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}