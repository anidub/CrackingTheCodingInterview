package Treesandgrapgh;
/*http://www.geeksforgeeks.org/populate-inorder-successor-for-all-nodes/
Traverse the given tree in reverse inorder traversal and keep track of previously visited node.
When a node is being visited, assign previously visited node as next.
O(n)*/
public class populateInorderSuccesorAllNodes {
private static class Node{
	int data;
	Node left,right, next;
	private Node(int data){
		this.data = data;
		left=right=next = null;
	}
}

static Node next = null;
public static void populateInorderSucc(Node root){
	 // The first visited node will be the rightmost node next of the rightmost node will be NULL	
	if(root != null){
		// First set the next pointer in right subtree
		populateInorderSucc(root.right);
		
		// Set the next as previously visited node in reverse Inorder
		root.next = next;
		
		 // Change the prev for subsequent node
		next = root;

        // Finally, set the next pointer in left subtree
		populateInorderSucc(root.left);
	}
}
	public static void main(String[] args) {
		Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);
  
        // Populates nextRight pointer in all nodes
        populateInorderSucc(root);
  
        // Let us see the populated values
        Node ptr = root.left.left;
        while (ptr != null){
            // -1 is printed if there is no successor
            int print = ptr.next != null ? ptr.next.data : -1;
            System.out.println("Next of " + ptr.data + " is: " + print);
            ptr = ptr.next;
        }
	}
}
