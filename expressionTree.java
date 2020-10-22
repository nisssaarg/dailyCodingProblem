
/*
 * Suppose an arithmetic expression is given as a binary tree. 
 * Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.
 * Given the root to such a tree, write a function to evaluate it.
 * For example, given the following tree:

    *
   / \
  +    +
 / \  / \
3  2  4  5

 *You should return 45, as it is (3 + 2) * (4 + 5).
 */

import java.util.Stack;

public class expressionTree {
	
	public static class Node{
		char value;
		Node left, right;
		
		Node(char item) {
			value = item;
			left = right = null;
		}
	}
	
	 boolean isOperator(char c) {
	        if (c == '+' || c == '-'
	                || c == '*' || c == '/'
	                || c == '^') {
	            return true;
	        }
	        return false;
	    }
	 
	 void inorder(Node t) {
	        if (t != null) {
	            inorder(t.left);
	            System.out.print(t.value + " ");
	            inorder(t.right);
	        }
	    }
	 
	 Node constructTree(char postfix[]) {
	        Stack<Node> st = new Stack<Node>();
	        Node t, t1, t2;

	        for (int i = 0; i < postfix.length; i++) {
	 
	            if (!isOperator(postfix[i])) {
	                t = new Node(postfix[i]);
	                st.push(t);
	            } 
	            else{
	                t = new Node(postfix[i]);
	 
	                t1 = st.pop();      
	                t2 = st.pop();

	                t.right = t1;
	                t.left = t2;

	                st.push(t);
	            }
	        }
	 
	        t = st.peek();
	        st.pop();
	 
	        return t;
	    }
	 
	 public static void main(String args[]) {
		 
	        expressionTree et = new expressionTree();
	        String postfix = "ab+ef*g*-";
	        char[] charArray = postfix.toCharArray();
	        Node root = et.constructTree(charArray);
	        System.out.println("infix expression is");
	        et.inorder(root);
	 
	    }
	 
}
