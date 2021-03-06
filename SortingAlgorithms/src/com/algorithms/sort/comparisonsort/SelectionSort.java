package com.algorithms.sort.comparisonsort;

public class SelectionSort {

	public void selectionSortAlgorithm(int[] unsortedArray) {
		for(int arrayIndex=0;arrayIndex<unsortedArray.length;arrayIndex++) {
			int minIndex = arrayIndex;
			for(int traverseIndex=arrayIndex+1;traverseIndex<unsortedArray.length;traverseIndex++) {
				if(unsortedArray[minIndex]>unsortedArray[traverseIndex]) {
					minIndex = traverseIndex;
				}
			}
			int temp = unsortedArray[arrayIndex];
			unsortedArray[arrayIndex]=unsortedArray[minIndex];
			unsortedArray[minIndex] = temp;
		}
	}
	
	
	public static void main(String[] args) {
		SelectionSort sort = new SelectionSort();
		int[] array = {1,56,23,2,31,8,9};
		sort.selectionSortAlgorithm(array);
		for(int eachVal:array) {
			System.out.println(eachVal);
		}
	}
}
