package com.algorithms.sort.comparisonsort;

import java.util.Random;

public class QuickSort {

	public void quickSortAlgorithm(int[] unsortedArray,int low,int high) {
		
		if(low<high) {
			int pivot=sorting(unsortedArray,low,high);
			//int pivot = new Random().nextInt(low, high+1);
			quickSortAlgorithm(unsortedArray,low,pivot-1);
			quickSortAlgorithm(unsortedArray,pivot+1,high);
		}
		
	}
	
	private int sorting(int[] unsortedArray,final int low,final int high) {
		int left = low;
		int right = high;
		//System.out.println("Low : "+low+"  Right : "+high);
		int pivotIndex = new Random().nextInt(low,high+1);
		swap(unsortedArray,low,pivotIndex);
		int pivotElement = unsortedArray[low];
		while(left<right) {
			while(left<high&&unsortedArray[left]<=pivotElement) {
				left+=1;
			}
			while(right>low&&unsortedArray[right]>=pivotElement) {
				right-=1;
			}
			if(left<right) {
				swap(unsortedArray,left,right);
			}
		}
		
		unsortedArray[low]= unsortedArray[right];
		unsortedArray[right]=pivotElement;
		return right;
	}

	private void swap(int[] unsortedArray, int low, int high) {
		// TODO Auto-generated method stub
		int temp = unsortedArray[high];
		unsortedArray[high] = unsortedArray[low];
		unsortedArray[low]=temp;
	}
	
	public static void main(String[] args) {
		int[] array = {3,4,1,56,23,6,8,7,54,24};
		QuickSort quickSortRunner = new QuickSort();
		quickSortRunner.quickSortAlgorithm(array,0,array.length-1);
		
		for(int sortedVal: array) {
			System.out.print(sortedVal+" ");
		}
	}
}
