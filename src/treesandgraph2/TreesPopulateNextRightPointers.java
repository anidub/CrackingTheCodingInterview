package treesandgraph2;

import java.util.LinkedList;
import java.util.Queue;
/*https://www.interviewbit.com/problems/populate-next-right-pointers-tree/
Populate each next pointer to point to its next right node. If there is no next right node, 
the next pointer should be set to NULL.
Note 1: that using recursion has memory overhead and does not qualify for constant space.*/
public class TreesPopulateNextRightPointers {
	private class TreeLinkNode {
		     int val;
		     TreeLinkNode left, right, next;
		     public TreeLinkNode(int x) { 
		    	 val = x; 
		    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}	
	  public void connectLevelOrder(TreeLinkNode root) {	        
	        Queue<TreeLinkNode> queue1 = new LinkedList<>();
	        Queue<TreeLinkNode> queue2 = new LinkedList<>();	        
	        if (root == null) return;	            
	        queue1.add(root);
	        TreeLinkNode node, prev = null;	        
	        while (!queue1.isEmpty() || !queue2.isEmpty()) {	            
	            prev = null;
	            while (!queue1.isEmpty()) {
	                node = queue1.remove();	                
	                
	                if (prev != null)
	                	prev.next = node;	
	                
	                prev = node;	      
	                
	                if (node.left != null)
	                    queue2.add(node.left);       
	                if (node.right != null)
	                    queue2.add(node.right);	                
	            }	            
	            prev = null;
	            while (!queue2.isEmpty()) {
	                node = queue2.remove();
	                    
	                if (prev != null)
	                    prev.next = node;
	                
	                prev = node;
	                
	                if (node.left != null)
	                    queue1.add(node.left);
	                if (node.right != null)
	                    queue1.add(node.right);
	            }	            
	        }	        
	    }
	  
	  //http://www.geeksforgeeks.org/connect-nodes-at-same-level/
	  public void connectRecursive(TreeLinkNode root){
			if(root == null) return;
			
			if(root.left != null)
				root.left.next = root.right;
			
			if(root.right != null){
				root.right.next = root.next != null ? root.next.left : null;
			}
			
			connectRec(root.left);
			connectRec(root.right);
		}
	  
//  http://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/	  
	  public TreeLinkNode getNextRight(TreeLinkNode root){
	        TreeLinkNode temp = root.next;	  
	   /* Traverse nodes at p's level and find and return the first node's first child */
	        while (temp != null) {
	            if (temp.left != null)
	                return temp.left;
	            if (temp.right != null)
	                return temp.right;
	            temp = temp.next;
	        }	  
	        // If all the nodes at p's level are leaf nodes then return NULL
	        return null;
	    }
		
			  //http://www.geeksforgeeks.org/connect-nodes-at-same-level/
	  public void connectRecursive(TreeLinkNode root){
			if(root == null) return;
			
			if(root.left != null)
				root.left.next = root.right;
			
			if(root.right != null){
				root.right.next = root.next != null ? root.next.left : null;
			}
			
			connectRec(root.left);
			connectRec(root.right);
		}
	    
	   public void connect(TreeLinkNode root) {
	        if (root == null) return;	  
	        // Set nextRight for root
	        root.next = null;	  
	        // set nextRight of all levels one by one
	        while (root != null){
	            TreeLinkNode temp = root;
	            
	  /* Connect all childrem nodes of root and children nodes of all other nodes at same level as root */
	            while (temp != null){
	                // Set the nextRight pointer for p's left child
	                if (temp.left != null){	                  
/*If q has right child, then right child is nextRight of root and we also need to set nextRight of right child*/
	                	if (temp.right != null)
	                		temp.left.next = temp.right;
	                    else
	                    	temp.left.next = getNextRight(temp);
	                }	  
	                if (temp.right != null)
	                	temp.right.next = getNextRight(temp);	  
	                // Set nextRight for other nodes in pre order fashion
	                temp = temp.next;
	            }	  
	            // start from the first node of next level
	            if (root.left != null)
	            	root = root.left;
	            else if (root.right != null)
	            	root = root.right;
	            else
	            	root = getNextRight(root);
	        }	        
	    }
 /*The complexity of above algorithm mainly based on getNextRight().
	 The time complexity of getNextRight() is O(p), 
	 which p is average elements in each level, p = O(log(n)).
	 (Worse in a complete binary tree, best in a single-pathed tree)
	   Which say, in best case, we call zero time of getNextRight().
	   Which each node visited once. So it's O(n)
	   (Case like a complete binary tree, a kind of no-sibling-gap tree)
	   But o.w. if there're k nodes need to call getNextRight().
	   The whole time complexity is O(k*log(n)).
	   Since k <= n, so worse case is O(n*log(n)). (Upper bound)
	   But worse case only happen in single-pathed tree.
	   Also the average case is O(n*log(n)).
	   It's fast enough, previous post provided a O(n) way but need O(n) extra space.	   
*/}

