package Treesandgrapgh;

public class diameterofatree {
	Node root;
//Compute the Diameter of a given Binary Tree. 
	//time complexity to O(n)
//	Diameter of a tree is the largest path between any two leaf nodes in the tree.
//	http://stackoverflow.com/questions/11897088/diameter-of-binary-tree-better-design
	//http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
	/*
	The diameter of a tree T is the largest of the following quantities:

		* the diameter of T’s left subtree
		* the diameter of T’s right subtree
		* the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)*/
public class Height{
	int h;
}

public int diameter(){
	Height height = new Height();
	return diameterOpt(root,height);
}

public int diameterOpt(Node root, Height height){
	Height lh = new Height();
	Height rh = new Height();
	if(root == null){
		height.h = 0;
		return 0;
	}

	int ldiameter = diameterOpt(root.left, lh);
	int rdiameter = diameterOpt(root.right,rh);
	
	/* calculate root diameter */
    int rootDiameter = lh.h + rh.h + 1;
	
	/* calculate height of current node */
	height.h = Math.max(lh.h, rh.h) + 1;	
	 /* calculate the diameter */
	return Math.max(rootDiameter , Math.max(ldiameter,rdiameter));   
}

public int height(Node root){
		if(root == null) return 0;
		return 1 + Math.max(height(root.left), height(root.right));
}

public static void main(String[] args) {
		diameterofatree tree = new diameterofatree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println("The diameter of given binary tree is : "
						+ tree.diameter());
}

}
