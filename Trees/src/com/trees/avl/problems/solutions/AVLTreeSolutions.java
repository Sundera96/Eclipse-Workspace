package com.trees.avl.problems.solutions;

import com.trees.avl.impl.AVLTreesImpl;


public class AVLTreeSolutions {

	private int counter=0;
	public  AVLTreesImpl<Integer>.AVLNode generateMinimumNodedAVLTree(int h) {
		if(h<=-1) {
			return null;
		}
		AVLTreesImpl<Integer>.AVLNode tempNode = new AVLTreesImpl<Integer>().new AVLNode(-1);
		tempNode.leftChild = generateMinimumNodedAVLTree(h-1);
		tempNode.data = counter++;
		tempNode.rightChild = generateMinimumNodedAVLTree(h-2);
		tempNode.height = Math.max(heightOf(tempNode.leftChild),heightOf(tempNode.rightChild))+1;
		return tempNode;	
	}
	private int heightOf(AVLTreesImpl<Integer>.AVLNode root) {
		if(root==null) {
			return -1;
		}
		return root.height;
	}
	
	public static void main(String[] args) {
		//AVLTreeSolutions avlSolutionRunner = new AVLTreeSolutions();
		//AVLTreeRunner.inOrderTraversal(avlSolutionRunner.generateMinimumNodedAVLTree(3));
		AVLTreesImpl<Integer> avlRunner = new AVLTreesImpl<Integer>();
		
		AVLTreesImpl<Integer>.AVLNode root1 = avlRunner.insertNode(null, 1);
		AVLTreesImpl<Integer>.AVLNode root2 = avlRunner.insertNode(root1,2);
		AVLTreesImpl<Integer>.AVLNode root3 = avlRunner.insertNode(root2,3);
		AVLTreesImpl<Integer>.AVLNode root4 = avlRunner.insertNode(root3,4);
		AVLTreesImpl<Integer>.AVLNode root5 = avlRunner.insertNode(root4,5);
		AVLTreesImpl<Integer>.AVLNode root6 = avlRunner.insertNode(root5,6);
		AVLTreesImpl<Integer>.AVLNode root7 = avlRunner.insertNode(root6,7);
		AVLTreesImpl<Integer>.AVLNode root8 = avlRunner.insertNode(root7,8);
		AVLTreesImpl<Integer>.AVLNode root9 = avlRunner.insertNode(root8,9);
		AVLTreesImpl<Integer>.AVLNode root10 = avlRunner.insertNode(root9,10);
		AVLTreesImpl<Integer>.AVLNode root11= avlRunner.insertNode(root10,11);
		System.out.println(root11.data);
		//System.out.println(avlSolutionRunner.rangeCount(root8,3,8));
	}
	
	public int rangeCount(AVLTreesImpl<Integer>.AVLNode root,int a,int b) {
		if(root==null) {
			return 0;
		}
		int left =rangeCount(root.leftChild,a,b);
		int right = rangeCount(root.rightChild,a,b);
		if(root.data>=a&&root.data<=b) {
			return left+right+1;
		}
		return left!=0?left:right;
	}
	
}
