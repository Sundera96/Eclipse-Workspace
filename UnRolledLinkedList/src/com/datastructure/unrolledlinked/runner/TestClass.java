package com.datastructure.unrolledlinked.runner;

public class TestClass<T extends Comparable<T>>{

	public static void main(String[] args) {
		TestClass<Integer> run = new TestClass<Integer>();
		run.method(1);
	}
	
	
	
	public <T> void method(T data) {
		T[] array = (T[]) new Object[5];
		array[0]=data;
		System.out.println(array[0]);
	}
}
