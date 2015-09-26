package tournament;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Quentin Brault on 26/09/2015.
 */
public class BoardMouseListener implements Constants, MouseListener {

    private Board board;

    public BoardMouseListener(Board board) {
        this.board = board;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (8 + LEFT_PADDING <= e.getX() && 31 + TOP_PADDING <= e.getY()) {
            int x = (e.getX() - LEFT_PADDING - 8) / TILE_SIZE;
            int y = (e.getY() - TOP_PADDING - 31) / TILE_SIZE;
            if (x < BOARD_WIDTH && y < BOARD_HEIGHT) {
                board.explode(x, y);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
