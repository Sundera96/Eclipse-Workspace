package com.java.datastructures.graph.shortestpathalgo.unweighted;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;



public class ShortestPathAlgorithmUnWeighted<T> {
	private Object[] path;
	private int[] distance;
	public ShortestPathAlgorithmUnWeighted(int vertexCount){
		distance = new int[vertexCount];
		path = new Object[vertexCount];
		for(int index=0;index<vertexCount;index++) {
			distance[index]=-1;
		}
	}
	public T[] unWeightedShortestPath(GraphAdjacency<T> graph,T start) {
		Queue<T> queue = new LinkedList<T>();
		queue.add(start);
		distance[graph.listOfVertex.indexOf(start)]=0;
		while(!queue.isEmpty()) {
			T currVertex = queue.poll();
			int indexOfCurrVertex = graph.listOfVertex.indexOf(currVertex);
			Iterator<T> iterator = ((GraphAdjacency<T>.ListNode)graph.edgesOfVertex[indexOfCurrVertex]).edges.iterator();
			while(iterator.hasNext()) {
				T adjacentVertex = iterator.next();
				queue.add(adjacentVertex);
				int indexOfAdjacentVertex = graph.listOfVertex.indexOf(adjacentVertex);
				if(distance[indexOfAdjacentVertex]==-1||distance[indexOfAdjacentVertex]>distance[indexOfCurrVertex]+1) {
					distance[indexOfAdjacentVertex] = distance[indexOfCurrVertex]+1;
					path[indexOfAdjacentVertex]=currVertex;
				}
			}
		}
		return (T[]) path;
	}
}
