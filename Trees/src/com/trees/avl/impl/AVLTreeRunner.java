package com.trees.avl.impl;

public class AVLTreeRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTreesImpl<Integer> avlRunner = new AVLTreesImpl<Integer>();
		
		AVLTreesImpl<Integer>.AVLNode root1 = avlRunner.insertNode(null, 1);
		AVLTreesImpl<Integer>.AVLNode root2 = avlRunner.insertNode(root1,2);
		AVLTreesImpl<Integer>.AVLNode root3 = avlRunner.insertNode(root2,3);
		
		inOrderTraversal(root3);
	}
	
	public static void inOrderTraversal(AVLTreesImpl<Integer>.AVLNode root) {
		if(root==null) {
			return;
		}
		inOrderTraversal(root.leftChild);
		System.out.println(root.data);
		inOrderTraversal(root.rightChild);
	}

}
