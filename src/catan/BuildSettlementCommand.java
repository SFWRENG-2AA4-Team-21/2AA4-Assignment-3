//Settlement command implementation

package catan;

import java.util.logging.Logger;

public class BuildSettlementCommand implements Command{
    private Node node;
    private Player player;
    @SuppressWarnings("unused")
    private Board board;

    Logger logger = Logger.getLogger(BuildSettlementCommand.class.getName());


    public BuildSettlementCommand (Node node, Player player, Board board) {
        this.node = node;
        this.player = player;
        this.board = board;
    }

    @Override
    public void execute() {
        if (!node.hasBuilding()) {
            node.placeBuilding(new Settlement(player));
            player.addVictoryPoints(1);
            logger.info("Settlement built at Node " + node.getId());
        }

    }

    @Override
    public void undo() {
        node.placeBuilding(null);
        player.addVictoryPoints(-1);
        logger.info("Undo settlement at Node " + node.getId());
    }
}