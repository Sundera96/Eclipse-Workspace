package com.trees.problems.binarysearchtree.impl;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BinarySearchTree {
	
	public static void main(String[] args) {
		BinarySearchTree runner = new BinarySearchTree();
//		TreeNode<Integer> root = runner.insert(null,6);
//		runner.insert(root,2);
//		runner.insert(root,1);
//		runner.insert(root,1);
//		runner.insert(root,8);
//		runner.insert(root,4);
//		runner.delete(root,150);
		TreeNode<Integer> node10 = new TreeNode<Integer>(10);
		TreeNode<Integer> node5 = new TreeNode<Integer>(5);
		//TreeNode<Integer> node9 = new TreeNode<Integer>(9);
		TreeNode<Integer> node15 = new TreeNode<Integer>(15);
		TreeNode<Integer> node3 = new TreeNode<Integer>(3);
		TreeNode<Integer> node7 = new TreeNode<Integer>(7);
		TreeNode<Integer> node12 = new TreeNode<Integer>(12);
		TreeNode<Integer> node17 = new TreeNode<Integer>(17);
		//TreeNode<Integer> node4 = new TreeNode<Integer>(4);
		
		node10.leftChild=node5;
		node10.rightChild=node15;
		node5.leftChild=node3;
		node5.rightChild=node7;
		node15.leftChild=node12;
		node15.rightChild=node17;
		
		//runner.preOrderTraversal(root);
		//runner.doubleyLinkedListTraversal(runner.binarySearchTreeToDLL(node10,node10));
		//System.out.println(runner.highestValuedNode(root).data);
		
		//runner.doubleyLinkedListTraversal(runner.binarySearchTreeToDLL(node10,null));
		//runner.printDivision(0,2);
//		Integer[] sample = {1,2,3,4,5,6};
//		List<Integer> example = Arrays.asList(sample);
//		runner.preOrderTraversal(runner.sortedListToBST(example));
		//System.out.println(runner.kthSmallestElement(node10,3,0).data);
		//System.out.println(runner.kthSmallestElement(node10, 3, new AtomicInteger(0)).data);
		//System.out.println(runner.findFloorInBST(node10,null,13).data);
		//System.out.println(runner.findCeilingInBST(node10,null,0).data);
		//runner.preOrderTraversal(runner.buildCompleteBST(3));
		//runner.preOrderTraversal(runner.buildCompleteBSTMergeSort(1,15));
		//runner.preOrderTraversal(runner.pruneBST(node10,12,15));
		//runner.linkLevelNodes(node10);
		runner.convertBSTToDLL(node10, null);
	}
	
	public void preOrderTraversal(TreeNode<Integer> root){
		if(root==null)
			return;
		
		
		preOrderTraversal(root.leftChild);
		System.out.println(root.data);
		preOrderTraversal(root.rightChild);
	}

	public TreeNode<Integer> insert(TreeNode<Integer> root,int data) {
		if(root==null) {
			root = new TreeNode<Integer>(data);
			root.leftChild=null;
			root.rightChild=null;
			return root;
		}
		else {
			if(data<root.data) {
				root.leftChild=insert(root.leftChild,data);
			}
			else if(data>root.data) {
				root.rightChild=insert(root.rightChild,data);
			}
		}
		return root;
	}
	
	public TreeNode<Integer> delete(TreeNode<Integer> root, int data){
		if(root==null) {
			return null;
		}
		else if(data<root.data&&root.leftChild!=null) {
			root.leftChild = delete(root.leftChild,data);
		}
		else if(data>root.data&&root.rightChild!=null) {
			root.rightChild =  delete(root.rightChild,data);
		}
		else {
			if(root.rightChild==null||root.leftChild==null) {
				if(root.rightChild==null) {
					return root.rightChild;
				}else {
					return root.leftChild;
				}
			}
			else {
				TreeNode<Integer> highVal = highestValuedNode(root.leftChild);
				root.data = highVal.data;
				return delete(root.leftChild,root.data);
			}
		}
		return root;
	}
	
	private TreeNode<Integer> highestValuedNode(TreeNode<Integer> root){
		if(root==null) {
			return null;
		}
		TreeNode<Integer> leftVal = null,rightVal=null,maxVal=null;
		if(root.leftChild!=null) {
			leftVal = highestValuedNode(root.leftChild);
		}
		if(root.rightChild!=null) {
			rightVal=highestValuedNode(root.rightChild);
		}
		if(leftVal!=null&&rightVal!=null)
			maxVal = leftVal.data>rightVal.data ? leftVal: rightVal;
		else if(leftVal==null||rightVal==null) {
				maxVal = leftVal==null ? rightVal:leftVal;
		}
		if(maxVal!=null)
			return maxVal.data>root.data ? maxVal: root;
		return root;
	}
	
	public boolean isBST(TreeNode<Integer> root,int min,int max) {
		if(root==null) {
			return true;
		}
		return root.data>min&&root.data<max&&isBST(root.leftChild,min,root.data)&&isBST(root.rightChild,root.data,max);
	}
	
	public TreeNode<Integer> binarySearchTreeToDLL(TreeNode<Integer> root,TreeNode<Integer> prev){
		 if(root==null) {
			 return prev;
		 }
		 
		 prev = binarySearchTreeToDLL(root.rightChild,prev);
		 
		 root.rightChild=prev;
		 if(prev!=null) {
			 prev.leftChild=root;
		 }
		 prev=root;
		 return binarySearchTreeToDLL(root.leftChild,prev);
	}
	
	public TreeNode<Integer> convertBSTToDLL(TreeNode<Integer> root, TreeNode<Integer> prev) {
		if(root==null) {
			return prev;
		}
		prev = convertBSTToDLL(root.leftChild,prev);
		root.leftChild=prev;
		if(prev!=null) {
			prev.rightChild=root;
		}
		
		prev = root;
		
		return convertBSTToDLL(root.rightChild,prev);
		
		
	}
	
	private void doubleyLinkedListTraversal(TreeNode<Integer> root) {
		while(root!=null) {
			System.out.println(root.data);
			root = root.rightChild;
		}
	}
	
	private void printDivision(int start,int end) {
		if(start>end)
			return;
		System.out.println("start: "+start+" End: "+end);
		
		int mid = start+(end-start)/2;
		System.out.println("mid: "+mid);
		printDivision(start,mid-1);
		System.out.println("-----------------");
		printDivision(mid+1,end);
	}
	
	public TreeNode<Integer> sortedListToBST(List<Integer> sortedList){
		return sortedListToBST(sortedList.iterator(),0,sortedList.size()-1);
	}

	private TreeNode<Integer> sortedListToBST(Iterator<Integer> sortedList, int start, int end) {
		// TODO Auto-generated method stub
		if(start>end) {
			return null;
		}
		int mid = start+(end-start)/2;
		TreeNode<Integer> left = sortedListToBST(sortedList,start,mid-1);
		Integer hasNext = null;
		TreeNode<Integer> root=null;
		if(sortedList.hasNext())
			hasNext=sortedList.next();
		if(hasNext!=null)
			root = new TreeNode<Integer>(hasNext);
		root.leftChild=left;
		root.rightChild = sortedListToBST(sortedList,mid+1,end);
		return root;
	}
	
	public TreeNode<Integer> kthSmallestElement(TreeNode<Integer> root,int k,AtomicInteger count){
		if(root==null)
			return null;
		TreeNode<Integer> left = kthSmallestElement(root.leftChild, k, count);
		if(count.incrementAndGet()==k)
			return root;
		TreeNode<Integer> right = kthSmallestElement(root.rightChild, k, count);
		return left!=null?left:right;
	}
	
	public TreeNode<Integer> findFloorInBST(TreeNode<Integer> root,TreeNode<Integer> prev,int element){
		if(root==null)
			return prev;
		
		prev = findFloorInBST(root.leftChild,prev,element);
		if(root.data==element) {
			return root;
		}
		else if(root.data>element)
			return prev;
		prev = root;
		return findFloorInBST(root.rightChild,prev,element);
		
	}
	
	public TreeNode<Integer> findCeilingInBST(TreeNode<Integer> root,TreeNode<Integer> prev, int element){
		if(root==null)
			return prev;
		
		prev = findCeilingInBST(root.rightChild,prev,element);
		if(root.data==element) {
			return root;
		}
		else if(root.data<element)
			return prev;
		prev = root;
		return findCeilingInBST(root.leftChild,prev,element);
	}
	int counter=1;
	
	public TreeNode<Integer> buildCompleteBST(int h){
		if(h==-1) {
			return null;
		}
		TreeNode<Integer> tempNode = new TreeNode<Integer>(-1);
		tempNode.leftChild = buildCompleteBST(h-1);
		tempNode.data=counter++;
		tempNode.rightChild = buildCompleteBST(h-1);
		return tempNode;
	}
	
	public TreeNode<Integer> buildCompleteBSTMergeSort(int start,int end){
		if(start>end) {
			return null;
		}
		int mid = start+(end-start)/2;
		TreeNode<Integer> tempNode = new TreeNode<Integer>(mid);
		tempNode.leftChild=buildCompleteBSTMergeSort(start,mid-1);
		tempNode.rightChild=buildCompleteBSTMergeSort(mid+1,end);
		return tempNode;
	}
	
	public boolean checkIfBST(TreeNode<Integer> root) {
		if(root==null) {
			return true;
		}
		boolean isLeftTrue = checkIfBST(root.leftChild);
		
		boolean isRightTrue = checkIfBST(root.rightChild);
		return Math.abs(checkIfBSTHeightHelper(root.leftChild)-checkIfBSTHeightHelper(root.rightChild))<2&&isLeftTrue&&isRightTrue;
	}
	
	private int checkIfBSTHeightHelper(TreeNode<Integer> root) {
		if(root==null) {
			return -1;
		}
		int left = checkIfBSTHeightHelper(root.leftChild);
		int right = checkIfBSTHeightHelper(root.rightChild);
		return Math.max(left,right)+1;
	}
	
	public TreeNode<Integer> pruneBST(TreeNode<Integer> root,int a,int b){
		if(root==null) {
			return null;
		}
		if(root.data>b) {
			root = pruneBST(root.leftChild,a,b);
		}
		else if(root.data<a) {
			root = pruneBST(root.rightChild,a,b);
		}
		else if(root.data>=a&&root.data<=b) {
			root.leftChild = pruneBST(root.leftChild,a,b);
			root.rightChild = pruneBST(root.rightChild,a,b);
		}
		return root;
	}
	
	public void linkLevelNodes(TreeNode<Integer> root) {
		TreeNode<Integer> start = root;
		TreeNode<Integer> temp = root;
		TreeNode<Integer> baseRef = null;
		TreeNode<Integer> rightRef = null;
		while(start!=null) {
			while(temp!=null) {
				if(temp.leftChild!=null) {
					if(baseRef==null) {
						baseRef =temp.leftChild;
						rightRef = temp.leftChild;
					}else {
						rightRef.next=temp.leftChild;
						rightRef=rightRef.next;
					}
				}
				if(temp.rightChild!=null) {
					if(baseRef==null) {
						baseRef = temp.rightChild;
						rightRef = root.rightChild;
					}
					else {
						rightRef.next = temp.rightChild;
						rightRef=rightRef.next;
					}
				}
				temp = temp.next;
			}
			start=baseRef;
			temp = baseRef;
			baseRef=null;
			rightRef=null;
		}
	}
	
	
}
