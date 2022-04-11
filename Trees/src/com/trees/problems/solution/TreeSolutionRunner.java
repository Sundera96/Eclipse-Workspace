package com.trees.problems.solution;



public class TreeSolutionRunner {

	public static void main(String[] args) {
		TreeNode<Integer> node1 = new TreeNode<Integer>(1);
		TreeNode<Integer> node2 = new TreeNode<Integer>(2);
		TreeNode<Integer> node3 = new TreeNode<Integer>(3);
		TreeNode<Integer> node4 = new TreeNode<Integer>(4);
		TreeNode<Integer> node5 = new TreeNode<Integer>(5);
		TreeNode<Integer> node6 = new TreeNode<Integer>(6);
		TreeNode<Integer> node7 = new TreeNode<Integer>(7);
//		TreeNode<Integer> node8 = new TreeNode<Integer>(6);
//		TreeNode<Integer> node9 = new TreeNode<Integer>(7);

		
		
		
		TreeNode<Integer> node1a = new TreeNode<Integer>(1);
		TreeNode<Integer> node2a = new TreeNode<Integer>(2);
		TreeNode<Integer> node3a = new TreeNode<Integer>(3);
		TreeNode<Integer> node4a = new TreeNode<Integer>(4);
		TreeNode<Integer> node5a = new TreeNode<Integer>(5);
		TreeNode<Integer> node6a = new TreeNode<Integer>(6);
		TreeNode<Integer> node7a = new TreeNode<Integer>(7);
		TreeNode<Integer> node8a = new TreeNode<Integer>(6);
		TreeNode<Integer> node9a = new TreeNode<Integer>(7);
		
		node1.leftChild=node2;
		node1.rightChild=node3;
		node2.leftChild=node4;
		node2.rightChild=node5;
		node3.leftChild=node6;
		node3.rightChild=node7;
//		node5.leftChild=node8;
//		node5.rightChild=node9;
		
//		node9.leftChild = node1a;
//		node9.rightChild = node2a;
		
		node1a.rightChild=node2a;
		node1a.leftChild=node3a;
		node2a.rightChild=node4a;
		node2a.leftChild=node5a;
		node3a.rightChild=node6a;
		node3a.leftChild=node7a;
		node7a.rightChild=node8a;
//		node5a.rightChild=node8a;
//		node5a.leftChild=node9a;
		
		TreeSolutions solutionRunner = new TreeSolutions();
		Traversal<Integer> traversalRunner = new Traversal<Integer>();
		//TreeNode<Integer> root = solutionRunner.insertInBinaryTreeLevelOrder(node1,10);
		
		//solutionRunner.insertBinaryTreeRecursive(node1,100);
		//System.out.println(solutionRunner.maxInBinaryTree(node1));
		//System.out.println(solutionRunner.maxInBinaryTree02(node1));
		//System.out.println(solutionRunner.findNodeInBinaryTree(node1,6));
		//System.out.println(solutionRunner.findNodeInBinaryTreeNonRecursive(node1,11));
		//System.out.println(solutionRunner.treeSizeRecursive(node1));
		//System.out.println(solutionRunner.treeSizeNonRecursive(node1));
		//System.out.println(solutionRunner.heightOfBinaryTree(node1));
		//System.out.println(solutionRunner.maxDepthOfBinaryTreeNonRecursive(node1));
		//System.out.println(solutionRunner.maxDepthOfTreeLevelOrderReversal(node1));
		//System.out.println(solutionRunner.minDepth(node1));
		//System.out.println(solutionRunner.numberOfLeavesInTreeUsingLevelOrderTraversal(node1));
		//System.out.println(solutionRunner.numberOfFullNodesInTreeLevelOrder(node1));
		//System.out.println(solutionRunner.checkStructurallySameTree(node1, node1a));
		//System.out.println(solutionRunner.widthOfBinaryTree(node1));
		//solutionRunner.printPaths(node1);
		//System.out.println(solutionRunner.hasPathSum(node1,100));
		//traversalRunner.levelOrderTraversal(solutionRunner.mirrorOfBinaryTree(node1));
		//System.out.println(solutionRunner.areMirrors(node1,node1a));
//		String[] preOrder = {"A","B","D","E","C","F","G"};
//		String[] InOrder = {"D","B","E","A","F","C","G"};
//		String[] postOrder = {"D","E","B","F","G","C","A"};
//		String[] InOrder = {"D","B","E","A","F","C","G"};
//		traversalRunner.preOrderTraversal(solutionRunner.buildBinaryTreeInAndPostOrdder(postOrder, InOrder));
		//solutionRunner.printAllAncestors(node1, 6);
		//System.out.println(solutionRunner.leastCommmonAncestor(node1, node4, node5).data);
//		for(int val:solutionRunner.zigzagLevelOrderTraversal(node1)) {
//			System.out.println(val);
//		}
		
		
		for(TreeNode<Integer> val:solutionRunner.generateTrees(5)) {
			traversalRunner.inOrderTraversal(val);
			System.out.println("------------------");
		}
	}
}
