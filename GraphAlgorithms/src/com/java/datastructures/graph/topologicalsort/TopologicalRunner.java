package com.java.datastructures.graph.topologicalsort;

public class TopologicalRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TopologicalSort<String> topologicalSortRunner = new TopologicalSort<String>(5);
		topologicalSortRunner.addVertex("A");
		topologicalSortRunner.addVertex("B");
		topologicalSortRunner.addVertex("C");
		topologicalSortRunner.addVertex("D");
		topologicalSortRunner.addVertex("E");
		topologicalSortRunner.addEdges("A","B");
		topologicalSortRunner.addEdges("A","C");
		topologicalSortRunner.addEdges("A","D");
		topologicalSortRunner.addEdges("B","D");
		topologicalSortRunner.addEdges("C","E");
		topologicalSortRunner.addEdges("D","E");
		Object[] array = topologicalSortRunner.topologicalSort();
		for(Object string:array) {
			System.out.println(string);
		}
	}

}
