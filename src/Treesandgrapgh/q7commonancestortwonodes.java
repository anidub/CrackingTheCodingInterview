package Treesandgrapgh;

public class q7commonancestortwonodes {

		public class result{
			BSTNode tree;
			boolean isancestor;
			
			public result(BSTNode n, boolean isanc){
				isancestor = isanc;
				tree = n;
			}
			
			public class result commonancestorhelp(BSTNode root, BSTNode p, BSTNode q){
				if(root == null)
					return new result(null,false);
				if(root == p || root == q)
					return new result(root,true);
				result rx = new commonancestorhelp(root.right, p,q);
					if(rx.isancestor){ //found common ancestor
						return rx.node;
					}
					result ry = new commonancestorhelp(root.left, p,q);
						if(ry.inancestor){
							return ry.node;
						}
						
					if(rx.node != null && ry.node != null){
						return new result(root,true);//found common ancestor
					}else if(p != null || q != null){
						boolean isancestor = rx.node!= null || ry.node != null ? true : false;
						return new result(root,isancestor);
 					}else{
 						return new result(rx.node != null ? true : rx.node,false);
 					}
					
			}
			
			
			
			
		}
	
	
	public static void main(String[] args) {


	}

}
