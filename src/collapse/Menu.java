package collapse;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Menu() {
        super("Menu example");

        JMenu file = new JMenu("File");
        file.setMnemonic('F');
        JMenuItem newItem = new JMenuItem("New");
        newItem.setMnemonic('N');
        file.add(newItem);
        JMenuItem openItem = new JMenuItem("Open");
        openItem.setMnemonic('O');
        file.add(openItem);
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('x');
        file.add(exitItem);

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(file);

        getContentPane();
        setSize(200, 200);
        setVisible(true);
    }

}
