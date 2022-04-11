package com.queue.problems;

import java.util.LinkedList;
import java.util.Queue;

public class QueueProblems {

	public static void main(String[] args) {
		QueueProblems runner = new QueueProblems();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		queue.add(7);
		queue.add(8);
		runner.reverseQueue(queue);
		//System.out.println(queue.toString());
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
	
	public void reverseQueue(Queue<Integer> queue) {
		if(queue.isEmpty()) {
			return;
		}
		int data = queue.poll();
		reverseQueue(queue);
		queue.add(data);
	}
	
	public void interLeavingQueue(Queue<Integer> queue) {
		if(queue.size()%2==1) {
			throw new IllegalArgumentException();
		}
		int halfSize = queue.size()/2;
		Queue<Integer> tempQueue = new LinkedList<Integer>();
		for(int index=0;index<halfSize;index++) {
			tempQueue.add(queue.poll());
		}
		
	}
}
