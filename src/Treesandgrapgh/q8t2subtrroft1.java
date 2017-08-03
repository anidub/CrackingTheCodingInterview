package Treesandgrapgh;

public class q8t2subtrroft1 {

	
public boolean containstree(BSTNode t1, BSTNode t2){
	if(t2 == null)
		return true;
	return subtree(t1,t2);
}
		
public static boolean subtree(BSTNode t1, BSTNode t2){
	if(t1 == null)
		return false;
	if(t1.data == t2.data)
		if(matchtree(t1,t2)) return true;
	return subtree((t1.left,t2) || (t1.right, t2));
}
		
public static boolean matchtree(BSTNode t1, BSTNode t2){
	if(t1 == null && t2 == null)
		return true;
	if(t1 == null && t2  != null)
		return false;
	if(t1.data != t2.data)
		return false;
	return matchtree((t1.left, t2.left) && (t1.right, t2.right));
}
	public static void main(String[] args) {
	
	}

}
