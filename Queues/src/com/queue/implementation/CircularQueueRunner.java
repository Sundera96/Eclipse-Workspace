package com.queue.implementation;

public class CircularQueueRunner {

	public static void main(String[] args) {
		DynamicCircularQueueImpl<Integer> circularQueue = new DynamicCircularQueueImpl<Integer>(4);
		circularQueue.addObject(1);
		circularQueue.addObject(2);
		circularQueue.addObject(3);
		circularQueue.addObject(4);
		circularQueue.addObject(5);
		circularQueue.addObject(7);
		circularQueue.addObject(8);
		circularQueue.addObject(9);
		circularQueue.addObject(10);
//		circularQueue.deQueue();
//		circularQueue.deQueue();
//		circularQueue.deQueue();
//		circularQueue.deQueue();
//		circularQueue.deQueue();
//		circularQueue.deQueue();
//		circularQueue.deQueue();
		circularQueue.visualizeCircularQueue();
	}
}
