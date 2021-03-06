package com.java.dsa.tree.heaps;

public class BinaryHeap {

	int[] heapArray;
	int count;
	int capacity;
	int heapType;
	
	public BinaryHeap(int capacity,int heapType) {
		this.capacity=capacity;
		this.heapType=heapType;
	}
	
	public int indexParent(int i) {
		if((i-1)/2>=0)
			return (i-1)/2;
		return -1;
	}
	
	public int leftIndexChildren(int index) {
		int left = 2*index+1;
		if(left>capacity) {
			return -1;
		}
		return left;
	}
	
	public int rightIndexChildren(int index) {
		int right = 2*index+2;
		if(right>capacity) {
			return -1;
		}
		return right;
	}
	
	public int getIndexMaxElement() {
		if(capacity==0)
			return -1;
		return 0;
	}
	
	public void maxHeapify(int index) {
		int leftChildIndex = leftIndexChildren(index);
		int rightChildIndex = rightIndexChildren(index);
		int maxIndex;
		if(leftChildIndex!=-1&&heapArray[leftChildIndex]>heapArray[index]) {
			maxIndex = leftChildIndex;
		}else {
			maxIndex = index;
		}
		if(heapArray[maxIndex]<heapArray[rightChildIndex]) {
			maxIndex =rightChildIndex;
		}
		if(maxIndex!=index) {
			int tempData = heapArray[index];
			heapArray[index]=heapArray[maxIndex];
			heapArray[maxIndex]=tempData;
			maxHeapify(maxIndex);
		}
	}
	
	public void insert(int data) {
		if(count==capacity) {
			//resize
			resizeHeapArray();
		}
		heapArray[count++]=data;
		int index = count-1;
		while(index!=-1&&heapArray[indexParent(index)]<data) {
			heapArray[index] = heapArray[indexParent(index)];
			index = indexParent(index);
		}
		heapArray[index] = data;
	}
	
	public void resizeHeapArray(){
		int[] newArray = new int[capacity*2];
		int index=0;
		for(int eachVal:heapArray)
			newArray[index++]=eachVal;
		capacity = capacity*2;
		heapArray = newArray;
	}
}
