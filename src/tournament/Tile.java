package tournament;

import java.awt.*;

/**
 * Created by Quentin Brault on 26/09/2015.
 */
public abstract class Tile implements Constants {

    protected int x, y;

    protected boolean exploding;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void explode() {
        exploding = true;
    }

    public boolean isExploding() {
        return exploding;
    }

    public abstract String toString();

    public void render(Graphics g) {
        if (exploding) {
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, TILE_SIZE, TILE_SIZE);
        }
    }
}
