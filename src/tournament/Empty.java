package tournament;

import java.awt.*;

/**
 * Created by Quentin Brault on 26/09/2015.
 */
public class Empty extends Tile {

    private Bomb bomb;

    public Empty(int x, int y) {
        super(x, y);
    }

    public boolean addBomb() {
        if (bomb == null) {
            bomb = new Bomb();
            return true;
        }
        return false;
    }

    @Override
    public void explode() {
        bomb = null;
        super.explode();
    }

    public Bomb getBomb() {
        return bomb;
    }

    public boolean hasBomb() {
        return bomb != null;
    }

    @Override
    public String toString() {
        return " ";
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, TILE_SIZE, TILE_SIZE);
        if (bomb != null) {
            bomb.render(g);
        }
        super.render(g);
    }

}
