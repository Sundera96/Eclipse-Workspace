package com.java.datastructures.grap.krushkals;

public class DisjointSets {

	private int[] setArray;
	//private int capacity;
	
	public DisjointSets(int capacity) {
		setArray = new int[capacity];
		for(int index=0;index<capacity;index++) {
			setArray[index]=-1;
		}
		//this.capacity=capacity;
	}
	
	public int find(int index) {
		if(setArray[index]<0) {
			return index;
		}
		return find(setArray[index]);
	}
	
	public void unionBySize(int val1, int val2) {
		int index1 = find(val1);
		int index2 = find(val2);
		if(index1==index2)
			return;
		if(setArray[index1]>setArray[index2]) {
			int temp = setArray[index2];
			setArray[index2] = index1;
			setArray[index1]+=temp;
		}else {
			int temp = setArray[index1];
			setArray[index1] = index2;
			setArray[index2]+=temp;
		}
	}
}
