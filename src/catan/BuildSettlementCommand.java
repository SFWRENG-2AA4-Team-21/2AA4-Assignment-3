//Settlement command implementation

package catan;

public class BuildSettlementCommand implements Command{
    private Node node;
    private Player player;
    private Board board;

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
            System.out.println("Settlement built at Node " + node.getId());
        }

    }

    @Override
    public void undo() {
        node.placeBuilding(null);
        player.addVictoryPoints(-1);
        System.out.println("Undo settlement at Node " + node.getId());
    }
}