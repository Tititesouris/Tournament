package tournament;

import java.awt.*;

/**
 * Created by Quentin Brault on 26/09/2015.
 */
public class Player implements Constants {

    private Board board;

    private int x, y;

    private int lifes;

    private Color color;

    public Player(Board board, int x, int y, Color color) {
        this.board = board;
        this.x = x;
        this.y = y;
        this.lifes = 3;
        this.color = color;
    }

    public boolean move(int x, int y) {
        Tile target = board.getTile(this.x + x, this.y + y);
        if (target != null && target instanceof Empty && !((Empty)target).hasBomb()) {
            this.x += x;
            this.y += y;
            if (target.isExploding()) {
                die();
            }
            return true;
        }
        return false;
    }

    public boolean die() {
        lifes--;
        return lifes > 0;
    }

    public boolean placeBomb() {
        Empty target = (Empty)board.getTile(this.x, this.y);
        return target.addBomb();
    }

    public void render(Graphics g) {
        g.setColor(color);
        g = g.create(x * TILE_SIZE, y * TILE_SIZE, (x + 1) * TILE_SIZE, (y + 1) * TILE_SIZE);
        g.fillRoundRect(TILE_SIZE / 8, TILE_SIZE / 8, TILE_SIZE - TILE_SIZE / 4, TILE_SIZE - TILE_SIZE / 4, 10, 10);
    }

}
