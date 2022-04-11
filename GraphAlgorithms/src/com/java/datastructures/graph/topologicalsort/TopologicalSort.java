package com.java.datastructures.graph.topologicalsort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort<T> {

	private ArrayList<T> listOfVertex;
	private int vertexCount;
	private Object[] edgesOfVertex;
	
	TopologicalSort(final int count){
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
	
	class ListNode{
		ArrayList<T> edges;
		ListNode(){
			edges = new ArrayList<T>();
		}
	}
	
	public T[] topologicalSort(){
		int[] degreeOfVertex = degreeOfVertices();
		int topologicalIndex = 0;
		T[] topological = (T[]) new Object[vertexCount];
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int index=0;index<vertexCount;index++) {
			if(degreeOfVertex[index]==0) {
				queue.add(index);
			}
		}
		while(!queue.isEmpty()) {
			int nodeIndex = queue.peek();
			Iterator<T> iterator  = ((ListNode)edgesOfVertex[nodeIndex]).edges.iterator();
			while(iterator.hasNext()) {
				T data = iterator.next();
				int indexOfData = listOfVertex.indexOf(data);
				degreeOfVertex[indexOfData] = degreeOfVertex[indexOfData]-1;
				if(degreeOfVertex[indexOfData]==0) {
					queue.add(indexOfData);
				}
			}
			topological[topologicalIndex++]=listOfVertex.get(queue.poll());
		}
		if(topologicalIndex!=vertexCount) {
			return null;
		}else {
			return topological;
		}
	}
	
	private int[] degreeOfVertices() {
		int[] degreeOfVertex = new int[vertexCount];
		for(int vertex=0;vertex<vertexCount;vertex++) {
			Iterator<T> iterator  = ((ListNode)edgesOfVertex[vertex]).edges.iterator();
			while(iterator.hasNext()) {
				T element = iterator.next();
				int indexOfVertex = listOfVertex.indexOf(element);
				degreeOfVertex[indexOfVertex] = ++degreeOfVertex[indexOfVertex];
			}
		}
		return degreeOfVertex;
	}
}
