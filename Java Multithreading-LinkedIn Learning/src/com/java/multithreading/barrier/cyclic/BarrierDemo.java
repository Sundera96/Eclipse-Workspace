package com.java.multithreading.barrier.cyclic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BarrierDemo {

	public static void main(String[] args) throws InterruptedException {
		Shopper[] shoppers = new Shopper[10];
		for(int index=0;index<shoppers.length/2;index++) {
			shoppers[2*index] = new Shopper("Barron-"+index);
			shoppers[2*index+1] = new Shopper("Olivia-"+index);
		}
		for(Shopper s : shoppers)
			s.start();
		for(Shopper s : shoppers)
			s.join();
		System.out.println("We need to buy "+ Shopper.bagsOfChips+" bags of chips");
	}
}

class Shopper extends Thread{
	public static int bagsOfChips = 1;
	private static Lock pencil = new ReentrantLock();
	private static CyclicBarrier fistBump = new CyclicBarrier(10);
	
	public Shopper(String name) {
		this.setName(name);
	}
	
	public void run() {
		if(this.getName().contains("Olivia")){
			pencil.lock();
			try {
				bagsOfChips += 3;
				System.out.println(this.getName()+" Added three bags of chips.");
			}finally {
				pencil.unlock();
			}try {
				fistBump.await();
			}catch(InterruptedException|BrokenBarrierException e) {
				e.printStackTrace();
			}
		}else {
			try {
				fistBump.await();
			}catch(InterruptedException|BrokenBarrierException e) {
				e.printStackTrace();
			}
			pencil.lock();
			try {
				bagsOfChips *= 2;
				System.out.println(this.getName()+" Doubled the bags of chips");
			}finally {
				pencil.unlock();
			}
		}
	}
}
