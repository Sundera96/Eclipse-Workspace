package com.java.datastructures.grap.krushkalimpl;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import com.java.datastructures.grap.krushkals.DisjointSets;

public class KrushkalAlgorithm<T> {
	private boolean[] isVisited;
	private Object[] previousNode; 
	
	public void krushkalAlgorithm(T start,GraphNode<T> graph ) {
		
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
		previousNode = new Object[graph.edgeConnect.length];
		PriorityQueue<GraphNode<T>.Edge> pQueue = new PriorityQueue<GraphNode<T>.Edge>(comparator);
		DisjointSets sets = new DisjointSets(graph.edgeConnect.length);
		isVisited= new boolean[graph.edgeConnect.length];
		for(int index=0;index<graph.edgeConnect.length;index++) {
			ArrayList<GraphNode<T>.Edge> listOfEdges = (ArrayList<GraphNode<T>.Edge>)graph.edgeConnect[index];
			if(listOfEdges!=null) {
				Iterator<GraphNode<T>.Edge> itr = listOfEdges.iterator();
				while(itr!=null&&itr.hasNext()) {
					GraphNode<T>.Edge edge = itr.next();
					if(isVisited[graph.vertex.indexOf(edge.destination)]==false) {
						pQueue.add(edge);
						isVisited[graph.vertex.indexOf(edge.source)]=true;
					}
				}
			}
		}
		while(!pQueue.isEmpty()) {
			GraphNode<T>.Edge minEdge = pQueue.poll();
			int index1 = graph.vertex.indexOf(minEdge.source);
			int index2 = graph.vertex.indexOf(minEdge.destination);
			if(sets.find(index1)!=sets.find(index2)) {
				previousNode[index2]=minEdge.source;
				sets.unionBySize(index1, index2);
			}
		}
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
		KrushkalAlgorithm<String> krushkalRunner = new KrushkalAlgorithm<String>();
		krushkalRunner.krushkalAlgorithm("B", graphNode);
		int count = 0;
		for(Object val:graphNode.vertex) {
			System.out.println("The vertex is: "+val+" and the path is: "+krushkalRunner.previousNode[count++]);
		}
	}	
}
	

class GraphNode<T> {
	ArrayList<T> vertex;
	Object[] edgeConnect;

	// private int count;

	public GraphNode(int capacity) {
		vertex = new ArrayList<T>();
		edgeConnect = new Object[capacity];
		// this.count = -1;
	}

	class Edge {
		Edge(T source, T destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}

		T source;
		T destination;
		int weight;
	}

	public int getIndexOfVertex(T source) {
		return vertex.indexOf(source);
	}

	public void addEdge(T source, T destination, int weight) {
		int sourceIndex = vertex.indexOf(source);
		int destinationIndex = vertex.indexOf(destination);
		if (sourceIndex == -1) {
			vertex.add(source);
			ArrayList<Edge> obj = new ArrayList<Edge>();
			obj.add(new Edge(source, destination, weight));
			sourceIndex = vertex.indexOf(source);
			edgeConnect[sourceIndex] = obj;
		} else {
			((ArrayList<Edge>) edgeConnect[sourceIndex]).add(new Edge(source, destination, weight));
		}
		if (destinationIndex == -1) {
			vertex.add(destination);
			ArrayList<Edge> obj = new ArrayList<Edge>();
			obj.add(new Edge(destination, source, weight));
			destinationIndex = vertex.indexOf(destination);
			edgeConnect[destinationIndex] = obj;
		} else {
			((ArrayList<Edge>) edgeConnect[destinationIndex]).add(new Edge(destination, source, weight));
		}
	}
}
