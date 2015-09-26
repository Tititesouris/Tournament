package tournament;

import java.awt.*;

/**
 * Created by Quentin Brault on 26/09/2015.
 */
public class Board implements Constants {

    private Tile[][] tiles;

    private Player[] players;

    private int turns;

    public Board() {
        tiles = new Tile[BOARD_HEIGHT][BOARD_WIDTH];
        for (int y = 0; y < BOARD_HEIGHT; y++) {
            for (int x = 0; x < BOARD_WIDTH; x++) {
                if (x % 2 == 1 && y % 2 == 1) {
                    tiles[y][x] = new Wall(x, y);
                }
                else if (x <= 1 && y <= 1 || BOARD_WIDTH - 2 <= x && BOARD_HEIGHT - 2 <= y) {
                    tiles[y][x] = new Empty(x, y);
                }
                else {
                    tiles[y][x] = new Box(x, y);
                }
            }
        }

        players = new Player[2];
        players[0] = new Player(this, 0, 0, Color.BLUE);
        players[1] = new Player(this, BOARD_WIDTH - 1, BOARD_HEIGHT - 1, Color.RED);
    }

    public void nextTurn() {
        turns++;
        for (int y = 0; y < BOARD_HEIGHT; y++) {
            for (int x = 0; x < BOARD_WIDTH; x++) {
                if (tiles[y][x] instanceof Empty && ((Empty)tiles[y][x]).hasBomb()) {
                    ((Empty)tiles[y][x]).getBomb().tick();
                }
            }
        }
    }

    public void explode(int x, int y) {
        if (tiles[y][x] instanceof Empty && ((Empty)tiles[y][x]).hasBomb()) {
            tiles[y][x].explode();
            int u = 0;
            do {
                u++;
                if (getTile(x - u, y) != null) { getTile(x - u, y).explode(); }
            }
            while (getTile(x - u, y) instanceof Empty);
            int r = 0;
            do {
                r++;
                if (getTile(x + r, y) != null) { getTile(x + r, y).explode(); }
            }
            while (getTile(x + r, y) instanceof Empty);
            int d = 0;
            do {
                d++;
                if (getTile(x + d, y) != null) { getTile(x + d, y).explode(); }
            }
            while (getTile(x, y + d) instanceof Empty);
            int l = 0;
            do {
                l++;
                if (getTile(x - l, y) != null) { getTile(x - l, y).explode(); }
            }
            while (getTile(x - l, y) instanceof Empty);
        }
    }

    public Player getPlayer(int i) {
        return players[i];
    }

    public Player getPlayer() {
        return players[turns%2];
    }

    public Tile getTile(int x, int y) {
        if (0 <= x && 0 <= y && x < BOARD_WIDTH && y < BOARD_HEIGHT) {
            return tiles[y][x];
        }
        return null;
    }

    public String toString() {
        String board = "";
        for (int y = 0; y < BOARD_HEIGHT; y++) {
            for (int x = 0; x < BOARD_WIDTH; x++) {
                board += tiles[y][x];
            }
            board += "\n";
        }
        return board;
    }

    public void update() {

    }

    public void render(Graphics g) {
        for (int y = 0; y < BOARD_HEIGHT; y++) {
            for (int x = 0; x < BOARD_WIDTH; x++) {
                tiles[y][x].render(g.create(x * TILE_SIZE, y * TILE_SIZE, (x + 1) * TILE_SIZE, (y + 1) * TILE_SIZE));
            }
        }
        for (Player player : players) {
            player.render(g);
        }
    }

}
