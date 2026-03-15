package catan;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Board {
	
	/**
	 * 
	 */
	private Map<Integer, Tile> tiles;
	private Map<Integer, Node> nodes;
	private Map<Integer, Edge> edges;

	public Board(){
		tiles = new HashMap<>();
		nodes = new HashMap<>();
		edges = new HashMap<>();
	}
	
	/**
	 * 
	 * @param id 
	 * @return 
	 */
	public Tile getTile(int id) {
		return tiles.get(id);
	}

	/**
	 * 
	 * @param id 
	 * @return 
	 */
	public Node getNode(int id) {
		return nodes.get(id);
	}

	/**
	 * 
	 * @param id 
	 * @return 
	 */
	public Edge getEdge(int id) {
		return edges.get(id);
	}

	public void addTile(int id, Tile tile){
		tiles.put(id, tile);
	}

	public void addNode(int id, Node node){
		nodes.put(id, node);
	}

	public void addEdge(int id, Edge edge){
		edges.put(id, edge);
	}

	public Collection<Tile> getAllTiles() {
		 return tiles.values(); 
		}
    public Collection<Node> getAllNodes() {
		 return nodes.values();
		}
    public Collection<Edge> getAllEdges() {
		 return edges.values(); 
		}
}
