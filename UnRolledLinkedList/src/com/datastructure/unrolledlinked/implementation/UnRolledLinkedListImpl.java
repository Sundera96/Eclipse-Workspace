package com.datastructure.unrolledlinked.implementation;

public class UnRolledLinkedListImpl<T extends Comparable<T>> {
private int capacity;
private UnRolledLinkedListNode startNode;
private UnRolledLinkedListNode endNode;

public UnRolledLinkedListImpl(int capacity){
	this.capacity=capacity;
}

	public class UnRolledLinkedListNode{
		private Object[] array;
		private int size;
		private UnRolledLinkedListNode next;
		public UnRolledLinkedListNode() {
			this.size=0;
			this.next=null;
			this.array = new Object[capacity];
		}
	}
	
	public int addData(T data) {
		if(startNode==null) {
			UnRolledLinkedListNode newNode = new UnRolledLinkedListNode();
			newNode.array[newNode.size]=data;
			newNode.size++;
			startNode = newNode;
			endNode = newNode;
			endNode.next=null;
		}
		else{
			UnRolledLinkedListNode tempNode = startNode;
			int val = ((Comparable<T>) tempNode.array[tempNode.size-1]).compareTo(data);
			while(((Comparable<T>) tempNode.array[tempNode.size-1]).compareTo(data)<0&&tempNode.next!=null) {
				tempNode = tempNode.next;
			}
			if(tempNode.size==capacity) {
				tranferHalfToNewNode(tempNode);
			}
			
			if(((Comparable<T>) tempNode.array[tempNode.size-1]).compareTo(data)<0&&tempNode.next!=null)
				store(tempNode.next,data);
			else
				store(tempNode,data);
			
		}
		return 1;	
	}
	
	private void store(UnRolledLinkedListNode tempNode,T data) {
		boolean copy = false;
		T temp = data;
		for(int index=0;index<capacity;index++) {
			if(tempNode.array[index]==null) {
				tempNode.array[index]=temp;
				tempNode.size++;
				break;
			}
			else if(data.compareTo((T) tempNode.array[index])<0&&!copy) {
				temp = (T) tempNode.array[index];
				tempNode.array[index]=data;
				copy = true;
			}
			else if(copy) {
				data=(T) tempNode.array[index];
				tempNode.array[index]=temp;
				temp = data;
			}
		}
		
	}

	private void tranferHalfToNewNode(UnRolledLinkedListNode tempNode) {
		// TODO Auto-generated method stub
		UnRolledLinkedListNode newNode = new UnRolledLinkedListNode();
		newNode.next=tempNode.next;
		tempNode.next=newNode;
		int newNodeIndex=0;
		for(int index=capacity/2+1;index<capacity;index++) {
			newNode.array[newNodeIndex++]=tempNode.array[index];
			tempNode.array[index]=null;
			newNode.size++;
			tempNode.size--;
		}
	}
	
	public void printLL() {
		UnRolledLinkedListNode tempNode = startNode;
		while(tempNode!=null) {
			for(int index=0;index<tempNode.size;index++) {
				System.out.print(tempNode.array[index]+" ");
			}
			System.out.println();
			tempNode=tempNode.next;
		}
	}
	
	public int findAndRemove(T data) {
		UnRolledLinkedListNode tempNode = startNode;
		UnRolledLinkedListNode prevNode=null;
		while(((Comparable<T>) tempNode.array[tempNode.size-1]).compareTo(data)<1&&tempNode.next!=null) {
			prevNode = tempNode;
			tempNode = tempNode.next;
		}
		remove(tempNode,data);
		if(tempNode.size<=capacity/4)
			moveDataToLeftRightNode(tempNode,prevNode);
		return 1;
	}

	private void moveDataToLeftRightNode(UnRolledLinkedListNode tempNode,UnRolledLinkedListNode prevNode) {
		// TODO Auto-generated method stub
		if((2*capacity)-prevNode.size-tempNode.next.size>tempNode.size) {
			copyToPrevAndNextNode(tempNode,prevNode);
		}
	}

	private void copyToPrevAndNextNode(UnRolledLinkedListNode currentNode,
			UnRolledLinkedListNode prevNode) {
		// TODO Auto-generated method stub
		UnRolledLinkedListNode helperNode = new UnRolledLinkedListNode();
		int helperIndex=0;
		boolean isShiftRequired=false;
		for(int index=0;index<currentNode.size;index++) {
			if(prevNode.size<capacity) {
				prevNode.array[prevNode.size]=currentNode.array[index];
				prevNode.size++;
			}else {
				helperNode.array[helperIndex++]=currentNode.array[index];
				helperNode.size++;
				isShiftRequired=true;
			}
		}
		for(int index=0;index<currentNode.next.size;index++) {
			helperNode.array[helperIndex++]=currentNode.next.array[index];
			helperNode.size++;
		}
		currentNode.next.array=helperNode.array.clone();
		currentNode.next.size=helperNode.size;
		prevNode.next=currentNode.next;
		currentNode.next=null;
	}

	private void remove(final UnRolledLinkedListNode tempNode, final T data) {
		// TODO Auto-generated method stub
		boolean copy = false;
		int index;
		for(index=0;index<tempNode.size-1;index++) {

			if(data.compareTo((T) tempNode.array[index])==0&&!copy) {
				tempNode.array[index]=tempNode.array[index+1];
				copy = true;
			}
			else if(copy) {
				tempNode.array[index] = tempNode.array[index+1];
			}
		}
		tempNode.array[index] = null;
		tempNode.size--;
	}
	
}
