package com.list.skip.impl;

import java.util.Random;

public class SkipListImpl<T extends Comparable<T>,U> {

	public class SkipListNode{
		private T key;
		private U value;
		private long level;
		private SkipListNode next;
		private SkipListNode down;
		public SkipListNode(T key, U value, long level, SkipListImpl<T, U>.SkipListNode next,
				SkipListImpl<T, U>.SkipListNode down) {
			this.key = key;
			this.value = value;
			this.level = level;
			this.next = next;
			this.down = down;
		}		
	}
	
	private SkipListNode head;
	private Random rand;
	private long size;
	private double probability;
	
	private long levelOfSkipList() {
		long level=0;
		while(level<=size&&rand.nextDouble()>probability) {
			level++;
		}
		return level;
	}
	
	public SkipListImpl() {
		rand = new Random();
		head=new SkipListNode(null,null,-1,null,null);
		size=0;
		probability=0.5;
	}
	
	public void add(T key, U value) {
		long level = levelOfSkipList();
		while(level>head.level) {
			if(head.level==-1)
				head = new SkipListNode(null,null,head.level+1,null,null);
			else
				head = new SkipListNode(null,null,head.level+1,null,head);
		}
		SkipListNode currNode = head;
		SkipListNode topNode = null;
		while(currNode!=null) {
			if(currNode.next==null||currNode.next.key.compareTo(key)>0) {
				if(level>=currNode.level) {
					SkipListNode newNode = new SkipListNode(key,value,currNode.level,currNode.next,null);
					if(topNode!=null) {
						topNode.down=newNode;
					}
					currNode.next=newNode;
					topNode = newNode;
				}
				currNode = currNode.down;
				continue;
			}
			else if(currNode.next.key.compareTo(key)==0) {
				return;
			}
			currNode=currNode.next;
		}
		size++;
	}
	
	public void printSkipList() {
		SkipListNode currNode = head;
		while(currNode!=null&&currNode.down!=null) {
			currNode = currNode.down;
		}
		currNode=currNode.next;
		while(currNode!=null) {
			printValueDownward(getTopNode(currNode.key));
			currNode = currNode.next;
		}
	}
	
	public U remove(T key) {
		SkipListNode currNode = head;
		U value=null;
		while(currNode!=null) {
			if(currNode.next!=null&&currNode.next.key.compareTo(key)<0) {
				currNode=currNode.next;
				continue;
			}
			else if(currNode.next!=null&&currNode.next.key.compareTo(key)==0) {
				value=currNode.next.value;
				currNode.next.down=null;
				currNode.next=currNode.next.next;
			}
			currNode=currNode.down;
		}
		size--;
		return value;
	}
	
	private SkipListNode getTopNode(T key) {
		// TODO Auto-generated method stub
		SkipListNode currNode = head;
		while(currNode!=null) {
			if(currNode.next!=null&&currNode.next.key.compareTo(key)<0) {
				currNode=currNode.next;
				continue;
			}else if(currNode.next!=null&&currNode.next.key.compareTo(key)==0) {
				return currNode.next;
			}
			else {
				currNode=currNode.down;
			}
		}
		return null;
	}

	private void printValueDownward(SkipListNode nodeToPrint) {
		while(nodeToPrint!=null) {
			System.out.print(nodeToPrint.value+" ");
			nodeToPrint = nodeToPrint.down;
		}
		System.out.println();
	}
}
