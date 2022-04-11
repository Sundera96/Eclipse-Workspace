package com.java.datastructures.graph.dijkstra;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import com.java.datastructures.graph.dijkstra.DijkstraGraph.Node;
import com.java.datastructures.graph.dijkstra.DijkstraGraph.WeightedEdge;

public class DijkstraImpl<T> {
	Object[] path;
	public T[] dijkstra(DijkstraGraph<T> graph, T start) {
		path = new Object[graph.vertices.size()];
		Comparator<DijkstraGraph<T>.WeightedEdge> comparator = new Comparator<DijkstraGraph<T>.WeightedEdge>() {

			@Override
			public int compare(WeightedEdge o1, WeightedEdge o2) {
				if(o1.weight<o2.weight) {
					return -1;
				}
				else if(o1.weight==o2.weight) {
					return 0;
				}
				return 1;
			}
			
		};
		PriorityQueue<DijkstraGraph<T>.WeightedEdge> priorityQueue = new PriorityQueue<DijkstraGraph<T>.WeightedEdge>(comparator);
		int currIndex = graph.vertices.indexOf(start);
		graph.distance[currIndex]=0;
		priorityQueue.add(graph.new WeightedEdge(start,0));
		while(!priorityQueue.isEmpty()) {
			DijkstraGraph<T>.WeightedEdge currNode = priorityQueue.poll();
			currIndex = graph.vertices.indexOf(currNode.destination);
			Iterator<DijkstraGraph<T>.WeightedEdge> iterate = ((Node)graph.verticesEdgeRelation[graph.vertices.indexOf(currNode.destination)]).edge.iterator();
			while(iterate.hasNext()) {
				DijkstraGraph<T>.WeightedEdge nextNode = iterate.next();
				int nextNodeIndex = graph.vertices.indexOf(nextNode.destination);
				priorityQueue.offer(nextNode);
				if(graph.distance[nextNodeIndex]==-1||graph.distance[currIndex]+nextNode.weight<graph.distance[nextNodeIndex]) {
					graph.distance[nextNodeIndex] = graph.distance[currIndex]+nextNode.weight;
					path[nextNodeIndex] = currNode.destination; 
				}
			}
		}
		return (T[])path;
	}
}
