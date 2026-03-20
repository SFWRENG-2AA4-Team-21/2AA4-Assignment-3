package catan;

public class Robber {

    private Board board;
    private Tile currentTile;


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
            logger.info("Robber moved to tile " + tileId);
        } else {
            logger.info("Invalid tile ID.");
        }
    }

    public boolean checkBlock(Tile tile){
        return tile == currentTile;
    }


    
}