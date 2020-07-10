package it.polito.tdp.PremierLeague.model;

public class PlayerMinutes implements Comparable<PlayerMinutes>{
	
	Player player;
	Double minuti;
	public PlayerMinutes(Player player, double minuti) {
		super();
		this.player = player;
		this.minuti = minuti;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public double getMinuti() {
		return minuti;
	}
	public void setMinuti(double minuti) {
		this.minuti = minuti;
	}
	@Override
	public int compareTo(PlayerMinutes o) {
		return o.minuti.compareTo(this.minuti);
	}
	
	

}
