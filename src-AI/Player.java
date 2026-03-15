import java.util.HashMap;
import java.util.Map;

public class Player {
    private int playerId;
    private int victoryPoints;
    private boolean largestArmy;
    private boolean largestVillage;
    private Map<String, Integer> resources = new HashMap<>();

    public Player(int playerId) {
        this.playerId = playerId;
    }

    public void addResources(String type, int amount) {
        resources.put(type, resources.getOrDefault(type, 0) + amount);
    }

    public boolean useResource(String type, int amount) {
        int current = resources.getOrDefault(type, 0);
        if (current < amount) return false;
        resources.put(type, current - amount);
        return true;
    }

    public int getScore() {
        return victoryPoints;
    }
}
