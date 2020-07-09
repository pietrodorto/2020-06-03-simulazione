package it.polito.tdp.PremierLeague.model;

public class InfoArco {
	
	private int  idplayer1;
	private int  minplayer1;
	private int  idplayer2;
	private int  minplayer2;
	private int delta;
	
	
	
	
	public InfoArco(int idplayer1, int minplayer1, int idplayer2, int minplayer2) {
		super();
		this.idplayer1 = idplayer1;
		this.minplayer1 = minplayer1;
		this.idplayer2 = idplayer2;
		this.minplayer2 = minplayer2;
		this.delta = minplayer1-minplayer2;
	}
	
	public int getIdplayer1() {
		return idplayer1;
	}
	public void setIdplayer1(int idplayer1) {
		this.idplayer1 = idplayer1;
	}
	public int getMinplayer1() {
		return minplayer1;
	}
	public void setMinplayer1(int minplayer1) {
		this.minplayer1 = minplayer1;
	}
	public int getIdplayer2() {
		return idplayer2;
	}
	public void setIdplayer2(int idplayer2) {
		this.idplayer2 = idplayer2;
	}
	public int getMinplayer2() {
		return minplayer2;
	}
	public void setMinplayer2(int minplayer2) {
		this.minplayer2 = minplayer2;
	}

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}
	

	
	

}
