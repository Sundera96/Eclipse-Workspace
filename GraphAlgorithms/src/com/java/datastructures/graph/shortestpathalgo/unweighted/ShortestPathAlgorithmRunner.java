package com.java.datastructures.graph.shortestpathalgo.unweighted;

public class ShortestPathAlgorithmRunner {

	public static void main(String[] args) {
		GraphAdjacency<String> runner = new GraphAdjacency<String>(7);
		runner.addVertex("A");
		runner.addVertex("B");
		runner.addVertex("D");
		runner.addVertex("E");
		runner.addVertex("G");
		runner.addVertex("F");
		runner.addVertex("C");
		runner.addEdges("A","B");
		runner.addEdges("B","D");
		runner.addEdges("A","D");
		runner.addEdges("B","E");
		runner.addEdges("E","G");
		runner.addEdges("D","F");
		runner.addEdges("G","F");
		runner.addEdges("C","F");
		runner.addEdges("C","A");
		runner.addEdges("D","G");
		
		ShortestPathAlgorithmUnWeighted<String> shortestPathRunner = new ShortestPathAlgorithmUnWeighted<String>(runner.vertexCount);
		Object[] shortestPath = shortestPathRunner.unWeightedShortestPath(runner,"C");
		for(Object val:shortestPath)
			System.out.println(val);
	}
}
