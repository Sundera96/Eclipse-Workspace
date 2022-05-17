package com.algorithm.searching.problems;

import java.util.Arrays;

public class SearchingSolutions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {3,4,3,3,4,3,6,6,3};
		int[] arrayWithNegative = {1, 60 ,-10, 70, -80,-82, 100};
		int[] pivot = {2,4,6,7,5,3};
		int[] shuffleArray = {1,3,5,7,2,4,6,8};
		SearchingSolutions searchingSolutionRunner = new SearchingSolutions();
		//System.out.println(searchingSolutionRunner.findMissingNumber(array));
		//searchingSolutionRunner.twoSumK(array,1);
		//searchingSolutionRunner.pythogorianTriplet(array);
//		int[] result = searchingSolutionRunner.twoElementsWithMinimumSum(array);
//		for(int eachVal: shuffleArray)
//			System.out.println(eachVal);
//		searchingSolutionRunner.threeElementsSumIsK(array,11);
//		System.out.println(searchingSolutionRunner.searchForPivot(array));
		//System.out.println(searchingSolutionRunner.binarySearchForLastOccurence(array,6));
//		searchingSolutionRunner.nextSequenceOfOne(1, 6);
//		searchingSolutionRunner.majorityNumber(array);
		searchingSolutionRunner.shuffleArray(shuffleArray,4);
	}

	
	public int findMissingNumber(int[] A) {
		int x = 1, y = 1;
		for(int index=0;index<A.length;index++) {
			x^=A[index];
		}
		
		for(int index=1;index<=A.length+1;index++) {
			y^=index;
		}
		
		return x^y;
	}
	
	public void twoSumK(int[] array,int k) {
		Arrays.sort(array);
		int lowIndex=0;
		int highIndex=array.length-1;
		while(lowIndex<highIndex) {
			int diff = array[lowIndex]+array[highIndex]-k;
			if(diff>0) {
				highIndex=highIndex-1;
			}else if(diff<0) {
				lowIndex = lowIndex+1;
			}else {
				System.out.println("Found : "+array[lowIndex++]+"  "+array[highIndex]);
			}
		}
	}
	
	public void pythogorianTriplet(int[] array) {
		for(int index=0;index<array.length;index++)
			array[index]=array[index]*array[index];
		Arrays.sort(array);
		for(int index=array.length-1;index>=0;index--) {
			int sumRequired = array[index];
			int lowIndex = 0;
			int highIndex = index-1;
			while(lowIndex<highIndex) {
				int sum = array[lowIndex]+array[highIndex]-sumRequired;
				if(sum<0) {
					lowIndex=lowIndex+1;
				}else if(sum>0) {
					highIndex=highIndex-1;
				}else {
					System.out.println( "Low Index : "+array[lowIndex] +" Mid Index : "+array[highIndex] +" High Index: "+array[index]);
					return;
				}
			}
		}
	}
	
	public int[] twoElementsWithMinimumSum(int[] array) {
		Arrays.sort(array);
		int lowIndex = 0;
		int highIndex = array.length-1;
		int abs = Integer.MAX_VALUE;
		int[] pair = new int[2];
		while(lowIndex<highIndex) {
			int sum = array[lowIndex]+array[highIndex];
			if(Math.abs(sum)<abs) {
				abs = Math.abs(sum);
				pair[0]=array[lowIndex];
				pair[1]=array[highIndex];
			}
			if(sum<0) {
				lowIndex = lowIndex+1;
			}else if(sum>0) {
				highIndex = highIndex-1;
			}else {
				break;
			}
		}
		return pair;
	}
	
	public void threeElementsSumIsK(int[] array, int k) {
		Arrays.sort(array);
		for(int index = array.length-1;index>=0;index--) {
			int lowIndex=0;
			int highIndex=array.length-1;
			int requiredSum = k-array[index];
			while(lowIndex<highIndex) {
				if(lowIndex==index) {
					lowIndex++;
				}else if(highIndex==index) {
					highIndex--;
				}
				int sum = requiredSum - array[lowIndex]- array[highIndex];
				if(sum>0) {
					lowIndex++;
				}else if(sum<0) {
					highIndex--;
				}else {
					System.out.format(" value 1: %d, value 2: %d, value 3: %d ",array[lowIndex],array[highIndex],array[index]);
					System.out.println();
				break;	
				}
			}
		}	
	}
	
	public int searchForPivot(int[] array) {
		int lowIndex = 0;
		int highIndex = array.length - 1;
		while (lowIndex <= highIndex) {
			int mid = (lowIndex + highIndex) / 2;
			if ((array[mid] - array[mid-1] > 0) && (array[mid + 1] - array[mid] < 0)) {
				return array[mid];
			} else if (array[mid+1]-array[mid]>0) {
				lowIndex = mid-1;
			} else {
				highIndex = mid+1;
			}
		}
		return -1;
	}
	
	public int binarySearchForFirstOccurence(int[] sortedArry, int k) {
		int lowIndex = 0;
		int highIndex = sortedArry.length-1;
		while(lowIndex<highIndex) {
			int mid = (lowIndex+highIndex)/2;
			if(sortedArry[mid]<k) {
				lowIndex = mid+1;
			}else if(sortedArry[mid]>k) {
				highIndex = mid-1;
			}else {
				if(sortedArry[mid]==sortedArry[mid-1]) {
					highIndex=mid-1;
				}else {
					return mid;
				}
			}
		}
		return -1;
	}
	
	public int binarySearchForLastOccurence(int[] sortedArry, int k) {
		int lowIndex = 0;
		int highIndex = sortedArry.length-1;
		while(lowIndex<=highIndex) {
			int mid = (lowIndex+highIndex)/2;
			if(sortedArry[mid]<k) {
				lowIndex = mid+1;
			}else if(sortedArry[mid]>k) {
				highIndex = mid-1;
			}else {
				if(sortedArry[mid]==sortedArry[mid+1]) {
					lowIndex=mid+1;
				}else {
					return mid;
				}
			}
		}
		return -1;
	}
	
	// 1 one one -> 11, two one - 21, one two one one 1211, one(count) one one(count) two two(count) one
	
	public void nextSequenceOfOne(int n,int numberOfSequence) {
		String str = String.valueOf(n);
		while(numberOfSequence>0) {
			String temp = "";
			int count = 1;
			for(int index=0;index<str.length();index++){
				if(index+1<str.length() && str.charAt(index)==str.charAt(index+1)) {
					count+=1;
				}else {
					temp = temp+count;
					temp = temp+str.charAt(index);
					count = 1;
				}
			}
			str = temp;
			System.out.println(temp);
			numberOfSequence--;
		}
	}
	
	public void majorityNumber(int[] array) {
		int counter=0;
		int element=0;
		for(int index=0;index<array.length;index++) {
			if(counter==0) {
				element = array[index];
				counter=1;
			}else if(element==array[index]) {
				counter++;
			}else {
				counter--;
			}
		}
		System.out.println(element);
	}
	
	public void shuffleArray(int[] evenOddArray, int n) {
		int elementIndexToSwap = n;
		for(int baseIndex=1;baseIndex<evenOddArray.length-1&&baseIndex+1<elementIndexToSwap;baseIndex=baseIndex+2) {
			for(int swapIndex=elementIndexToSwap;swapIndex>baseIndex;swapIndex--) {
				swap(evenOddArray,swapIndex,swapIndex-1);
			}
			elementIndexToSwap++;
		}
		for(int eachVal:evenOddArray)
			System.out.println(eachVal);
	}
	
	private void swap(int[] array,int index1,int index2) {
		int temp = array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
	}
}
