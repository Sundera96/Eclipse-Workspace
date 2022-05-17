package com.algorithm.searching;

public class InterpolationAlgorithm {

	public int interpolationAlgorithm(int[] sortedArray,int data) {
		int low = 0;
		int high = sortedArray.length-1;
		while(sortedArray[low]<=data&&sortedArray[high]>=data) {
			if(sortedArray[low]==data) {
				return low;
			}else if(sortedArray[high]==data) {
				return high;
			}
			int mid = low+(((data-sortedArray[low])*(high-low))/(sortedArray[high]-sortedArray[low]));
			if(sortedArray[mid]<data) {
				low = mid+1;
			}else if(sortedArray[mid]>data) {
				high = high-1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {1,3,4,6,8,9,11,16,19,22,26};
		InterpolationAlgorithm interpolationAlgorithm = new InterpolationAlgorithm();
		System.out.println(interpolationAlgorithm.interpolationAlgorithm(array,26));
	}
}
