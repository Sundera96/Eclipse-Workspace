package com.algorithms.selection;

public class MedianOfTwoSortedArrays {

	
	/**
	 * @param sortedArr1
	 * @param sortedArr2
	 * consider the two arrays to have n elements each in the beginning
	 */
	public void medianOfTwoSortedArray(int[] sortedArr1, int[] sortedArr2) {
//		For odd numbers the median can be represented as number/2
//		For even number the median is the average of numberOfElements/2, numberOfElements/2 + 1
		double median;
		if((sortedArr1.length+sortedArr2.length)%2==0) {
			int median1 = findMedianRecursively(sortedArr1,0,sortedArr1.length,sortedArr2,0,sortedArr2.length,(sortedArr1.length+sortedArr2.length)/2);
			int median2 = findMedianRecursively(sortedArr1,0,sortedArr1.length,sortedArr2,0,sortedArr2.length,(sortedArr1.length+sortedArr2.length)/2+1);
			median = (double)(median1+median2)/2;
		}else {
			int median1 = findMedianRecursively(sortedArr1,0,sortedArr1.length,sortedArr2,0,sortedArr2.length,(sortedArr1.length+sortedArr2.length+1)/2);
			median = (double)median1;
		}
		System.out.println(median);
	}
	
	private int findMedianRecursively(int[] sortedArr1, int startIndex1, int endIndex1, int[] sortedArr2, int startIndex2, int endIndex2, int median) {
		int sizeArr1 = endIndex1-startIndex1;
		int sizeArr2 = endIndex2-startIndex2;
		if(sizeArr1<=0) {
			//Exhausted all the elements int arr1 then the median element will be median positions from the start of arr2
			return sortedArr2[startIndex2+median-1];
		}else if(sizeArr2<=0) {
			return sortedArr1[startIndex1+median-1];
		}
		else if(median==1) {
			return sortedArr1[startIndex1]<sortedArr2[startIndex2]?sortedArr1[startIndex1]:sortedArr2[startIndex2];
		}
		
		int midIndex1 = (startIndex1+endIndex1)/2;
		int midIndex2 = (startIndex2+endIndex2)/2;
		
		
		if(sizeArr1/2+sizeArr2/2+1>=median) {
			if(sortedArr1[midIndex1]>sortedArr2[midIndex2]) {
				return findMedianRecursively(sortedArr1,startIndex1,midIndex1,sortedArr2,startIndex2,endIndex2,median);
			}else {
				return findMedianRecursively(sortedArr1,startIndex1,endIndex1,sortedArr2,startIndex2,midIndex2,median);
			}
		}else {
			if(sortedArr1[midIndex1]>sortedArr2[midIndex2]) {
				return findMedianRecursively(sortedArr1,startIndex1,endIndex1,sortedArr2,midIndex2+1,endIndex2,median-sizeArr2/2-1);
			}else {
				return findMedianRecursively(sortedArr1,midIndex1+1,endIndex1,sortedArr2,startIndex2,endIndex2,median-sizeArr1/2-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = {10,11,13};
		int[] arr2 = {1,2,3,4,5};
		MedianOfTwoSortedArrays medianOfTwoSortedArraysRunner = new MedianOfTwoSortedArrays();
		medianOfTwoSortedArraysRunner.medianOfTwoSortedArray(arr1,arr2);
	}
}
