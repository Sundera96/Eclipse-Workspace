package com.trees.avl.impl;

public class AVLTreesImpl<T extends Comparable<T>> {
	
	public class AVLNode{
		public AVLNode leftChild;
		public AVLNode rightChild;
		public T data;
		public int height;
		public AVLNode(T data){
			this.height=0;
			this.data=data;
		}
	}
	
	public AVLNode insertNode(AVLNode root, T data) {
		if(root==null) {
			root = new AVLNode(data);
			root.leftChild=null;
			root.rightChild=null;
		}
		else if(data.compareTo(root.data)==-1) {
			root.leftChild=insertNode(root.leftChild,data);
			if(Math.abs(heightOfAVL(root.leftChild)-heightOfAVL(root.rightChild))==2) {
				if(data.compareTo(root.leftChild.data)==-1) {
					root=rightRotation(root);
				}else {
					root=leftRightRotation(root);
				}
			}
		}
		else if(data.compareTo(root.data)==1) {
			root.rightChild=insertNode(root.rightChild,data);
			if(Math.abs(heightOfAVL(root.leftChild)-heightOfAVL(root.rightChild))==2) {
				if(data.compareTo(root.rightChild.data)==1) {
					root=leftRotation(root);
				}else {
					root=rightLeftRotation(root);
				}
			}
		}
		root.height = Math.max(heightOfAVL(root.leftChild),heightOfAVL(root.rightChild))+1;
		return root;
	}
	
	//Right Rotation 
	private AVLNode rightRotation(AVLNode root) {
		AVLNode temp = root.leftChild;
		root.leftChild = temp.rightChild;
		temp.rightChild=root;
		root.height=Math.max(heightOfAVL(root.leftChild),heightOfAVL(root.rightChild))+1;
		temp.height=Math.max(heightOfAVL(temp.leftChild),heightOfAVL(temp.rightChild))+1;
		return temp;
	}
	
	private int heightOfAVL(AVLNode root) {
		if(root==null)
			return -1;
		return root.height;
	}
	
	private AVLNode leftRotation(AVLNode root) {
		AVLNode temp = root.rightChild;
		root.rightChild=temp.leftChild;
		temp.leftChild=root;
		root.height=Math.max(heightOfAVL(root.leftChild),heightOfAVL(root.rightChild))+1;
		temp.height=Math.max(heightOfAVL(temp.leftChild),heightOfAVL(temp.rightChild))+1;
		return temp;
	}
	
	private AVLNode leftRightRotation(AVLNode root) {
		root.leftChild=leftRotation(root.leftChild);
		return rightRotation(root);
	}
	
	private AVLNode rightLeftRotation(AVLNode root) {
		root.rightChild=rightRotation(root.rightChild);
		return rightRotation(root);
	}
}
