package com.java.multithreading.challenges.matrixmultiplication;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class MatrixMultiplier {

	public static void main(String[] args) {
		int[][] matrix1 = {{1,2},{3,4},{5,6}};
		int[][] matrix2 = {{1,2,3},{5,6,7}};
		
		//System.out.println(matrix1.length);
//		SequentialMatrixMultiplier seqMultiplier = new SequentialMatrixMultiplier(matrix1,matrix2);
//		
//		for(int[] row:seqMultiplier.computeProduct()) {
//			for(int val:row) {
//				System.out.print(val+", ");
//			}
//			System.out.println();
//		}
		ParallelMatrixMultiplier parallelWorker = new ParallelMatrixMultiplier(matrix1,matrix2);
		
	}
	
}

class SequentialMatrixMultiplier{
	private int[][] matrix1;
	private int[][] matrix2;
	
	private int matrix1Row, matrix1Col, matrix2Row, matrix2Col;
	
	public SequentialMatrixMultiplier(int[][] matrix1, int [][] matrix2) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.matrix1Row = matrix1.length;
		this.matrix1Col = matrix1[0].length;
		this.matrix2Row = matrix2.length;
		this.matrix2Col = matrix2[0].length;
		if(matrix1Col!=matrix2Row)
			throw new Error(String.format("Invalid dimensions; Cannot multiply %dx%d*%dx%d\n",matrix1Row,matrix1Col,
					matrix2Row,matrix2Col));
	}
	
	public int[][] computeProduct(){
		int[][] productMatrix = new int[matrix1Row][matrix2Col];
		for(int rowIndex=0;rowIndex<matrix1Row;rowIndex++) {
			for(int colIndex=0;colIndex<matrix2Col;colIndex++) {
				for(int index=0;index<matrix1Col;index++) {
					productMatrix[rowIndex][colIndex] = productMatrix[rowIndex][colIndex] + matrix1[rowIndex][index]*matrix2[index][colIndex];
				}
			}
		}
		return productMatrix;
	}
}

class ParallelMatrixMultiplier{
	private int[][] matrix1;
	private int[][] matrix2;
	
	private int matrix1Row, matrix1Col, matrix2Row, matrix2Col;
	
	int[][] productMatrix = new int[matrix1Row][matrix2Col];
	
	public ParallelMatrixMultiplier(int[][] matrix1, int [][] matrix2) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.matrix1Row = matrix1.length;
		this.matrix1Col = matrix1[0].length;
		this.matrix2Row = matrix2.length;
		this.matrix2Col = matrix2[0].length;
		if(matrix1Col!=matrix2Row)
			throw new Error(String.format("Invalid dimensions; Cannot multiply %dx%d*%dx%d\n",matrix1Row,matrix1Col,
					matrix2Row,matrix2Col));
	}
	
	
	
}