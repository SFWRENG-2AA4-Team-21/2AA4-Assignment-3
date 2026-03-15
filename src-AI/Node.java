package src-AI;

public class Node {
    private int id;
    private Building building;
    private boolean isOccupied;

    public Node(int id) {
        this.id = id;
    }

    public void placeBuilding(Building b) {
        if (!isOccupied) {
            this.building = b;
            this.isOccupied = true;
        }
    }

    public boolean hasBuilding() {
        return isOccupied;
    }
}
