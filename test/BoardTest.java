

import catan.Board;
import catan.Edge;
import catan.Node;
import catan.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testAddAndGetTile() {
        Tile tile = new Tile(1,"WOOD",9);
        board.addTile(1, tile);

        assertEquals(tile, board.getTile(1));
    }

    @Test
    void testAddAndGetNode() {
        Node node = new Node(6);
        board.addNode(2, node);

        assertEquals(node, board.getNode(2));
    }

    @Test
    void testAddAndGetEdge() {
        Edge edge = new Edge(2,2,2);
        board.addEdge(3, edge);

        assertEquals(edge, board.getEdge(3));
    }

    @Test
    void testGetNonExistingTileReturnsNull() {
        assertNull(board.getTile(999));
    }

    @Test
    void testGetAllTiles() {
        board.addTile(1, new Tile(1,"WOOD",9));
        board.addTile(2, new Tile(2,"BRICK",8));

        assertEquals(2, board.getAllTiles().size());
    }

    @Test
    void testGetAllNodes() {
        board.addNode(1, new Node(2));
        board.addNode(2, new Node(3));

        assertEquals(2, board.getAllNodes().size());
    }

    @Test
    void testGetAllEdges() {
        board.addEdge(1, new Edge(4,4,4));
        board.addEdge(2, new Edge(5,5,5));

        assertEquals(2, board.getAllEdges().size());
    }
}


