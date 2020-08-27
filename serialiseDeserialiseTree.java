/*
 *
	Given the root to a binary tree, implement serialize(root),
which serializes the tree into a string, and deserialize(s),
which deserializes the string back into the tree.
 */

//AUTHOR : Nisarg Devdhar
import java.util.Scanner;

public class serialiseDeserialiseTree {

	public static class Node{
		int data;
		Node left,right;

		Node(int value){
			this.data=value;
			left=null;
			right=null;
		}
	}

	//static int count=0;
	public static Node root;
	public static String result="";

	public static Node insert(int[] arr) {
		return insert(arr,0,arr.length-1);
	}

	public static Node insert(int[] arr, int start, int end) {
		//count++;
		// TODO Auto-generated method stub
		if(end<start)
			return null;

		int mid=(start+end)/2;
		Node n=new Node(arr[mid]);
		n.left=insert(arr,start,mid-1);
		n.right=insert(arr,mid+1,end);

		return n;
	}

	public static void printList(Node n) {
		if(n==null)
			return;
		printList(n.left);
		printList(n.right);
		System.out.print(n.data+" ");
	}


	public static String serialise(Node n) {
		if(n==null)
			return null;

		//result+="{";
		result+=n.data+" ";
		serialise(n.left);
		serialise(n.right);

		return result;
	}



	public static void main(String[] args) {
		serialiseTree st=new serialiseTree();
		Scanner sc=new Scanner(System.in);
		System.out.println();
		String s=sc.next();
		String[] temp=s.split(",");
		int[] arr=new int[temp.length];

		for(int i=0;i<arr.length;i++)
			arr[i]=Integer.parseInt(temp[i]);


		sc.close();

		root=insert(arr);
		String result1=" ";

		result1=serialise(root);
		System.out.println("Serialise: "+result1);

		deserialise(result1);
	}

	private static void deserialise(String result2) {
		// TODO Auto-generated method stub
		String s=result2;
		String[] temp=s.split(" ");
		int[] arr=new int[temp.length];

		for(int i=0;i<arr.length;i++)
			arr[i]=Integer.parseInt(temp[i]);

		serialiseTree st=new serialiseTree();
		root=insert(arr);
		System.out.println("Deserialise:");
		printList(root);

	}

}
