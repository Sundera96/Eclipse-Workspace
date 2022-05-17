package com.algorithms.sort.comparisonsort;

import java.text.DecimalFormat;

public class RadixSort {

	public void radixSortAlgorithm() {
		
	}
	
	public static void main(String[] args) {
		CountingSort sort = new CountingSort();
		DecimalFormat df = new DecimalFormat("#.####");
		float[] array = {1.23f,4.24f,1.213f,2.12f,7.22f,5.32f,2.234f};
		for(int index=0;index<array.length;index++) {
			
			array [index] = Float.valueOf(df.format(array [index]));
			System.out.println(array[index]);
		}
	}
}
