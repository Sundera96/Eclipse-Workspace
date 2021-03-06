package com.trees.traversals.implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal<T> {

	public static void main(String[] args) {
		TreeNode<Integer> node1 = new TreeNode<Integer>(1);
		TreeNode<Integer> node2 = new TreeNode<Integer>(2);
		TreeNode<Integer> node3 = new TreeNode<Integer>(3);
		TreeNode<Integer> node4 = new TreeNode<Integer>(4);
		TreeNode<Integer> node5 = new TreeNode<Integer>(5);
		TreeNode<Integer> node6 = new TreeNode<Integer>(6);
		TreeNode<Integer> node7 = new TreeNode<Integer>(7);
		
		node1.leftChild=node2;
		node1.rightChild=node3;
		node2.leftChild=node4;
		node2.rightChild=node5;
		node3.leftChild=node6;
		node3.rightChild=node7;
		
		Traversal<Integer> traversalRunner = new Traversal<Integer>();
		traversalRunner.preOrderTraversal(node1);
		//traversalRunner.postOrderTraversal(node1);
		//traversalRunner.levelOrderTraversal(node1);
	}
	
	public TreeNode<T> preOrderTraversal(TreeNode<T> root){
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode<T> temp = stack.pop();
			System.out.println(temp.data);
			if(temp.rightChild!=null) {
				stack.push(temp.rightChild);
			}
			if(temp.leftChild!=null) {
				stack.push(temp.leftChild);
			}
		}
		return root;
	}
	
	public TreeNode<T> inOrderTraversal(TreeNode<T> root){
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		TreeNode<T> currNode = root;
		boolean endTraversal = false;
		while(!endTraversal) {
			if(currNode!=null) {
				stack.push(currNode);
				currNode=currNode.leftChild;
			}
			else {
				if(stack.isEmpty()) {
					endTraversal=true;
				}
				else {
					currNode=stack.pop();
					System.out.println(currNode.data);
					currNode=currNode.rightChild;
				}
			}
		}
		return root;
	}
	
	public TreeNode<T> postOrderTraversal(TreeNode<T> root){
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		stack.push(root);
		TreeNode<T> prevNode=null;
		while(!stack.isEmpty()) {
			TreeNode<T> currNode = stack.peek();
			if(prevNode==null||prevNode.leftChild==currNode||prevNode.rightChild==currNode) {
				if(currNode.leftChild!=null) {
					stack.push(currNode.leftChild);
				}
				else if(currNode.rightChild!=null){
					stack.push(currNode.rightChild);
				}
			}
			else if(currNode.leftChild==prevNode) {
				if(currNode.rightChild!=null) {
					stack.push(currNode.rightChild);
				}
			}else {
				System.out.println(stack.pop().data);
			}
			prevNode=currNode;
		}
		return root;
	}
	
	public TreeNode<T> levelOrderTraversal(TreeNode<T> root){
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode<T> currNode = queue.poll();
			if(currNode.leftChild!=null) {
				queue.add(currNode.leftChild);
			}
			if(currNode.rightChild!=null) {
				queue.add(currNode.rightChild);
			}
			System.out.println(currNode.data);
		}
		return root;
	}
}
