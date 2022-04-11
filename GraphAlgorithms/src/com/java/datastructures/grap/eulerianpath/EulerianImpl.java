package com.java.datastructures.grap.eulerianpath;

import java.util.Iterator;
import java.util.Stack;

import com.java.datastructures.grap.adjacencylist.AdjacencyListGraphDirectedEdges;

public class EulerianImpl {
	
	private AdjacencyListGraphDirectedEdges graph;
	int[] incomingDegree;
	int[] outgoingDegree;
	boolean[] isVisited;
	String[] parent;
	Stack<String> eulerianCircuit;
	
	public EulerianImpl(AdjacencyListGraphDirectedEdges graph) {
		this.graph=graph;
		incomingDegree = new int[graph.vertices.size()];
		outgoingDegree = new int[graph.vertices.size()];
		isVisited = new boolean[graph.vertices.size()];
		parent = new String[graph.vertices.size()];
		eulerianCircuit = new Stack<String>();
	}
	
	public void eulerianAlgorithm() {
		countInAndOutDegree();
		if(graphHasEulerianPath()) {
			dfs(graph.vertices.get(findIndexOfStartNode()));
		}
	}
	private void dfs(String startNode) {
		int startVertexIndex = graph.vertices.indexOf(startNode);
		while(outgoingDegree[startVertexIndex]>0) {
			String nextEdge = graph.vertexEdges[startVertexIndex].edges.get(--outgoingDegree[startVertexIndex]);
			dfs(nextEdge);
		}
		if(outgoingDegree[startVertexIndex]==0)
			eulerianCircuit.add(startNode);
	}

	private void countInAndOutDegree() {
		for(int index=0;index<graph.vertices.size();index++) {
			Iterator<String> itr = graph.vertexEdges[index].edges.iterator();
			while(itr.hasNext()) {
				String nextNode = itr.next();
				int inComingIndex = graph.vertices.indexOf(nextNode);
				outgoingDegree[index]+=1;
				incomingDegree[inComingIndex]+=1;
			}
		}
	}
	
	private boolean graphHasEulerianPath() {
		int startNodes = 0, endNodes = 0;
		for(int index=0;index<graph.vertices.size();index++) {
			if(Math.abs(incomingDegree[index]-outgoingDegree[index])>1) {
				return false;
			}
			else if(outgoingDegree[index]-incomingDegree[index]==1) {
				startNodes++;
			}
			else if(incomingDegree[index]-outgoingDegree[index]==1) {
				endNodes++;
			}
		}
		return endNodes==0&&startNodes==0||endNodes==1&&startNodes==1;
	}
	
	private int findIndexOfStartNode() {
		int start=0;
		for(int index=0;index<graph.vertices.size();index++) {
			if(outgoingDegree[index]-incomingDegree[index]==1) {
				return index;
			}
			else if(outgoingDegree[index]>0){
				start = index;
			}
		}
		return start;
	}
	
	public static void main(String[] args) throws Exception {
		AdjacencyListGraphDirectedEdges graph = new AdjacencyListGraphDirectedEdges(7);
		graph.addVertex("0 1 2 3 4 5 6".split(" "));
		graph.addEdges("2","2");
		graph.addEdges("2","4");
		graph.addEdges("2","4");
		graph.addEdges("1","2");
		graph.addEdges("1","3");
		graph.addEdges("3","1");
		
		graph.addEdges("3","2");
		
		
		graph.addEdges("4","3");
		graph.addEdges("4","6");
		graph.addEdges("6","3");
		
		graph.addEdges("5","6");
		graph.addEdges("3","5");
		
		EulerianImpl eulerianRunner = new EulerianImpl(graph);
		eulerianRunner.eulerianAlgorithm();
		for(String s:eulerianRunner.eulerianCircuit)
			System.out.println(s);
	}
	
	private void printInComingAndOutGoingDegree(EulerianImpl eulerianRunner) {
		for(String vertex :eulerianRunner.graph.vertices) {
			System.out.print(vertex);
			System.out.print(" InComing :"+ eulerianRunner.incomingDegree[graph.vertices.indexOf(vertex)]);
			System.out.print(" OutGoing :"+ eulerianRunner.outgoingDegree[graph.vertices.indexOf(vertex)]);
			System.out.println();
		}
	}
}
