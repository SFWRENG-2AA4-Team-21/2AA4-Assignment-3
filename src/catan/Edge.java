
package catan;
import java.util.logging.Logger;

/************************************************************/
/**
 * 
 */
public class Edge {
	/**
	 * 
	 */
	private int id;
	private Road road;
	private int nodeA;
	private int nodeB;
	Logger logger = Logger.getLogger(Edge.class.getName());


	public Edge(int id, int nodeA, int nodeB){
		this.id = id;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.road = null;
	}

	public int getId(){
        return id;
    }

	public int getNodeA(){
		return nodeA;
	}

	public int getNodeB(){
		return nodeB;
	}

	public boolean hasRoad(){
        return road != null;
    }
	/**
	 * 
	 * @param r 
	 */
	public void placeRoad(Road r) {
		if(road == null){
			this.road = r;
		}
		else{
			logger.info("Edge already has a road.");
		}
	}

	//implementing command pattern
	public void removeRoad() {
		this.road = null;
	}

	public Road getRoad(){
		return road;
	}
}
