package com.stacks.dsa.problems;

import java.util.Stack;

public class StackProblems {

	public static void main(String[] args) {
		StackProblems stackRunner = new StackProblems();
//		int[] inputArray = {6,3,4,5,2};
//		inputArray=stackRunner.findingSpans(inputArray);
//		for(int val:inputArray)
//			System.out.println(val);
//		int[] inputArray = {3,2,5,6,1,4,4};
//		System.out.println(stackRunner.maxRectangleAreaInHistogram(inputArray));
//		Stack<Integer> unsortedStack = new Stack<Integer>();
//		unsortedStack.push(3);
//		unsortedStack.push(2);
//		unsortedStack.push(5);
//		unsortedStack.push(6);
//		unsortedStack.push(1);
//		unsortedStack.push(8);
//		unsortedStack=stackRunner.reverseStack(unsortedStack);
		int[] inputArray = {1,5,6,8,8,8,0,1,1,0,6,5};
		int val = stackRunner.removeAdjacentDuplicates(inputArray);
		for(int index=0;index<=val;index++) {
			System.out.println(inputArray[index]);
		}
		
	}
	
	public int[] findingSpans(int[] inputArray) {
		int[] spanArray = new int[inputArray.length];
		for(int index=0;index<inputArray.length;index++) 
			spanArray[index]=1;
		for(int index=1;index<inputArray.length;index++) {
			if(inputArray[index]>=inputArray[index-1]) {
				spanArray[index]=spanArray[index-1]+1;
			}
		}
		return spanArray;
	}
	
	public int maxRectangleAreaInHistogram(int[] heightArray) {
		Stack<Integer> stack = new Stack<Integer>();
		if(heightArray==null||heightArray.length==0) {
			return 0;
		}
		int maxArea=0;
		int index=0;
		while(index<heightArray.length) {
			if(stack.isEmpty()||heightArray[stack.peek()]<=heightArray[index]) {
				stack.push(index++);
			}
			else {
				int top = stack.pop();
				maxArea = Math.max(maxArea,heightArray[top]*(stack.isEmpty()?index:index-stack.peek()-1)); 
			}
		}
		while(!stack.isEmpty()) {
			int top = stack.pop();
			maxArea = Math.max(maxArea,heightArray[top]*(stack.isEmpty()?index:index-stack.peek()-1)); 
		}
		return maxArea;
	}
	
	public Stack<Integer> reverseStack(Stack<Integer> primaryStack){
		Stack<Integer> secondaryStack = new Stack<Integer>();
		while(!primaryStack.isEmpty()) {
			int temp = primaryStack.pop();
			while(!secondaryStack.isEmpty()&&secondaryStack.peek()<temp) {
				primaryStack.push(secondaryStack.pop());
			}
			secondaryStack.push(temp);
		}
		return secondaryStack;
	}
	
	public int removeAdjacentDuplicates(int[] array) {
		int stkPtr = -1;
		int index = 0;
		while(index<array.length) {
			if(stkPtr==-1||array[stkPtr]!=array[index]) {
				stkPtr++;
				array[stkPtr]=array[index];
				index++;
			}else {
				while(index<array.length&&array[stkPtr]!=array[index]) {
					index++;
				}
				stkPtr--;
			}
		}
		return stkPtr;
	}
}
