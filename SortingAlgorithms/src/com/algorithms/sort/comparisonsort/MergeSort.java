package com.algorithms.sort.comparisonsort;


public class MergeSort {

	public void mergeSortAlgorithm(int[] unsortedArray, int[] tempArray, int low, int high) {
		if(low<high) {
			int mid = (high-low)/2+low;
			mergeSortAlgorithm(unsortedArray,tempArray,low,mid);
			mergeSortAlgorithm(unsortedArray,tempArray,mid+1,high);
			sorting(unsortedArray,tempArray,low,mid+1,high);
		}
	}
	
	private void sorting(int[] unsortedArray, int[] tempArray, int low, int mid, int high) {
		int tempLeft = low;
		int leftArrayEnd = mid-1;
		int size = high-low+1;
		while(low<=leftArrayEnd&&mid<=high) {
			if(unsortedArray[low]<unsortedArray[mid]) {
				tempArray[tempLeft++]=unsortedArray[low];
				low+=1;
			}else {
				tempArray[tempLeft++]=unsortedArray[mid];
				mid+=1;
			}
		}
		
		while(low<=leftArrayEnd) {
			tempArray[tempLeft++]=unsortedArray[low];
			low+=1;
		}
		while(mid<=high) {
			tempArray[tempLeft++]=unsortedArray[mid];
			mid+=1;
		}
		
		for(int index=size;index>0;index--) {
			unsortedArray[high]= tempArray[high];
			high = high-1;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {3,4,1,56,23,6,8,7,54,24};
		MergeSort shellSortRunner = new MergeSort();
		shellSortRunner.mergeSortAlgorithm(array,new int[array.length],0,array.length-1);
		
		for(int sortedVal: array) {
			System.out.print(sortedVal+" ");
		}
	}
}
