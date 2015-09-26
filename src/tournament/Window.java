package tournament;

import javax.swing.*;

/**
 * Created by Quentin Brault on 26/09/2015.
 */
public class Window extends JFrame {

    public Window() {
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Panel panel = new Panel();
        setContentPane(panel);
        addKeyListener(new BoardKeyListener(panel.getBoard()));
        addMouseListener(new BoardMouseListener(panel.getBoard()));
    }

    public static void main(String[] args) {
        new Window();
    }

}
