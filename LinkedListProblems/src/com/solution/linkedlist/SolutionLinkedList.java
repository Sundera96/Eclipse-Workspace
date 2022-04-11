package com.solution.linkedlist;


public class SolutionLinkedList<T> {
	private static LinkedListNode<?> startNode; 
	public static void main(String[] args) {
		LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(3);
		LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(4);
		LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(3);
		LinkedListNode<Integer> node4 = new LinkedListNode<Integer>(5);
		LinkedListNode<Integer> node5 = new LinkedListNode<Integer>(6);
		LinkedListNode<Integer> node6 = new LinkedListNode<Integer>(4);
		LinkedListNode<Integer> node7 = new LinkedListNode<Integer>(9);
		LinkedListNode<Integer> node8 = new LinkedListNode<Integer>(8);
		LinkedListNode<Integer> node9 = new LinkedListNode<Integer>(9);
		LinkedListNode<Integer> node10 = new LinkedListNode<Integer>(10);
		LinkedListNode<Integer> node11 = new LinkedListNode<Integer>(11);
//		LinkedListNode<Integer> node12 = new LinkedListNode<Integer>(12);
		node1.next=node2;
		node2.next=node3;
		node3.next=node7;
//		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node8;
//		node6.next=node7;
//		node7.next=node8;
//		node8.next=node9;
//		node9.next=node10;
//		node10.next=node11;
//		node11.next=node1;
		//node12.next=node1;
		SolutionLinkedList<Integer> runner = new SolutionLinkedList<Integer>();
		//runner.startOfLoopFinder(node1);
		//runner.printLinkedList(runner.reverseLinkedList(node1));
//		runner.reverseLinkedListRecursion(node1);
//		runner.printLinkedList(startNode);
//		runner.printLinkedList(runner.ReversePairIterative(node1));
//		runner.splitCircularLL(node1);
//		runner.printLinkedList(runner.textBook(node1,3));
//		runner.problem54(node1);
		//runner.printLinkedList(runner.problem58(node1, node4));
		runner.printLastNNodes(node1,2);
	}
	
	
	public void startOfLoopFinder(LinkedListNode<T> head) {
		LinkedListNode<T> fastPtr = head.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next;
		LinkedListNode<T> slowPtr = head.next.next;
		while(fastPtr!=slowPtr&&fastPtr!=null) {
			fastPtr = fastPtr.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next;
			slowPtr = slowPtr.next.next;
		}
		slowPtr=head;
		if(fastPtr!=null) {
			while(fastPtr!=slowPtr) {
				fastPtr = fastPtr.next;
				slowPtr = slowPtr.next;
			}
			System.out.println(fastPtr.data);
		}
		
	}
	
	public LinkedListNode<T> reverseLinkedList(LinkedListNode<T> head) {
		LinkedListNode<T> currNode = head;
		LinkedListNode<T> prev = null;
		while(currNode!=null) {
			LinkedListNode<T> nextNode = currNode.next;
			currNode.next=prev;
			prev=currNode;
			currNode=nextNode;
		}
		return prev;
	}
	
	public LinkedListNode<T> reverseLinkedListRecursion(LinkedListNode<T> head){
		if(head.next==null) {
			startNode=head;
			return head;
		}
			
		LinkedListNode<T> nextNode=reverseLinkedListRecursion(head.next);
		nextNode.next=head;
		head.next=null;
		return head;
	}
	
	public void printLinkedList(LinkedListNode<?> startNode2) {
		while(startNode2!=null) {
			System.out.println(startNode2.data);
			startNode2 = startNode2.next;
		}
	}
	
	public LinkedListNode<T> ReversePairIterative(LinkedListNode<T> head) {
		if(head==null||head.next==null) {
			return head;
		}
		LinkedListNode<T> temp= head.next;
		head.next = ReversePairIterative(head.next.next);
		temp.next=head;
		return temp;
	}
	
	public void  splitCircularLL(LinkedListNode<T> head) {
		LinkedListNode<T> slowPtr=head;
		LinkedListNode<T> fastPtr=head;
		while(fastPtr.next!=head&&fastPtr.next.next!=head) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		if(fastPtr.next==head) {
			fastPtr.next=slowPtr.next;
		}else if(fastPtr.next.next==head) {
			fastPtr.next.next=slowPtr.next;
		}
		fastPtr=slowPtr.next;
		slowPtr.next=head;
		printCircularLinkedList(head);
	}


	public void printCircularLinkedList(LinkedListNode<T> head) {
		LinkedListNode<T> currNode=head;
		while(currNode.next!=head) {
			System.out.println(currNode.data);
			currNode = currNode.next;
		}
		System.out.println(currNode.data);
	}
	
	public LinkedListNode<T> reversingKNode(LinkedListNode<T> head,int k) {
		int counter = 0;
		LinkedListNode<T> currNode=head;
		LinkedListNode<T> prevNode=head;
		while(currNode!=null&&counter<k) {
			currNode = currNode.next;
			counter++;
		}
		if(counter==k) {
			currNode=head;
			while(counter>0) {
				LinkedListNode<T> nextNode=currNode.next;
				currNode.next=prevNode;
				prevNode=currNode;
				currNode=nextNode;
				counter--;
			}
			head.next=reversingKNode(currNode,k);
		}
		return prevNode;
	}
	
	public LinkedListNode<T> textBook(LinkedListNode<T> head,int k){
		LinkedListNode<T> current = head;
		LinkedListNode<T> next = null;
		LinkedListNode<T> prev = null;
		int count = k;
		while(current!=null&&count>0) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			count--;
		}
		if(next!=null) {
			head.next=textBook(next,k);
		}
		return prev;
	}
	
	public void problem54(LinkedListNode<T> head){
		LinkedListNode<T> slowPtr = head;
		LinkedListNode<T> fastPtr = head;
		LinkedListNode<T> tempNode = head;
		while(fastPtr.next!=null&&fastPtr.next.next!=null) {
			fastPtr = fastPtr.next.next;
			slowPtr=slowPtr.next;
		}
		fastPtr= slowPtr.next;
		slowPtr.next=null;
		slowPtr=head;
		fastPtr=reverseLinkedList(fastPtr);
		while(slowPtr!=null&&fastPtr!=null) {
			tempNode=fastPtr.next;
			fastPtr.next=slowPtr.next;
			slowPtr.next=fastPtr;
			slowPtr=fastPtr.next;
			fastPtr=tempNode;
		}
		printLinkedList(head);
	}
	
	public LinkedListNode<Integer> problem58(LinkedListNode<Integer> digit1,LinkedListNode<Integer> digit2){
		LinkedListNode<Integer> head=null;
		LinkedListNode<Integer> curr=null;
		int reminder=0;
		while(digit1!=null||digit2!=null) {
			int addition=0;
			if(digit1!=null) {
				addition = addition+digit1.data;
				digit1=digit1.next;
			}
			if(digit2!=null) {
				addition = addition+digit2.data;
				digit2=digit2.next;
			}
			if(reminder!=0) {
				addition=addition+reminder;
			}
			if(head==null) {
				head = new LinkedListNode(addition%10);
				curr=head;
			}else {
				curr.next = new LinkedListNode(addition%10);
				curr=curr.next;
			}
			reminder=addition/10;
		}
		if(reminder!=0)
			curr.next=new LinkedListNode(reminder);
		return head;
	}
	
	
	public int printLastNNodes(LinkedListNode<Integer> node, int count) {
		if(node==null) {
			return 0;
		}
		int index = printLastNNodes(node.next,count);
		if(index==count)
			return index;
		System.out.println(node.data);
		return index+1;
	}
}
