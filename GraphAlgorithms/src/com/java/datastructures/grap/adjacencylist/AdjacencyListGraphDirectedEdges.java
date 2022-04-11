package com.java.datastructures.grap.adjacencylist;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyListGraphDirectedEdges {
	
	public class ListNode{
		public LinkedList<String> edges;
		public ListNode() {
			edges = new LinkedList<String>();
		}
	}

	public ArrayList<String> vertices;
	public ListNode[] vertexEdges;
	int numberOfVertices;
	public AdjacencyListGraphDirectedEdges(int numberOfVertices) {
		vertexEdges = new ListNode[numberOfVertices];
		vertices = new ArrayList<String>();
		this.numberOfVertices=numberOfVertices;
		for(int index=0;index<numberOfVertices;index++) {
			vertexEdges[index]= new ListNode();
		}
	}
	
	public void addVertex(String[] vertices) {
		for(String eachVertex: vertices) {
			this.vertices.add(eachVertex);
		}
	}
	
	public void addEdges(String source,String destination) throws Exception {
		int sourceIndex = vertices.indexOf(source);
		int destinationIndex = vertices.indexOf(destination);
		if(sourceIndex>=0&&sourceIndex<numberOfVertices&&destinationIndex>=0&&destinationIndex<numberOfVertices) {
			vertexEdges[sourceIndex].edges.add(destination);
		}else {
			throw new Exception("Index out of bounds for graph");
		}	
	}
	
	public static void main(String[] args) throws Exception {
		AdjacencyListGraphDirectedEdges graph = new AdjacencyListGraphDirectedEdges(5);
		graph.addVertex("A B C D E".split(" "));
		graph.addEdges("A","B");
		graph.addEdges("A","C");
		graph.addEdges("B", "C");
		for(String val : graph.vertexEdges[graph.vertices.indexOf("B")].edges) {
			System.out.println(val);
		}
		
	}
}

