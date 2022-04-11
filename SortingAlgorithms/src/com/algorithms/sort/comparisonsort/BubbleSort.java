package com.algorithms.sort.comparisonsort;

public class BubbleSort {

	/**
	 * The method converts an unsorted array to sorted array in ascending order
	 * @param unsortedArray
	 */
	
	public void bubbleSort(int[] unsortedArray) {
		for(int iteration=0;iteration<unsortedArray.length;iteration++) {
			boolean isSorted = true;
			for(int index=0;index<unsortedArray.length-1;index++) {
				if(unsortedArray[index]>unsortedArray[index+1]) {
					int temp = unsortedArray[index];
					unsortedArray[index] = unsortedArray[index+1];
					unsortedArray[index+1] = temp;
					isSorted=false;
				}
			}
			if(isSorted==true) {
				return; 
			}
		}
	}
	
	
	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		int[] array = {1,56,23,2,31,8,9};
		sort.bubbleSort(array);
		for(int eachVal:array) {
			System.out.println(eachVal);
		}
	}
}
