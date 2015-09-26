package tournament;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Quentin Brault on 26/09/2015.
 */
public class Panel extends JPanel implements Constants {

    private Board board;

    public Panel() {
        board = new Board();
        setVisible(true);
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                revalidate();
                repaint();
            }
        });
        timer.start();
    }

    public Board getBoard() {
        return board;
    }

    private void update() {
        board.update();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        board.render(g.create(LEFT_PADDING, TOP_PADDING, 64 * 11, 64 * 11));
    }

}
