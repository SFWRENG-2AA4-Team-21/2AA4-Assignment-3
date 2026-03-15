
import catan.Player; 
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.BeforeEach;
class PlayerTest {
	
	private Player player; 
	
	@BeforeEach
	void setUp() {
		player = new Player(1); 
	}
	
	@Test
	@Timeout(1)
	void newPlayerWithZeroPoints() {
		assertEquals(0, player.getScore(), "A new player should start with zero victory points"); 
	}
	
	@Test
	@Timeout(1) 
	
	void addResourcesWithZero() {
		player.addResources("BRICK", 0);
		
		assertFalse(player.useResource("BRICK", 1), "Adding zero resources shouldn't change anything"); 
	}
	
	@Test
	@Timeout(1)
	
	void addResourcesWithNegative() {
		player.addResources("WOOD", -2);
		
		assertFalse(player.useResource("WOOD", 1), "Adding negative resources shouldn't change anything"); 
	}
	
	@Test
	@Timeout(1)
	
	void victoryPointsAccumulate() {
		player.addVictoryPoints(1); 
		player.addVictoryPoints(2); 
		
		assertEquals(3,player.getScore(), "Victory points should accumulate"); 
	}

}


