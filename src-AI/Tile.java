package src-AI;

public class Tile {
    private int id;
    private String resourceType;
    private int diceVal;

    public Tile(int id, String resourceType, int diceVal) {
        this.id = id;
        this.resourceType = resourceType;
        this.diceVal = diceVal;
    }

    public int getDiceVal() {
        return diceVal;
    }

    public String getResourceType() {
        return resourceType;
    }
}
