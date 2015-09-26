package tournament;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Quentin Brault on 26/09/2015.
 */
public class BoardKeyListener implements KeyListener {

    private Board board;

    public BoardKeyListener(Board board) {
        this.board = board;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        boolean action = false;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                action = board.getPlayer().move(0, -1);
                break;
            case KeyEvent.VK_D:
                action = board.getPlayer().move(1, 0);
                break;
            case KeyEvent.VK_S:
                action = board.getPlayer().move(0, 1);
                break;
            case KeyEvent.VK_A:
                action = board.getPlayer().move(-1, 0);
                break;
            case KeyEvent.VK_ALT:
                action = board.getPlayer().placeBomb();
                break;
/*
            case KeyEvent.VK_UP:
                action = board.getPlayer(1).move(0, -1);
                break;
            case KeyEvent.VK_RIGHT:
                action = board.getPlayer(1).move(1, 0);
                break;
            case KeyEvent.VK_DOWN:
                action = board.getPlayer(1).move(0, 1);
                break;
            case KeyEvent.VK_LEFT:
                action = board.getPlayer(1).move(-1, 0);
                break;
            case KeyEvent.VK_SHIFT:
                action = board.getPlayer(1).placeBomb();
                break;*/
        }
        if (action) {
            board.nextTurn();
        }
    }
}
