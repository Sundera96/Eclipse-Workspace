package com.queue.implementation;

public class DynamicCircularQueueImpl<T> {

	private Object[] circularQueue;
	private int capacity; 
	private int front;
	private int rear;
	private int size;
	
	protected DynamicCircularQueueImpl(int capacity) {
		this.capacity=capacity;
		circularQueue = new Object[capacity];
		front=0;
		rear=-1;
	}
	
	public void addObject(T data) {
		if(size==capacity) {
			expandCircularQueue();
		}
		circularQueue[++rear]=(T)data;
		size++;
	}
	
	public void deQueue() {
		if(size<capacity/4) {
			shrinkCircularQueue();
		}
		circularQueue[front++]=null;
		front = front%capacity;
		size--;
	}
	
	private void shrinkCircularQueue() {
		// TODO Auto-generated method stub
		Object[] newCircularQueue = new Object[capacity/2];
		int index=-1;
		while(front-1!=rear) {
			front = front%capacity;
			newCircularQueue[++index]=circularQueue[front++];
		}
		rear=index;
		front=0;
		capacity = capacity/2;
		circularQueue = newCircularQueue;
	}

	private void expandCircularQueue() {
		Object[] newCircularQueue = new Object[capacity*2];
		int index=-1;
		while(front-1!=rear) {
			front = front%capacity;
			newCircularQueue[++index]=circularQueue[front++];
		}
		rear=index;
		front=0;
		capacity = capacity*2;
		circularQueue = newCircularQueue;
	}
	
	public void printCircularQueue() {
		int temp = front;
		while(temp-1!=rear) {
			temp = temp%capacity;
			System.out.println(circularQueue[temp++]);
		}
	}
	
	public void visualizeCircularQueue() {
		for(int index=0;index<capacity;index++) {
			System.out.println(circularQueue[index]);
		}
	}
}
