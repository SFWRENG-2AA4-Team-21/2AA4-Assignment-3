package catan;
import java.util.logging.Logger;

public class Robber {

    private Board board;
    private Tile currentTile;

    private static final Logger LOGGER = Logger.getLogger(Robber.class.getName());
    public Robber(Board board, Tile startTile){
        this.board = board; 
        this.currentTile = startTile;
    }

    public Tile getCurrentTile() {
        return currentTile;
    }

    public void moveTile (int tileId){
        Tile newTile = board.getTile(tileId);

        if (newTile != null) {
            currentTile = newTile;
            LOGGER.info("Robber moved to tile " + tileId);
        } else {
            LOGGER.info("Invalid tile ID.");
        }
    }

    public boolean checkBlock(Tile tile){
        return tile == currentTile;
    }


    
}