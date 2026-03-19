package catan;

public class BuildRoadCommand implements Command {

    private Edge edge;
    private Player player;
    private Board board;
    private Road road;

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
            System.out.println("Road built at Edge " + edge.getId());
        }
    }

    @Override
    public void undo() {
        edge.removeRoad();
        System.out.println("Undo road at Edge " + edge.getId());
    }


}

