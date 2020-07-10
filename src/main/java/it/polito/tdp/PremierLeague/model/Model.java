package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.Collections;
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
	Player topPlayer;
	
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
			double peso = infoArco.getDelta();
			
			if(graph.containsVertex(player1) && graph.containsVertex(player2)) {
				new PlayerMinutes(player1, infoArco.getMinplayer1());
				new PlayerMinutes(player2, infoArco.getMinplayer2());
				
				Graphs.addEdgeWithVertices(graph, player1 , player2, peso);
			}		
		}
		return this.graph;
	}

	public void trovaTopPlayer() {
		
		List<Player> list = new LinkedList<Player>();

		int numvicini = 0;
		
		for(Player player: graph.vertexSet()) {
			if(graph.outDegreeOf(player)>numvicini) {
				list= Graphs.neighborListOf(this.graph,player);
				numvicini = list.size();
				topPlayer=this.playermMap.get(player.getPlayerID());
			}	
		}
		
	}
	
	public List<PlayerMinutes> trovaVicini(){
		
		 this.trovaTopPlayer();
		
		 List<PlayerMinutes> result = new ArrayList<>() ;
				
				List<Player> vicini = Graphs.neighborListOf(this.graph, topPlayer) ;
				
				for(Player v: vicini) {
					System.out.println(topPlayer);
					System.out.println(v);
			//		double minuti =  this.graph.getEdgeWeight(this.graph.getEdge(topPlayer, v)) ;
			//		result.add(new PlayerMinutes(v, minuti)) ;
				}
				
				Collections.sort(result);
				
				return result ;
	}

}
