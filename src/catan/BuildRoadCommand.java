package catan;

import java.util.logging.Logger;

public class BuildRoadCommand implements Command {

    private Edge edge;
    private Player player;
    private Board board;
    private Road road;
    Logger logger = Logger.getLogger(BuildRoadCommand.class.getName());


    public BuildRoadCommand(Edge edge, Player player, Board board) {
        this.edge = edge;
        this.player = player;
        this.board = board;
    }

    @Override
    public void execute() {
        if(!edge.hasRoad()) {
            road = new Road(player, edge);
            edge.placeRoad(road);
            logger.info("Road built at Edge " + edge.getId());
        }
    }

    @Override
    public void undo() {
        edge.removeRoad();
        logger.info("Undo road at Edge " + edge.getId());
    }


}

