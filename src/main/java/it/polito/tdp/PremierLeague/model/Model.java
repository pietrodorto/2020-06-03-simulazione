package it.polito.tdp.PremierLeague.model;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	
	Graph<Player, DefaultWeightedEdge> graph ;
	PremierLeagueDAO dao;
	TreeMap<Integer, Player> playermMap;
	
	public Model() {
		
		
		dao = new PremierLeagueDAO();
		
		
	}

	public Graph<Player, DefaultWeightedEdge> creaGrafo(Double goal) {
		
		playermMap= new TreeMap<Integer, Player>();
		this.graph = new SimpleDirectedWeightedGraph<Player, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.graph, dao.listAllPlayersByGoal(goal));
		
		for(Player player : dao.listAllPlayers()) {
			playermMap.put(player.playerID, player);
		}
		
		List<InfoArco> list = dao.listAllPlayersGrafo();
		
		for(InfoArco infoArco: list) {
		
			Player player1 = playermMap.get(infoArco.getIdplayer1());
			Player player2 = playermMap.get(infoArco.getIdplayer2());
			if(player1!= null && player2!=null) {
				double peso = infoArco.getDelta();
				
				Graphs.addEdgeWithVertices(graph, player1 , player2, peso);
			}
			
		}

		return this.graph;
	}

}
