package com.solution.linkedlist;

public class SolutionLinkedList<T> {
	public static void main(String[] args) {
		LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(3);
		LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(2);
		LinkedListNode<Integer> node4 = new LinkedListNode<Integer>(4);
		LinkedListNode<Integer> node5 = new LinkedListNode<Integer>(6);
		LinkedListNode<Integer> node6 = new LinkedListNode<Integer>(5);
		LinkedListNode<Integer> node7 = new LinkedListNode<Integer>(4);
//		LinkedListNode<Integer> node7 = new LinkedListNode<Integer>(3);
//		LinkedListNode<Integer> node8 = new LinkedListNode<Integer>(7);
//		LinkedListNode<Integer> node9 = new LinkedListNode<Integer>(9);
//		LinkedListNode<Integer> node10 = new LinkedListNode<Integer>(10);
//		LinkedListNode<Integer> node11 = new LinkedListNode<Integer>(11);
//		LinkedListNode<Integer> node12 = new LinkedListNode<Integer>(12);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
//		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
//		node8.next=node9;
//		node9.next=node10;
//		node10.next=node11;
//		node11.next=node1;
		//node12.next=node1;
		SolutionLinkedList<Integer> runner = new SolutionLinkedList<Integer>();
		runner.quickSortLinkedList(node1, node7,null);
		//runner.quickSortLinkedList(node1,node6);
		runner.printLinkedList(node1);
		//runner.startOfLoopFinder(node1);
		//runner.printLinkedList(runner.reverseLinkedList(node1));
//		runner.reverseLinkedListRecursion(node1);
//		runner.printLinkedList(startNode);
//		runner.printLinkedList(runner.ReversePairIterative(node1));
//		runner.splitCircularLL(node1);
//		runner.printLinkedList(runner.textBook(node1,3));
//		runner.problem54(node1);
		//runner.printLinkedList(runner.problem58(node1, node4));
		//runner.printLastNNodes(node1,2);
		
//		LinkedListNode<Integer> head = runner.mergeSortLinkedList(node1);
//		runner.printLinkedList(head);
//		int[] array1 = new int[7];
//		int[] array2 = new int[4];
//		array1[0]=1;
//		array1[1]=5;
//		array1[2]=10;
//		//array1[3]=50;
//		array2[0]=2;
//		array2[1]=7;
//		array2[2]=10;
//		array2[3]=10;
//		runner.merge(array1, array2);
//		for(int val: array1)
//			System.out.println(val);
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
			//startNode=head;
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
	
	
	public LinkedListNode<Integer> mergeSortLinkedList(LinkedListNode<Integer> head){
		if(head!=null&&head.next!=null) {
			LinkedListNode<Integer> midNode = splitLL(head);
			LinkedListNode<Integer> nextNode = midNode.next;
			midNode.next=null;
			return mergeSortLL(mergeSortLinkedList(head),mergeSortLinkedList(nextNode));
		}
		return head;
	}


	private LinkedListNode<Integer> mergeSortLL(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> prevNode=null;
		while(head1!=null&&head2!=null) {
			if(head1.data<head2.data) {
				if(head==null)
					head = head1;
				prevNode = head1;
				head1=head1.next;
			}else {
				if(head==null) {
					head = head2;
				}
				LinkedListNode<Integer> temp = head2;
				head2=head2.next;
				if(prevNode!=null) {
					prevNode.next = temp;
				}
				temp.next=head1;
				prevNode = temp;
			}
		}
		
		if(head2!=null) {
			prevNode.next = head2;
		}
		return head;
	}


	private LinkedListNode<Integer> splitLL(LinkedListNode<Integer> head) {
		if(head==null)
			return head;
		LinkedListNode<Integer> slowPtr = head;
		LinkedListNode<Integer> fastPtr = head;
		if(fastPtr.next!=null&&fastPtr.next.next!=null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		return slowPtr;
	}
	
	public void merge(int[] A,int[] B) {
		int indexAEnd = A.length-1;
		int indexAMid = A.length-B.length-1;
		int indexBEnd = B.length-1;
		while(indexBEnd>=0) {
			if(B[indexBEnd]>A[indexAMid]) {
				A[indexAEnd--]=B[indexBEnd--];
			}else {
				A[indexAEnd--]=A[indexAMid--];
			}
		}
	}
	
	public void quickSortLinkedList(LinkedListNode<Integer> head,LinkedListNode<Integer> tail,LinkedListNode<Integer>prevHead) {
		if(head!=null&&tail!=null&&head!=tail) {
			LinkedListNode<Integer> prevPartition = quickSortLL(head,tail,prevHead);
			quickSortLinkedList(head,prevPartition,null);
			if(prevPartition!=null&&prevPartition.next!=null&&prevPartition.next!=tail) {
				quickSortLinkedList(prevPartition.next.next,tail,prevPartition.next);
			}
		}
	}
	
	private LinkedListNode<Integer> quickSortLL(LinkedListNode<Integer> head,LinkedListNode<Integer> tail,LinkedListNode<Integer> prevHead) {
		LinkedListNode<Integer> swapRegion = head;
		LinkedListNode<Integer> prevNode = null;
		LinkedListNode<Integer> pivotNode = head;
		while(head!=tail.next) {
			if(head.data<pivotNode.data&&head!=pivotNode) {
				prevNode=swapRegion;
				swapRegion=swapRegion.next;
				swapData(swapRegion,head);
			}
			head=head.next;
		}
		swapData(swapRegion,pivotNode);
		return prevNode!=null?prevNode:prevHead;
	}


	private void swapData(LinkedListNode<Integer> pivot, LinkedListNode<Integer> tail) {
		int temp = pivot.data;
		pivot.data=tail.data;
		tail.data = temp;
	}
}

