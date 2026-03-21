//Settlement command implementation

package catan;

import java.util.logging.Logger;

public class BuildSettlementCommand implements Command{
    private Node node;
    private Player player;

    Logger logger = Logger.getLogger(BuildSettlementCommand.class.getName());


    public BuildSettlementCommand (Node node, Player player) {
        this.node = node;
        this.player = player;
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