package com.trees.problems.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeSolutions {

	// find maximum element in binary tree
	public int maxInBinaryTree(TreeNode<Integer> root) {
		int maxVal = 0;
		if(root==null) {
			return 0;
		}
		int value1 =maxInBinaryTree(root.leftChild);
		int value2 =maxInBinaryTree(root.rightChild);
		if(value1<value2) {
			maxVal = value2;
		}else {
			maxVal = value1;
		}
		if(root.data>maxVal) {
			maxVal = root.data;
		}
		return maxVal;
	}
	// find maximum element in binary tree - 
	public int maxInBinaryTree02(TreeNode<Integer> root) {
		TreeNode<Integer> currNode;
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.push(root);
		int maxVal = 0;
		while(!stack.isEmpty()) {
			currNode = stack.pop();
			if(currNode.data>maxVal)
				maxVal = currNode.data;
			if(currNode.leftChild!=null) {
				stack.push(currNode.leftChild);
			}
			if(currNode.rightChild!=null) {
				stack.push(currNode.rightChild);
			}
		}
		return maxVal;
	}
	
	public boolean findNodeInBinaryTree(TreeNode<Integer> root,int data) {
		if(root==null) {
			return false;
		}
		boolean leftChild = findNodeInBinaryTree(root.leftChild,data);
		boolean rightChild = findNodeInBinaryTree(root.rightChild,data);
		if(root.data==data) {
			return true;
		}
		return leftChild||rightChild;
	}
	
	public boolean findNodeInBinaryTreeNonRecursive(TreeNode<Integer> root,int data) {
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode<Integer> currNode = stack.pop();
			if(currNode.data==data) {
				return true;
			}
			if(currNode.rightChild!=null) {
				stack.push(currNode.rightChild);
			}
			if(currNode.leftChild!=null) {
				stack.push(currNode.leftChild);
			}
		}
		return false;
	}
	
	public TreeNode<Integer> insertInBinaryTreeLevelOrder(TreeNode<Integer> root,int data){
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode<Integer> currNode = queue.poll();
			if(currNode.leftChild!=null) {
				queue.add(currNode.leftChild);
			}
			if(currNode.rightChild!=null) {
				queue.add(currNode.rightChild);
			}
			if(currNode.leftChild==null) {
				currNode.leftChild = new TreeNode<Integer>(data);
				return root;
			}
			if(currNode.rightChild==null) {
				currNode.rightChild = new TreeNode<Integer>(data);
				return root;
			}
		}
		return root;
	}
	
	public TreeNode<Integer> insertBinaryTreeRecursive(TreeNode<Integer> root,int data){
		if(root.leftChild==null) {
			root.leftChild=  new TreeNode<Integer>(data);
			return root.leftChild;
		}
		else if(root.rightChild==null) {
			root.rightChild=  new TreeNode<Integer>(data);
			return root.rightChild;
		}
		
		if(root.leftChild.data>data) {
			insertBinaryTreeRecursive(root.leftChild,data);
		}else{
			insertBinaryTreeRecursive(root.rightChild,data);
		}
		return root;
	}
	
	public int treeSizeRecursive(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int leftChild =treeSizeRecursive(root.leftChild);
		int rightChild=treeSizeRecursive(root.rightChild);
		return leftChild+rightChild+1;
	}
	
	public int treeSizeNonRecursive(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		int size=0;
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode<Integer> currNode = queue.poll();
			size++;
			if(currNode.leftChild!=null) {
				queue.add(currNode.leftChild);
			}
			if(currNode.rightChild!=null) {
				queue.add(currNode.rightChild);
			}
		}
		return size;
	}
	
	public int heightOfBinaryTree(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int leftHeight=heightOfBinaryTree(root.leftChild);
		int rightHeight=heightOfBinaryTree(root.rightChild);
		if(leftHeight>rightHeight) {
			return leftHeight+1;
		}else {
			return rightHeight+1;
		}
	}
	
	public int maxDepthOfBinaryTreeNonRecursive(TreeNode<Integer> root) {
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.push(root);
		int height=1;
		int maxHeight=0;
		TreeNode<Integer> prevNode=null;
		while(!stack.isEmpty()) {
			TreeNode<Integer> currNode = stack.peek();
			if(prevNode==null||prevNode.leftChild==currNode||prevNode.rightChild==currNode) {
				if(currNode.leftChild!=null) {
					stack.push(currNode.leftChild);
					height++;
				}
				else if(currNode.rightChild!=null) {
					stack.push(currNode.rightChild);
					height++;
				}
				
			}
			else if(currNode.leftChild==prevNode) {
				stack.push(currNode.rightChild);
				height++;
			}
			else {
				if(stack.pop()!=null){
					height--;
				}
			}
			prevNode=currNode;
			if(height>maxHeight)
				maxHeight=height;
		}
		return maxHeight;
	}
	
	public int maxDepthOfTreeLevelOrderReversal(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		queue.add(root);
		queue.add(null);
		int height=1;
		while(!queue.isEmpty()) {
			TreeNode<Integer> currNode = queue.poll();
			if(currNode!=null) {
				if(currNode.leftChild!=null) {
					queue.add(currNode.leftChild);
				}
				if(currNode.rightChild!=null) {
					queue.add(currNode.rightChild);
				}
			}else {
				if(!queue.isEmpty()) {
					queue.add(null);
					height++;
				}
			}
		}
		return height;
	}
	
	public int minDepth(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		queue.add(root);
		queue.add(null);
		int height=1;
		while(!queue.isEmpty()) {
			TreeNode<Integer> currNode = queue.poll();
			if(currNode!=null) {
				if(currNode.leftChild==null&&currNode.rightChild==null) {
					return height;
				}
				if(currNode.leftChild!=null) {
					queue.add(currNode.leftChild);
				}
				if(currNode.rightChild!=null) {
					queue.add(currNode.rightChild);
				}
			}else {
				if(!queue.isEmpty()) {
					queue.add(null);
					height++;
				}
			}
		}
		return -1;
	}
	
//	public int deletingAnElement(TreeNode<Integer> root, int data) {
//		
//	}
	public int numberOfLeavesInTreeUsingLevelOrderTraversal(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		int count=0;
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode<Integer> currNode = queue.poll();
			if(currNode.leftChild==null&currNode.rightChild==null) {
				count++;
			}
			if(currNode.leftChild!=null) {
				queue.add(currNode.leftChild);
			}
			if(currNode.rightChild!=null) {
				queue.add(currNode.rightChild);
			}
		}
		return count;
	}
	
	public int numberOfFullNodesInTreeLevelOrder(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		int count=0;
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode<Integer> currNode = queue.poll();
			if(currNode.leftChild!=null&currNode.rightChild!=null) {
				count++;
			}
			if(currNode.leftChild!=null) {
				queue.add(currNode.leftChild);
			}
			if(currNode.rightChild!=null) {
				queue.add(currNode.rightChild);
			}
		}
		return count;
	}
	
	public boolean checkStructurallySameTree(TreeNode<Integer> root1,TreeNode<Integer> root2) {
		if(root1==null&&root2==null) 
			return true;
		if(root1==null|root2==null)
			return false;
		boolean isLeftStructured=checkStructurallySameTree(root1.leftChild,root2.leftChild);
		boolean isRightStructured=checkStructurallySameTree(root1.rightChild,root2.rightChild);
		return isLeftStructured&&isRightStructured;
	}
	
	public int maxHeightOfTree(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int leftHeight = maxHeightOfTree(root.leftChild);
		int rightHeight = maxHeightOfTree(root.rightChild);
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	public int widthOfBinaryTree(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		int maxWidth=1;
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			TreeNode<Integer> currNode = queue.poll();
			if(currNode!=null) {
				if(currNode.leftChild!=null) {
					queue.add(currNode.leftChild);
				if(currNode.rightChild!=null)
					queue.add(currNode.rightChild);
			}
			}else if(!queue.isEmpty()) {
				if(queue.size()>maxWidth)
					maxWidth=queue.size();
				queue.add(null);
			}
		}
		return maxWidth;
	}
	
	public void printPaths(TreeNode<Integer> root) {
		int[] pathIndex = new int[256];
		printPaths(root,pathIndex,0);
	}
	private void printPaths(TreeNode<Integer> root, int[] pathIndex, int pathLength) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		pathIndex[pathLength++] = root.data;
		if(root.leftChild==null||root.rightChild==null) {
			printArrayIndex(pathIndex,pathLength);
		}
		printPaths(root.leftChild,pathIndex,pathLength);
		printPaths(root.rightChild,pathIndex,pathLength);
	}
	private void printArrayIndex(int[] pathIndex,int len) {
		for(int index=0;index<=len;index++) {
			System.out.println(pathIndex[index]);
		}
		System.out.println();
	}
	
	public boolean hasPathSum(TreeNode<Integer> root, int sum) {
		if(sum==0) {
			return true;
		}
		if(root==null) {
			return false;
		}
		sum=sum-root.data;
		boolean left = hasPathSum(root.leftChild,sum);
		boolean right = hasPathSum(root.rightChild,sum);
		return left||right;
	}
	
	public TreeNode<Integer> mirrorOfBinaryTree(TreeNode<Integer> root) {
		if(root.leftChild==null||root.rightChild==null) {
			return root;
		}
		TreeNode<Integer> temp = root.rightChild;
		root.rightChild = mirrorOfBinaryTree(root.leftChild);
		root.leftChild = mirrorOfBinaryTree(temp);
		return root;
	}
	
	public boolean areMirrors(TreeNode<Integer> root1,TreeNode<Integer> root2) {
		if(root1==null&root2==null) {
			return true;
		}
		else if(root1==null||root2==null) {
			return false;
		}
		else {
			boolean isMirrorLeft =areMirrors(root1.leftChild,root2.rightChild);
			boolean isMirrorRight = areMirrors(root1.rightChild,root2.leftChild);
			return isMirrorLeft&&isMirrorRight&&root1.data==root2.data;
		}
	}
	
	public TreeNode<String> buildBinaryTree(String[] preOrderList,String[] inOrderList){
		if(inOrderList==null||preOrderList==null) {
			return null;
		}
		return buildBinaryTreeInandPreOrder(preOrderList,0,preOrderList.length-1,inOrderList,0,inOrderList.length-1);
	}
	private TreeNode<String> buildBinaryTreeInandPreOrder(String[] preOrderList, int startPreOrder, int endPreOrder, String[] inOrderList, int startInOrder, int endInOrder) {
		// TODO Auto-generated method stub
		if(startPreOrder>endPreOrder||startInOrder>endInOrder) {
			return null;
		}
		String data = preOrderList[startPreOrder];
		TreeNode<String> currNode = new TreeNode<String>(data);
		int offSet = startInOrder;
		for(;offSet<endInOrder;offSet++) {
			if(inOrderList[offSet]==data) {
				break;
			}
		}
		currNode.leftChild = buildBinaryTreeInandPreOrder(preOrderList,startPreOrder+1,startPreOrder+offSet-startInOrder,inOrderList,startInOrder,offSet-1);
		currNode.rightChild = buildBinaryTreeInandPreOrder(preOrderList,startPreOrder+offSet-startInOrder+1,endPreOrder,inOrderList,offSet+1,endInOrder);
		return currNode;
	}
	
	public TreeNode<String> buildBinaryTreeInAndPostOrdder(String[] postOrderList,String[] inOrderList){
		if(postOrderList==null||inOrderList==null) {
			return null;
		}
		return buildBinaryTreeInAndPostOrder(postOrderList,0,postOrderList.length-1,inOrderList,0,inOrderList.length-1);
	}
	private TreeNode<String> buildBinaryTreeInAndPostOrder(String[] postOrderList, int startOfPostOrder, int endOfPostOrder, String[] inOrderList, int startOfInOrder,
			int endOfInOrder) {
		// TODO Auto-generated method stub
		if(startOfPostOrder>endOfPostOrder||startOfInOrder>endOfInOrder) {
			return null;
		}
		String data = postOrderList[endOfPostOrder];
		TreeNode<String> currNode = new TreeNode<String>(data);
		int offSet = startOfInOrder;
		for(;offSet<endOfInOrder;offSet++) {
			if(inOrderList[offSet]==data) {
				break;
			}
		}
		currNode.leftChild = buildBinaryTreeInAndPostOrder(postOrderList,startOfPostOrder,startOfPostOrder+offSet-startOfInOrder-1,inOrderList,startOfInOrder,offSet-1);
		currNode.rightChild = buildBinaryTreeInAndPostOrder(postOrderList,startOfPostOrder+offSet-startOfInOrder,endOfPostOrder-1,inOrderList,offSet+1,endOfInOrder);
		return currNode;
	}
	
	public void printAllAncestors(TreeNode<Integer> root,int data) {
		int[] dataPath = new int[256];
		printAllAncestors(root,dataPath,0,data);
	}
	private void printAllAncestors(TreeNode<Integer> root, int[] dataPath,int index,int data) {
		if(root==null)
			return;
		dataPath[index] = root.data;
		printAllAncestors(root.leftChild,dataPath,index+1,data);
		printAllAncestors(root.rightChild,dataPath,index+1,data);
		if(dataPath[index]==data) {
			printArrayIndex(dataPath,index);
		}
	}
	
	public TreeNode<Integer> leastCommmonAncestor(TreeNode<Integer> root, TreeNode<Integer> nodeA,TreeNode<Integer> nodeB){
		if(root==null) {
			return null;
		}
		if(root==nodeA||root==nodeB) {
			return root;
		}
		TreeNode<Integer> nodeLeft = leastCommmonAncestor(root.leftChild,nodeA,nodeB);
		TreeNode<Integer> nodeRight = leastCommmonAncestor(root.rightChild,nodeA,nodeB);
		if(nodeLeft!=null&&nodeRight!=null)
			return root;
		else if(nodeLeft!=null||nodeRight!=null) {
			return nodeLeft!=null ? nodeLeft:nodeRight;
		}
		return null;
	}
	
	public ArrayList<Integer> zigzagLevelOrderTraversal(TreeNode<Integer> root){
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		ArrayList<Integer> elements = new ArrayList<Integer>();
		queue.add(root);
		queue.add(null);
		boolean reverse = false;
		while(!queue.isEmpty()) {
			TreeNode<Integer> currNode = queue.poll();
			
			if(currNode!=null) {
				if(!reverse) {
					elements.add(currNode.data);
				}
				if(currNode.leftChild!=null)
					queue.add(currNode.leftChild);
				if(currNode.rightChild!=null)
					queue.add(currNode.rightChild);
			}
			else {
				if(!queue.isEmpty()) {
					reverse = !reverse;
					if(reverse) {
						Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
						Queue<TreeNode<Integer>> queueTemp = new LinkedList<TreeNode<Integer>>();
						while(!queue.isEmpty()) {
							TreeNode<Integer> tempNode=queue.poll();
							queueTemp.add(tempNode);
							stack.push(tempNode);
						}
						while(!stack.isEmpty()) {
							elements.add(stack.pop().data);
						}
						queue = queueTemp;
					}
					queue.add(null);
				}
			}
		}
		return elements;
	}
	
	public ArrayList<TreeNode<Integer>> generateTrees(int n){
		if(n==0) {
			return generateTrees(1,0);
		}
		return generateTrees(1,n);
	}
	private ArrayList<TreeNode<Integer>> generateTrees(int start, int end) {
		ArrayList<TreeNode<Integer>> subTrees = new ArrayList<TreeNode<Integer>>();
		if(start>end) {
			subTrees.add(null);
			return subTrees;
		}
		for(int index= start;index<end;index++) {
			for(TreeNode<Integer> left: generateTrees(start,index-1)) {
				for(TreeNode<Integer> right: generateTrees(index+1,end)) {
					TreeNode<Integer> tree = new TreeNode<Integer>(index);
					tree.leftChild=left;
					tree.rightChild=right;
					subTrees.add(tree);
				}
			}
		}
		return subTrees;
	}
	
	public boolean quasiIsomorphic(TreeNode<Integer> root1,TreeNode<Integer> root2) {
		if(root1==null&&root2==null)
			return true;
		else if(root1==null||root2==null) {
			return false;
		}
		
		boolean check1 = quasiIsomorphic(root1.leftChild,root2.leftChild);
		boolean check2 = quasiIsomorphic(root1.rightChild,root2.rightChild);
		boolean check3 = quasiIsomorphic(root1.leftChild,root2.rightChild);
		boolean check4 = quasiIsomorphic(root1.rightChild,root2.leftChild);
		return check1&&check2||check3&&check4;
	}
}










