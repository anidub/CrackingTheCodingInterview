package Treesandgrapgh;

public class q5checkifbst {
	
	
	public boolean checkBST(BSTNode n){
		return checkbst(n,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean checkbst(BSTNode root, int min, int max){
		if(root == null)
			return true;
		if(root.data <= min || root.data >= max)
			return false;
		if(!checkbst(root.left, min, root.data) || !(checkbst(root.right,root.data,max))){
			return false;
		}
		return true;
	}
	
	public class Solution {
	    public boolean isValidBST(TreeNode root) {
	        if(root == null)
	            return true;
	 
	        LinkedList<BNode> queue = new LinkedList<BNode>();
	        queue.add(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
	        while(!queue.isEmpty()){
	            BNode b = queue.poll();
	            if(b.n.val <= b.left || b.n.val >=b.right){
	                return false;
	            }
	            if(b.n.left!=null){
	                queue.offer(new BNode(b.n.left, b.left, b.n.val));
	            }
	            if(b.n.right!=null){
	                queue.offer(new BNode(b.n.right, b.n.val, b.right));
	            }
	        }
	        return true;
	    }
	}
	
	//define a BNode class with TreeNode and it's boundaries
	class BNode{
	    TreeNode n;
	    double left;
	    double right;
	    public BNode(TreeNode n, double left, double right){
	        this.n = n;
	        this.left = left;
	        this.right = right;
	    }
	public static void main(String[] args) {

	}
}