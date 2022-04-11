package com.java.datastructures.graph.shortestpathalgo.unweighted;

import java.util.ArrayList;

public class GraphAdjacency<T> {

	 ArrayList<T> listOfVertex;
	 int vertexCount;
	 Object[] edgesOfVertex;
	
	public class ListNode{
		public ArrayList<T> edges;
		ListNode(){
			edges = new ArrayList<T>();
		}
	}

	GraphAdjacency(final int count){
		this.vertexCount=count;
		listOfVertex = new ArrayList<T>();
		this.edgesOfVertex = new Object[count];
		for(int index=0;index<count;index++)
			edgesOfVertex[index]= new ListNode();
	}
	
	public void addVertex(final T data) {
		if(data==null)
			return;
		else if(listOfVertex.size()<=vertexCount)
			listOfVertex.add(data);
	}
	
	public void addEdges(final T source, final T destination) {
		int vertexPosition = listOfVertex.indexOf(source);
		((ListNode)edgesOfVertex[vertexPosition]).edges.add(destination);
	}
	
}
