package com.trees.problems.binarysearchtree.impl;

public class TreeNode<T> {
	protected T data;
	protected TreeNode<T> leftChild;
	protected TreeNode<T> rightChild;
	protected TreeNode<T> next;
	public TreeNode(T data) {
		this.data=data;
	}
}
