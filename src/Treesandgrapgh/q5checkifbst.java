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
	
	

	public static void main(String[] args) {

	}

}
