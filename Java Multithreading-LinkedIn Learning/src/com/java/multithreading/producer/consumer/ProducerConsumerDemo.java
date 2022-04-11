package com.java.multithreading.producer.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class SoupProducer extends Thread{
	private BlockingQueue<String> servingLine;
	
	public SoupProducer(BlockingQueue<String> servingLine) {
		this.servingLine=servingLine;
	}
	
	public void run() {
		for(int soup=0;soup<20;soup++) {
			try {
				servingLine.add("Bowl #"+soup);
				System.out.format("Served Bowl #%d - remaining capacity: %d\n",soup,servingLine.remainingCapacity());
				Thread.sleep(200);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		servingLine.add("no soup for you!");
		servingLine.add("no soup for you!");
	}
}

class SoupConsumer extends Thread{
	private BlockingQueue<String> servingLine;
	
	public SoupConsumer(BlockingQueue<String> servingLine) {
		this.servingLine=servingLine;
	}
	
	public void run() {
		while(true) {
			try {
				String bowl = servingLine.take();
				if(bowl == "no soup for you!")
					break;
				System.out.format("Ate %s\n", bowl);
				Thread.sleep(300);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class ProducerConsumerDemo{
	public static void main(String[] args) {
		BlockingQueue<String> servingLine = new ArrayBlockingQueue<String>(5);
		new SoupConsumer(servingLine).start();
		new SoupConsumer(servingLine).start();
		new SoupProducer(servingLine).start();
	}
}