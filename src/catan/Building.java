package catan;

public class Building {
	private int victoryPoints;
	private Player owner;
	public Building(int victoryPoints, Player owner){
		this.victoryPoints = victoryPoints;
		this.owner = owner;
	}

	public int getVictoryPoints(){
		return victoryPoints;
	}

	public void setVictoryPoints(int victoryPoints){
		this.victoryPoints = victoryPoints;
	}

	public Player getOwner(){
		return owner;
	}
}
