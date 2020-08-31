/*
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * Given the root to a binary tree, count the number of unival subtrees.
 * For example, the following tree has 5 unival subtrees:
   0
  / \
 1   0
    / \
   1   0
  / \
 1   1
 */
public class univalTree {
	static class Node{
		int data;
		Node right;
		Node left;
		public Node(int data) {
			this.data=data;
			right=left=null;
		}
	}
	
	static class Count{
		int count=0;
	}
	
	Node root;
	Count ct=new Count();
	
	public boolean countSubTree(Node n,Count c) {
		if(n==null)
			return true;
		
		boolean left=countSubTree(n.left,c);
		boolean right=countSubTree(n.right,c);
		
		if(left==false || right==false)
			return false;
		
		if(n.left!=null && n.data!=n.left.data)
			return false;
		
		if(n.right!=null && n.data!=n.right.data)
			return false;
		
		c.count++;
		return true;
		
	}
	
	int countSub(Node n) {
		countSubTree(n,ct);
		return ct.count;
	}
	
	public static void main(String[] args) {
		univalTree uv=new univalTree();
		uv.root=new Node(0);
		uv.root.left=new Node(1);
		uv.root.right=new Node(0);
		uv.root.right.left=new Node(1);
		uv.root.right.left.left=new Node(1);
		uv.root.right.left.right=new Node(1);
		uv.root.right.right=new Node(0);
		
		System.out.println(uv.countSub(uv.root));
	}
}
