package tournament;

import java.awt.*;

/**
 * Created by Quentin Brault on 26/09/2015.
 */
public class Box extends Tile {

    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "@";
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, TILE_SIZE, TILE_SIZE);
        super.render(g);
    }

}
