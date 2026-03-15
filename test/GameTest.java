import catan.Game;
import catan.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.util.List;
public  class GameTest {
	private Game game;
	@BeforeEach
	void setUp() {
		game = new Game(1);
	}

	@Test
	@Timeout(2)
	void gameInitialization() {
		assertNotNull(game);
	}

	@Test
	@Timeout(2)
	void checkWinInitialization() {
		assertFalse(game.checkWin(), "checkWin should be false initially");
	}

	@Test
	@Timeout(2)
	void MaxRoundisThirty() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field maxRoundsField = Game.class.getDeclaredField("maxRounds");
		maxRoundsField.setAccessible(true);
		int maxRounds = (int) maxRoundsField.getInt(game);
		assertEquals(30, maxRounds, "Max rounds should be 30 by default");
	}

	@Test
	@Timeout(2)
	void nextTurnExecution() {
		game.startGame();
		assertDoesNotThrow(game::nextTurn, "next turn should not crash");
	}

	@Test
	@Timeout(2)
	void gameHasFourPlayers() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		game.startGame();
		Field playersField = Game.class.getDeclaredField("players");
		playersField.setAccessible(true);
		List<Player> players = (List<Player>) playersField.get(game);
		assertEquals(4, players.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	@Timeout(2)
	void checkWinIsTrue() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		game.startGame();
		Field playersField = Game.class.getDeclaredField("players");
		playersField.setAccessible(true);
		List<Player> players = (List<Player>) playersField.get(game);
		players.get(0).addVictoryPoints(10);
		assertTrue(game.checkWin(), "player with 10 points wins");
	}

	@Test
	@Timeout(5)
	void gameTermination() {
		assertDoesNotThrow(game::startGame, "Game should terminate properly");
	}

	@SuppressWarnings("unchecked")
	@Test
	@Timeout(2)
	void checkWinPlayerWithZeroPoints() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		game.startGame();
		Field playersField = Game.class.getDeclaredField("players");
		playersField.setAccessible(true);
		List<Player> players = (List<Player>) playersField.get(game);
		players.get(0).addVictoryPoints(0);
		assertFalse(game.checkWin(), "player with 0 points doesn't win");
	}

}
