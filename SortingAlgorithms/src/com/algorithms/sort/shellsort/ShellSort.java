package com.algorithms.sort.shellsort;

public class ShellSort {

	private void shellSort(int[] unSortedArray) {
		for(int skipSortIndex = unSortedArray.length/2; skipSortIndex>0;skipSortIndex=skipSortIndex/2) {
			for(int start = skipSortIndex;start<unSortedArray.length;start++) {
				while(start>=skipSortIndex&& unSortedArray[start-skipSortIndex]>unSortedArray[start]) {
					int temp = unSortedArray[start];
					unSortedArray[start]=unSortedArray[start-skipSortIndex];
					unSortedArray[start-skipSortIndex] = temp;
				}
				
			}
		}	
	}
	
	private void shellSort2(int[] unSortedArray) {
		int gap =0;
		while(gap*3+1<unSortedArray.length)
			gap = gap*3+1;
		for(int comparisonGap = gap;comparisonGap>0;comparisonGap=((comparisonGap-1)/3)) {
			//int arrayGap = comparisonGap-1;
//			if(arrayGap==0) {
//				arrayGap=arrayGap+1;
//			}
			for(int index = comparisonGap; index<unSortedArray.length;index++ ) {
				while(index-comparisonGap>=0&&unSortedArray[index]<unSortedArray[index-(comparisonGap)]) {
					int temp = unSortedArray[index];
					unSortedArray[index] = unSortedArray[index-(comparisonGap)];
					unSortedArray[index-(comparisonGap)] = temp;
					index = index-comparisonGap;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] array = {3,4,1,56,23,6,8,7,54,24};
		ShellSort shellSortRunner = new ShellSort();
		shellSortRunner.shellSort2(array);
		
		for(int sortedVal: array) {
			System.out.print(sortedVal+" ");
		}
	}
}
