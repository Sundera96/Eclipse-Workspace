package com.algorithms.selection;

import java.util.Arrays;

public class KthSmallestValue {

	/**
	 * @author sundera
	 * Median of Medians is a selection algorithm that find the kth smallest element in an array using the time complexity of O(n)
	 * @param unSortedArray
	 * The array is split into chunks of 5 and the median is computed for all the chunks. 
	 */
	public int medianOfMedians(int[] unSortedArray, int k) {
		boolean medianNotFound = true;
		int median = 0;
		int[] copyArr = Arrays.copyOfRange(unSortedArray,0,unSortedArray.length);
		while(medianNotFound) {
			int chunkSize;
			if(copyArr.length%5==0) {
				chunkSize = copyArr.length/5;
			}else {
				chunkSize = copyArr.length/5+1;
			}
			int[] medianArray = new int[chunkSize];
			for(int index=0;index<copyArr.length;index+=5) {
				medianArray[index/5]=getPivot(copyArr,index,index+5);
			}
			if(medianArray.length==1) {
				medianNotFound = false;
				median = medianArray[0];
			}else {
				copyArr = medianArray;
			}
		}
		int pivotIndex = partitionAlgorithm(unSortedArray,median);
		int[] subArray;
		if(k-1<pivotIndex) {
			subArray = Arrays.copyOfRange(unSortedArray,0, pivotIndex);
			return medianOfMedians(subArray,k);
		}else if(k-1>pivotIndex) {
			subArray = Arrays.copyOfRange(unSortedArray,pivotIndex+1,unSortedArray.length);
			return medianOfMedians(subArray,k-(pivotIndex+1));
		}
		return unSortedArray[pivotIndex];
	}
	
	private int partitionAlgorithm(int[] arr, int pivot) {
		// TODO Auto-generated method stub
		int leftIndex = 0;
		int rightIndex = arr.length-1;
		for (int index = 0; index < arr.length; index++) {
            if (arr[index] == pivot) {
                swap(arr, index, rightIndex);
                break;
            }
        }
		while(leftIndex<rightIndex) {
			while(leftIndex<arr.length&&arr[leftIndex]<pivot) {
				leftIndex+=1;
			}
			
			while(rightIndex>=0&&arr[rightIndex]>=pivot) {
				rightIndex-=1;
			}
			
			if(leftIndex<rightIndex) {
				swap(arr,leftIndex,rightIndex);
			}
		}
		swap(arr,leftIndex,arr.length-1);
		return leftIndex;
	}

	private void swap(int[] array, int index1, int index2) {
		// TODO Auto-generated method stub
		int tmp = array[index1];
		array[index1]=array[index2];
		array[index2]=tmp;
	}

	private int getPivot(int[] unSortedArray, int start, int end) {
		if(end>unSortedArray.length) {
			end = unSortedArray.length;
		}
		Arrays.sort(unSortedArray,start,end);
		return unSortedArray[(start+end)/2];
	}
	
	public static void main(String[] args) {
		KthSmallestValue kthSmallestValueRunner = new KthSmallestValue();
		// 1 2 3 4 5 7 8 10 14 20 
		int[] array = {1 ,4 , 3, 10, 7,8,2,14,20,5};
		System.out.println(kthSmallestValueRunner.medianOfMedians(array,2));
//		kthSmallestValueRunner.partitionAlgorithm(array,7);
//		
//		for(int val: array) {
//			System.out.println(val);
//		}
		
		
	}
}
