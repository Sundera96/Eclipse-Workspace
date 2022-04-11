package com.trees.traversals.implementation;

public class TreeNode<T> {
	protected T data;
	protected TreeNode<T> leftChild;
	protected TreeNode<T> rightChild;
	public TreeNode(T data) {
		this.data=data;
	}
}
