package com.java.datastructures.graph.dijkstra;

public class DijkstraRunner {

	public static void main(String[] args) {
		DijkstraGraph<String> runner = new DijkstraGraph<String>(7);
		runner.addVertex("A");
		runner.addVertex("B");
		runner.addVertex("D");
		runner.addVertex("E");
		runner.addVertex("C");
		runner.addEdges("A","B",4);
		runner.addEdges("A","C",1);
		runner.addEdges("B","E",4);
	
		runner.addEdges("D","E",4);
		
		runner.addEdges("C","D",4);
		runner.addEdges("C","B",2);
		
		DijkstraImpl<String> dijkstraRunner = new DijkstraImpl<String>();
		Object[] shortestPath = dijkstraRunner.dijkstra(runner,"A");
		for(Object val:shortestPath)
			System.out.println(val);
	}
}
