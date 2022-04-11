package com.java.datastructures.grap.articulationpoint;

import java.util.Iterator;

import com.java.datastructures.grap.adjacencylist.AdjacencyListGraph;

public class ArticulationPoint {
	private boolean[] isVisited;
	private int[] depth;
	private int[] low;
	private String[] parent;
	private AdjacencyListGraph graph;
	
	public ArticulationPoint(AdjacencyListGraph graph) {
		this.graph = graph;
		isVisited = new boolean[graph.vertices.size()];
		depth = new int[graph.vertices.size()];
		low = new int[graph.vertices.size()];
		parent = new String[graph.vertices.size()];
	}
	
	public void articulationPoint(String vertex, int val) {
		int startOfEdgeIndex = graph.vertices.indexOf(vertex);
		isVisited[startOfEdgeIndex]=true;
		depth[startOfEdgeIndex] = val;
		low[startOfEdgeIndex]=val;
		int children = 0;
		Iterator<String> itr = ((AdjacencyListGraph.ListNode)graph.vertexEdges[startOfEdgeIndex]).edges.iterator();
		while(itr.hasNext()) {
			String nextVertex = (String) itr.next();
			int destinationIndex = graph.vertices.indexOf(nextVertex);
			if(isVisited[destinationIndex]==false) {
				parent[destinationIndex] = vertex;
				children++;
				articulationPoint(nextVertex, val+1);
				low[startOfEdgeIndex] = Math.min(low[startOfEdgeIndex],low[destinationIndex]);
				if(parent[startOfEdgeIndex]!=null&&low[destinationIndex]>=depth[startOfEdgeIndex]) {
					System.out.println("Articulation point found at "+ vertex);
				}
				else if(parent[startOfEdgeIndex]==null&&children>1) {
					System.out.println("Articulation point found at "+ vertex);
				}
			}
			else if(parent[startOfEdgeIndex]!=nextVertex) {
				low[startOfEdgeIndex] = Math.min(low[startOfEdgeIndex],depth[destinationIndex]);
			}
		}
	}
	

	public static void main(String[] args) throws Exception {
		AdjacencyListGraph graph = new AdjacencyListGraph(6);
		graph.addVertex("A B D C E F".split(" "));
		graph.addEdges("A","B");
		graph.addEdges("A","C");
		graph.addEdges("B","D");
		graph.addEdges("C","D");
		graph.addEdges("D","E");
		graph.addEdges("D","F");
		graph.addEdges("F","E");
		
//		graph.addVertex("A B C".split(" "));
//		graph.addEdges("A","B");
//		graph.addEdges("A","C");
		ArticulationPoint ap = new ArticulationPoint(graph);
		ap.articulationPoint("A",0);
	}
}
