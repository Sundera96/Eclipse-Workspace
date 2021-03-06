package com.algorithms.sort.comparisonsort;

public class InsertionSort {

	public void insertionSortAlgorithm(int[] unsortedArray) {
		for(int elementIndex=0; elementIndex<unsortedArray.length;elementIndex++) {
			int value = unsortedArray[elementIndex];
			int comparisonIndex = elementIndex;
			while(comparisonIndex>0&&unsortedArray[comparisonIndex-1]>value) {
				unsortedArray[comparisonIndex]=unsortedArray[comparisonIndex-1];
				comparisonIndex--;
			}
			unsortedArray[comparisonIndex]=value;
		}
	}
	public static void main(String[] args) {
		InsertionSort sort = new InsertionSort();
		int[] array = {1,56,23,2,31,8,9};
		sort.insertionSortAlgorithm(array);
		for(int eachVal:array) {
			System.out.println(eachVal);
		}
	}
}
