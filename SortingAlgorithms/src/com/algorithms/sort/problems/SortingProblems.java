package com.algorithms.sort.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortingProblems {
	
	class QueueNode{
		Integer[] array;
		int indexToAccess;
		
		public QueueNode(Integer[] array,int indexToAcess) {
			this.array=array;
			this.indexToAccess=indexToAcess;
		}
	}

	public void sortKArrays(Integer[][] unSorted2dArray) {
		Comparator<QueueNode> comparator = new Comparator<QueueNode>() {
			@Override
			public int compare(QueueNode o1, QueueNode o2) {
				// o1 should be prioritized first hence returning o1
				if(o1.array[o1.indexToAccess]>o2.array[o2.indexToAccess]) {
					return 1;
				}
				else if(o1.array[o1.indexToAccess]<o2.array[o2.indexToAccess]) {
					return -1;
				}else {
					return 0;
				}
			}
		};
		PriorityQueue<QueueNode> priorityQueue = new PriorityQueue<QueueNode>(unSorted2dArray.length,comparator);
		int totalCountOfElements=0;
		int sortedIndex=0;
		for(int index=0;index<unSorted2dArray.length;index++) {
			priorityQueue.add(new QueueNode(unSorted2dArray[index],0));
			totalCountOfElements+=unSorted2dArray[index].length;
		}
		Integer[] sortedArray = new Integer[totalCountOfElements];
		while(!priorityQueue.isEmpty()) {
			QueueNode node = priorityQueue.poll();
			System.out.println(node.array[node.indexToAccess]);
			sortedArray[sortedIndex++]=node.array[node.indexToAccess];
			if(node.indexToAccess+1<node.array.length) {
				priorityQueue.add(new QueueNode(node.array,node.indexToAccess+1));
			}
		}
	}
	
	public static void main(String[] args) {
		//Integer[][] unsorted2dArray = {{1,5,9,13,17},{2,6,10,14,18},{3,7,11,15,19},{4,8,12,16,20}};
		int[] array = {1,2,3,3,3,5,6,7,8};
		SortingProblems sorting = new SortingProblems();
		//System.out.println(unsorted2dArray);
		//sorting.sortKArrays(unsorted2dArray);
		System.out.println(sorting.removeDuplicates(array));
	}
	
	private int removeDuplicates(int[] sortedDuplicateArray) {
		int indexToStore=1;
		for(int arrayIndex=1;arrayIndex<sortedDuplicateArray.length;arrayIndex++) {
			if(sortedDuplicateArray[arrayIndex-1]!=sortedDuplicateArray[arrayIndex]) {
				sortedDuplicateArray[indexToStore++] = sortedDuplicateArray[arrayIndex];
			}
		}
		return indexToStore;
	}
	
}
