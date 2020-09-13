/*
 * Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

Y ShapedLinked List
Above diagram shows an example with two linked list having 15 as intersection point.

Example 1:

Input:
LinkList1 = {10,20,5,10}
LinkList2 = {30,40,50,5,10}
Output: 5
Explanation:The point of intersection of
two linked list is 5, means both of them
get linked (intersects) with each other
at node whose value is 5.
Your Task:
The task is to complete the function intersetPoint() which finds the point of intersection of two linked list. The function should return data value of a node where two linked lists merge. If linked list do not merge at any point, then it should return -1.

Challenge : Try to solve the problem without using any extra space.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 100
1 <= value <= 1000


Author: Nisarg Devdhar 
 */
import java.util.HashSet;
import java.util.Set;

public class listIntersect {
	
	public static Set<Node> set=new HashSet<Node>();
	
	public static class Node{
		int data;
		Node next;
		public Node(int n) {
			data=n;
			next=null;
		}
	}
	
	static Node head=null;
	
	public void insert(int n) {
		Node temp=new Node(n);
		if(head==null)
			head=temp;
		else {
			Node t=head;
			while(t.next!=null){
				t=t.next;
			}
			t.next=temp;
		}
	}
	
	public void print() {
		if(head==null)
			throw new NullPointerException("Empty list");
		else {
			Node t=head;
			while(t!=null) {
				System.out.println(t.data);
				t=t.next;
			}
		}
	}
	
	public Node getNode(int n) {
		Node t=head;
		while(t!=null) {
			if(t.data==n)
				return t;
			t=t.next;
		}
		return null;
	}
	
	public static Node checkMerger(listIntersect l1,listIntersect l2) {
		Node t=l1.head;
		while(t!=null) {
			set.add(t);
			t=t.next;
		}
		
		t=l2.head;
		Node temp=null;
		while(t!=null) {
			if(set.contains(t))
				temp=t;
			t=t.next;
		}
		
		return temp;
	}
	
	
	
	public static void main(String[] args) {
		listIntersect l1=new listIntersect();
		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		//l1.print();
		
		listIntersect l2=new listIntersect();
		l2.insert(1);
		l2.insert(2);
		l2.insert(4);
		//l2.print();
		
		Node n = l1.getNode(2);
		l2.head.next.next=n;// mimicking a duplicate entry
		n=checkMerger(l1,l2);
		while(n!=null) {
			l1=addAtTail(l1,n);
			n=n.next;
		}
		
		l1.print();
	}

	private static listIntersect addAtTail(listIntersect l1,Node n) {
		// TODO Auto-generated method stub
		Node t=l1.head;
		
		while(t!=null)
			t=t.next;
		t.next=n;
		
		return l1;
	}
}

