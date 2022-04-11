package com.datastructure.unrolledlinked.implementation2;

public class UnRolledLinkedListImpl<T extends Comparable<T>> {
private int capacity;
private UnRolledLinkedListNode startNode;
private UnRolledLinkedListNode endNode;

public UnRolledLinkedListImpl(int capacity){
	this.capacity=capacity;
}

	public class UnRolledLinkedListNode{
		private T[] array;
		private int size;
		private UnRolledLinkedListNode next;
		public UnRolledLinkedListNode() {
			this.size=0;
			this.next=null;
			this.array = (T[]) new Object[capacity];
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
			while((tempNode.array[tempNode.size-1]).compareTo(data)<1&&tempNode.next!=null) {
				tempNode = tempNode.next;
			}
			if(tempNode.size==capacity) {
				tranferHalfToNextNode(tempNode,data);
			}
			
			if((tempNode.array[tempNode.size-1]).compareTo(data)<1&&tempNode.next!=null)
				store(tempNode.next,data);
			else
				store(tempNode,data);
			
		}
		return 1;	
	}
	
	private void store(UnRolledLinkedListNode tempNode,T data) {
		boolean copy = false;
		T temp = null;
		for(int index=0;index<tempNode.size+1;index++) {
			if(tempNode.array[index]==null) {
				tempNode.array[index]=data;
				tempNode.size++;
				break;
			}
			else if(data.compareTo((T) tempNode.array[index])<1&&!copy) {
				temp = (T) tempNode.array[index];
				tempNode.array[index]=data;
				tempNode.size++;
				copy = true;
			}
			else if(copy) {
				data=(T) tempNode.array[index];
				tempNode.array[index]=temp;
				temp = data;
			}
		}
		
	}

	private void tranferHalfToNextNode(UnRolledLinkedListNode tempNode, T data) {
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
	
}
