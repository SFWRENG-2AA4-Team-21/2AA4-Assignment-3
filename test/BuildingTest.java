
import catan.Building;
import catan.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class BuildingTest {
    private Building building;
    @BeforeEach
    void setBuilding(){
        building = new Building(100,new Player(1));
    }
    @Test
    void testSetandget(){
        building.setVictoryPoints(110);
        assertEquals(110,building.getVictoryPoints());
    }
}
