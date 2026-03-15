package catan;
public class Node {
	/**
	 * 
	 */
	private int id;
	private Building building;
	private boolean isOccupied;

	public Node(int id){
		this.id=id;
		this.building = null;
        this.isOccupied = false;
	}

	public int getId(){
        return id;
    }

	/**
	 * 
	 * @param b the building to place
	 */
	
	public void placeBuilding(Building b){
		if (!isOccupied){
            this.building = b;
            this.isOccupied = true;
        }
	}

	/**
	 * 
	 * @return whether Occupied
	 */
	public boolean hasBuilding() {
		return isOccupied;
	}
	/**
	 * 
	 * @return Building
	 */
	public Building getBuilding() {
        return building;
    }
}
