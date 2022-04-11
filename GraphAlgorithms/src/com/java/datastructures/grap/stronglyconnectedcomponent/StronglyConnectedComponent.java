package com.java.datastructures.grap.stronglyconnectedcomponent;

import java.util.Iterator;

import com.java.datastructures.grap.adjacencylist.AdjacencyListGraphDirectedEdges;

public class StronglyConnectedComponent {

	boolean[] isPresentInStack;
	boolean[] isVisited;
	AdjacencyListGraphDirectedEdges graph;
	int[] low;
	int[] depth;
	int nodesVisited;
	int numberOfConnectedComponents;
	int counter;
	
	public StronglyConnectedComponent(final AdjacencyListGraphDirectedEdges graph) {
		this.graph=graph;
		isPresentInStack = new boolean[graph.vertices.size()];
		isVisited = new boolean[graph.vertices.size()];
		low = new int[graph.vertices.size()];
		depth = new int[graph.vertices.size()];
		nodesVisited = 0;
	}
	
	public void stronglyConnectedComponent() {
		while(nodesVisited!=graph.vertices.size()) {
			dfsTraversal(graph.vertices.get(findUnvisitedVertex()));
		}
	}

	private int findUnvisitedVertex() {
		// TODO Auto-generated method stub
		for(int index=0;index<graph.vertices.size();index++) {
			if(isVisited[index]==false)
				return index;
		}
		return -1;
	}
	
	private void dfsTraversal(String startNode) {
		int startIndex = graph.vertices.indexOf(startNode);
		isVisited[startIndex]=true;
		isPresentInStack[startIndex]=true;
		low[startIndex]=++counter;
		depth[startIndex]=counter;
		nodesVisited++;
		Iterator<String> itr = graph.vertexEdges[startIndex].edges.iterator();
		while(itr.hasNext()) {
			String endNode = itr.next();
			int endIndex = graph.vertices.indexOf(endNode);
			if(isVisited[endIndex]==false) {
				dfsTraversal(endNode);
			}
			if(isPresentInStack[startIndex]==true&&isPresentInStack[endIndex]==true) {
				low[startIndex] = Math.min(low[startIndex], low[endIndex]);
			}
		}
		if(depth[startIndex]==low[startIndex]) {
			for(int index=0;index<graph.vertices.size();index++) {
				if(isPresentInStack[index]==true&&low[index]==low[startIndex]) {
					isPresentInStack[index]=false;
					System.out.println("Strongly connected component vertex: "+graph.vertices.get(index)+" with id: "+low[startIndex]);
				}
			}
			System.out.println("-------------------------------");
			numberOfConnectedComponents++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		AdjacencyListGraphDirectedEdges graph = new AdjacencyListGraphDirectedEdges(8);
		graph.addVertex("0 1 2 3 4 5 6 7".split(" "));
		graph.addEdges("0","1");
		graph.addEdges("1","2");
		graph.addEdges("2","0");
		graph.addEdges("6","2");
		graph.addEdges("6","0");
		graph.addEdges("6","4");
		graph.addEdges("4","5");
		graph.addEdges("5","6");
		graph.addEdges("5","0");
		graph.addEdges("3","4");
		graph.addEdges("7","4");
		graph.addEdges("7","3");
		graph.addEdges("3","7");
		StronglyConnectedComponent stronglyConnectedComponent = new StronglyConnectedComponent(graph);
		stronglyConnectedComponent.stronglyConnectedComponent();
		System.out.println(stronglyConnectedComponent.numberOfConnectedComponents);
	}
}
