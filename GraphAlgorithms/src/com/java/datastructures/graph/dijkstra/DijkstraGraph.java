package com.java.datastructures.graph.dijkstra;

import java.util.ArrayList;

public class DijkstraGraph<T> {
	int vertexLocation=-1;
	ArrayList<T> vertices;
	Object[] verticesEdgeRelation;
	int[] distance;
	
	public DijkstraGraph(int numberOfVertex) {
		vertices = new ArrayList<T>();
		verticesEdgeRelation = new Object[numberOfVertex];
		distance = new int[numberOfVertex];
		for(int index=0;index<numberOfVertex;index++) {
			verticesEdgeRelation[index]=new Node();
			distance[index]=-1;
		}
	}
	
	class Node{
		ArrayList<WeightedEdge> edge;
		public Node() {
			edge = new ArrayList<WeightedEdge>();
		}
	}
	
	class WeightedEdge{
		T destination;
		int weight;
		public WeightedEdge(T destination,int weight) {
			this.destination=destination;
			this.weight=weight;
		}
	}
	
	public void addVertex(T source) {
		if(source!=null) {
			vertices.add(source);
		}
	}
	
	public void addEdges(T source,T destination,int weight) {
		if(source!=null&&destination!=null) {
			int indexOfStoringEdge = vertices.indexOf(source);
			((Node)verticesEdgeRelation[indexOfStoringEdge]).edge.add(new WeightedEdge(destination,weight));
		}
	}
	
	
}
