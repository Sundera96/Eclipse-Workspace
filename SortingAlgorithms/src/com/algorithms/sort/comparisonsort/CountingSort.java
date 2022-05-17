package com.algorithms.sort.comparisonsort;

public class CountingSort {

	public int[] countingSortAlgorithm(int[] unsortedArray, int range) {
		int[] counterArray = new int[range];
		int[] sortedArray = new int[unsortedArray.length];
		
		//initialising the arrays to zero
		for(int index=0;index<unsortedArray.length;index++) {
			counterArray[index] = 0;
		}
		
		for(int val: unsortedArray) {
			counterArray[val]+=1;
		}
		
		//storing the upper index of an element
		for(int index=1;index<counterArray.length-1;index++) {
			counterArray[index] = counterArray[index-1]+counterArray[index];
		}
		
		for(int index=0;index<sortedArray.length;index++) {
			sortedArray[--counterArray[unsortedArray[index]]] = unsortedArray[index];
		}
		return sortedArray;
	}
	
	public static void main(String[] args) {
		CountingSort sort = new CountingSort();
		int[] array = {1,4,1,2,7,5,2};
		array = sort.countingSortAlgorithm(array,9);
		for(int eachVal:array) {
			System.out.println(eachVal);
		}
	}
}
