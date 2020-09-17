/*
Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

Design a binary tree node class with the following methods:

  is_locked, which returns whether the node is locked
  lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
  unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.
You may augment the node to add parent pointers or any other property you would like. 
You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes. 
Each method should run in O(h), where h is the height of the tree.
 */

// Author:Nisarg Devdhar
import java.util.Scanner;

public class lockedBinaryTree {
	static class Node{
		int data;
		Node right,left;
		boolean lock;
		public Node(int data) {
			this.data=data;
			right=null;
			left=null;
			lock=false;
		}
	}
	
	
	public static boolean is_locked(Node node, int val){// Pass the root and the value of the node to be verified
		while(node.data!=val && node!=null) {
			if(val>node.data)
				node=node.right;
			else
				node=node.left;
		}
		
		if(node==null) {
			System.out.println("Value not present");
			System.exit(0);
		}
		
		if(node.lock==true)
			return true;
		return false;
		
	}
	
	public static boolean lock(int val,Node node) {// pass the root and the value to be locked
		while(node.data!=val && node!=null) {
			if(node.data<val)
				node=node.right;
			else
				node=node.left;
		}
		
		if(node==null) {
			System.out.println("Node does not exist");
			return false;
		}
		else {
			boolean var=check(node);
			if(var) {
				node.lock=true;
				return true;
			}
			
			return false;
		}
	}

	private static boolean check(Node node) {
		// TODO Auto-generated method stub
		if(node==null)
			return true;
		if(node.lock==false)
			return false;
		check(node.right);
		check(node.left);
		return true;
	}
	
	public static boolean unlock(int val,Node node) {// pass the root and the value to be unlocked
		while(node.data!=val && node!=null) {
			if(node.data<val)
				node=node.right;
			else
				node=node.left;
		}
		
		if(node==null) {
			System.out.println("Node does not exist");
			return false;
		}
		else {
			if(node.lock==true) {
				node.lock=false;
				return true;
			}
			return false;
	
		
		}
	}
	

	public static Node add(int num[],int start,int end) {
		if(start>end)
			return null;
		
		int mid=(start+end)/2;
		Node n=new Node(num[mid]);
		n.left=add(num,0,mid-1);
		n.right=add(num,mid+1,end);
		return n;
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter elements of an array");
		String s=sc.next();
		String[] st=s.split(",");
		int[] arr=new int[st.length];
		for(int i=0;i<st.length;i++) {
			arr[i]=Integer.parseInt(st[i]);
		}
		int a=0; // Node to be locked
		Node root=add(arr,0,arr.length-1);
		boolean lock=lock(a,root);
		boolean is_lock=is_locked(root,a);
		boolean unlock=unlock(a,root);
		
		sc.close();
	}
}
