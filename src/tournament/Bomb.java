package tournament;

import java.awt.*;

/**
 * Created by Quentin Brault on 26/09/2015.
 */
public class Bomb implements Constants {

    private int countdown;

    public Bomb() {
        countdown = 10;
    }

    public void tick() {
        countdown--;
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(TILE_SIZE / 4, TILE_SIZE / 4, TILE_SIZE - TILE_SIZE / 2, TILE_SIZE - TILE_SIZE / 2);
        g.setColor(Color.WHITE);
        g.drawString(countdown + "", TILE_SIZE / 2 - 6, TILE_SIZE / 2 + 6);
    }

}
