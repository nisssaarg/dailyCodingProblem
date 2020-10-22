/*
 * Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.
 * For example, given the following preorder traversal:
 * [a,b, d, e, c, f, g]
 * fnd the following inorder traversal:
 * [d, b, e, a, f, c, g]
 * You should return the following tree:

    a
   / \
  b   c
 / \ / \
d  e f  g

 */
public class treeConstructor {

	public static class Node{
		char data;
		Node right;
		Node left;
		Node (char data){
			this.data=data;
			right=left=null;
		}
	}
	
	Node root;
	static int preIndex=0;
	
	Node buildTree(char in[],char pre[], int inStrt,int inEnd) {
		if(inStrt>inEnd) {
			return null;
		}
		
		Node tNode = new Node(pre[preIndex++]); 
		
		if(inStrt == inEnd ) {
			return tNode;
		}
		
		int inIndex = search(in, inStrt, inEnd, tNode.data);
		
		tNode.left = buildTree(in, pre, inStrt, inIndex - 1); 
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd); 
  
        return tNode; 

	}

	private int search(char[] arr, int strt, int end, char data) {
		// TODO Auto-generated method stub
        int i; 
        for (i = strt; i <end; i++) { 
            if (arr[i] == data) 
                return i; 
        } 
        return i; 
	}
	
    void printInorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.left); 
  
        /* then print the data of node */
        System.out.print(node.data + " "); 
  
        /* now recur on right child */
        printInorder(node.right); 
    } 
    
    public static void main(String... args) {
    	char[] pre= {'a','b', 'd', 'e', 'c', 'f', 'g'};
    	char[] in= {'d', 'b', 'e', 'a', 'f', 'c', 'g'};
    	
    	treeConstructor tree = new treeConstructor();
    	int length=in.length;
    	
    	Node root=tree.buildTree(in, pre, 0,length-1);
    	
    	tree.printInorder(root);
    	
    }
}
