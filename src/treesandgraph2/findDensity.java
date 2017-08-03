package treesandgraph2;

public class findDensity {	
	int size = 0;	
	
	public float denisty(Node root){
		int height = heightandsize(root);
		return height/size;
	}
	
	public int heightandsize(Node root){
		if(root == null) return 0;
		int l = heightandsize(root.left);
		int r = heightandsize(root.right);
		size++;
		return l > r ? l+1:r+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
