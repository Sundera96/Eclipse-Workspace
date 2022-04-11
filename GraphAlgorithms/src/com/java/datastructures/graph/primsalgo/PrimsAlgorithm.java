package com.java.datastructures.graph.primsalgo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;


	class GraphNode<T> {
	ArrayList<T> vertex;
	Object[] edgeConnect;
	
	//private int count;
	
	public GraphNode(int capacity) {
		vertex = new ArrayList<T>();
		edgeConnect = new Object[capacity];
		//this.count = -1;
	}

	class Edge{
		Edge(T source,T destination,int weight){
			this.source=source;
			this.destination=destination;
			this.weight=weight;
		}
		T source;
		T destination;
		int weight;
	}
	
	public int getIndexOfVertex(T source){
		return vertex.indexOf(source);
	}
	
	public void addEdge(T source, T destination,int weight) {
		int sourceIndex = vertex.indexOf(source);
		int destinationIndex = vertex.indexOf(destination);
		if(sourceIndex==-1) {
			vertex.add(source);
			 ArrayList<Edge> obj = new ArrayList<Edge>();
			 obj.add(new Edge(source,destination,weight));
			 sourceIndex = vertex.indexOf(source);
			edgeConnect[sourceIndex] = obj;
		}else {
			((ArrayList<Edge>)edgeConnect[sourceIndex]).add(new Edge(source,destination,weight));
		}
		if(destinationIndex==-1) {
			vertex.add(destination);
			ArrayList<Edge> obj = new ArrayList<Edge>();
			 obj.add(new Edge(destination,source,weight));
			 destinationIndex = vertex.indexOf(destination);
			edgeConnect[destinationIndex] = obj;
		}
		else {
			((ArrayList<Edge>)edgeConnect[destinationIndex]).add(new Edge(destination,source,weight));
		}
	}	
}

public class PrimsAlgorithm{
	Object[] path;
	boolean[] isVisited;
	//int[] distance;
	
	public<T> T[] primsAlgorithm(GraphNode<T> graph,T start) {
		Comparator<GraphNode<T>.Edge> comparator = new Comparator<GraphNode<T>.Edge>() {

			@Override
			public int compare(GraphNode<T>.Edge o1, GraphNode<T>.Edge o2) {
				if(o1.weight<o2.weight) {
					return -1;
				}
				else if(o1.weight==o2.weight) {
					return 0;
				}
				return 1;
			}
		};
		PriorityQueue<GraphNode<T>.Edge> pQueue = new PriorityQueue<GraphNode<T>.Edge>(comparator);
		path = new Object[graph.edgeConnect.length];
		isVisited = new boolean[graph.edgeConnect.length];
		//distance = new int[graph.edgeConnect.length];
//		for(int index=0;index<graph.edgeConnect.length;index++)
//			distance[index]=-1;
		
		int startIndex = graph.getIndexOfVertex(start);
		//distance[startIndex]=0;
		pQueue.add(graph.new Edge(null,start,0));
		while(!pQueue.isEmpty()) {
			GraphNode<T>.Edge node = pQueue.poll();
			startIndex = graph.getIndexOfVertex(node.destination);
			if(isVisited[startIndex]==true) {
				continue;
			}
			Iterator<GraphNode<T>.Edge> itr = ((ArrayList<GraphNode<T>.Edge>)graph.edgeConnect[graph.getIndexOfVertex(node.destination)]).iterator();
			while(itr.hasNext()) {
				GraphNode<T>.Edge edgeNode = (GraphNode<T>.Edge) itr.next();
				int destinationIndex = graph.getIndexOfVertex(edgeNode.destination);
				if(isVisited[destinationIndex]==false) {
					pQueue.add(edgeNode);
				}
			}
			isVisited[startIndex] = true;
			path[startIndex]=node.source;
		}
		return (T[]) path;
		
	}
	
	public static void main(String[] args) {
		GraphNode<String> graphNode = new GraphNode<String>(7);
		graphNode.addEdge("B","D",4);
		graphNode.addEdge("B","C",10);
		graphNode.addEdge("D","C",2);
		graphNode.addEdge("D","E",1);
		graphNode.addEdge("E","C",6);
		graphNode.addEdge("C","A",3);
//		graphNode.addEdge("C","E",7);
//		graphNode.addEdge("B","E",5);
//		graphNode.addEdge("E","F",8);
//		graphNode.addEdge("F","G",11);
//		graphNode.addEdge("G","E",9);
		PrimsAlgorithm primRunner = new PrimsAlgorithm();
		Object[] array =primRunner.primsAlgorithm(graphNode, "B");
		int count = 0;
		for(Object val:graphNode.vertex) {
			System.out.println("The vertex is: "+val+" and the path is: "+array[count++]);
		}
	}
}
