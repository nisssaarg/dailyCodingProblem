/*
Given the head to a binary search tree, find the second largest node in the tree.
 */
public class secondMinValue {
	public static class Node{
		int val;
		Node left;
		Node right;
		
		public Node(int n) {
			val=n;
			left=right=null;
		}
	}
	
	public static void main(String[] args) {
		Node head=new Node(2);
		head.right=new Node(3);
		head.right.right=new Node(7);
		head.right.left=new Node(5);
		head.left= new Node(2);
		
		System.out.println(findSecondMaxValue(head));
	}

	static int min1;
	static int ans=Integer.MAX_VALUE;
	
	public  static int findSecondMaxValue(Node head) {
		// TODO Auto-generated method stub
		min1=head.val;
		//System.out.println(min1);
		dfs(head);
		return ans<Integer.MAX_VALUE ? ans:-1;
	}

	public static void dfs(Node head) {
		// TODO Auto-generated method stub
		if (head != null) {
            if (min1 < head.val && head.val < ans) {
                ans = head.val;
                //System.out.println(ans);
            } else if (min1 == head.val) {
                dfs(head.left);
                dfs(head.right);
            }
        }
	}
}
