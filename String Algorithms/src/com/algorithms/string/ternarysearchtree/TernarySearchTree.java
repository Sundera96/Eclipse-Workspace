package com.algorithms.string.ternarysearchtree;

public class TernarySearchTree {
	
	private TernaryNode root;

	public class TernaryNode{
		final char data;
		int position;
		TernaryNode left;
		TernaryNode right;
		TernaryNode middle;
		public TernaryNode(char data) {
			// TODO Auto-generated constructor stub
			this.data=data;
			this.position=-1;
		}
	}
	
	
	
	/**
	 * @param word
	 * @param position
	 * 
	 * List of words to be passed 
	 * she 0
	 * sells 1
	 * sea 2
	 * shells 3
	 */
	public void insert(String word,int position) {
		TernaryNode currNode = root;
		TernaryNode prevNode = null;
		int indexOfWord=0;
		while(indexOfWord<word.length()) {
			if(currNode==null) {
				currNode = new TernaryNode(word.charAt(indexOfWord++));
				if(root==null)
					root = currNode;
				if(prevNode!=null) {
					if(prevNode.middle==null||prevNode.data==currNode.data) {
						prevNode.middle=currNode;
					}else if(currNode.data<prevNode.data) {
						prevNode.left=currNode;
					}else {
						prevNode.right=currNode;
					}
				}
				prevNode=currNode;
				currNode = currNode.middle;
			}else {
				prevNode = currNode;
				if(word.charAt(indexOfWord)==currNode.data) {
					currNode = currNode.middle;
					indexOfWord++;
				}else if(word.charAt(indexOfWord)<currNode.data) {
					currNode = currNode.left;
				}else {
					currNode = currNode.right;
				}
			}
		}
		prevNode.position = position;
	}
	
	
	public void delete(String word) {
		deleteTST(word,root,0);
	}
	
	private TernaryNode deleteTST(String word, TernaryNode root, int indexOfWord) {
		if(root==null||indexOfWord==word.length()) {
			return root;
		}
		if(root!=null) {
			TernaryNode next;
			if(word.charAt(indexOfWord)==root.data) {
				next = deleteTST(word,root.middle,indexOfWord+1);
			}else if(word.charAt(indexOfWord)<root.data) {
				next = deleteTST(word,root.left,indexOfWord);
			}else {
				next = deleteTST(word,root.right,indexOfWord);
			}
			if(word.length()-1==indexOfWord) {
				root.position=-1;
			}
			if(next==null) {
				root.middle=null;
				if(root.left==null&&root.right==null&&root.position==-1) {
					root = null;
				}
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		TernarySearchTree tstRunner = new TernarySearchTree();
		tstRunner.insert("she",1);
		tstRunner.insert("sells",2);
		tstRunner.insert("sea",3);
		tstRunner.insert("shells",4);
		tstRunner.delete("shells");
		tstRunner.insert("sundera",5);
	}
}
