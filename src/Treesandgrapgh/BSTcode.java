package Treesandgrapgh;


public class BSTcode {
	public enum State{
		  Visited, Unvisited,Visiting;
		   
		 }
	
	static class BSTNode{
		BSTNode right,left;
		int data;
		
	public BSTNode(int n){
		left = null;
		right = null;
		data = n;
				
	}
	
	//set data
	public void setdata(int n ){
		data = n;
	}
	
	//set right
	public void setright(BSTNode n){
		right = n;
	}
	
	//set left
	public void setleft(BSTNode n){
		left = n;
	}
	
	//getdata
	public int getdata(){
		return data;
	}
	
	//getleft
	public BSTNode getleft(){
		return left;
	}
	
	//get right
	 public BSTNode getright(){
		 return right;
	 }
		
		}
	
	
	public boolean isempty(BSTNode n){
		return n == null;
	}
	
	
	public void insert(BSTNode root, BSTNode n){
		if(root == null || n == null)
			return;
		
			if(n.getdata() < root.getdata()){
				if(root.getleft() == null){
					root.setleft(n);
					System.out.println("Added " + n.getdata() + "  to the left of " + root.getdata());
				}else{
					insert(root.getleft(), n);
				}
			}else if(n.getdata() > root.getdata()){
				if(root.getright() == null){
					root.setright(n);
					System.out.println("Added " + n.getdata() + " to the right of " + root.getdata());
				}else{
					insert(root.getright(), n);
			}
	}	
	}

	
	public boolean search(BSTNode root, BSTNode n){
		if(root == null || n == null) {
            return false;
        }
		System.out.println();
		
        if(root.getdata() > n.getdata()){
           return  search(root.getleft(),n);
        }else if(root.getdata() < n.getdata()){
           return  search(root.getright(),n);
        }
        return true;
  	}
	
	
	
	
	public int countnodes(BSTNode node){
		if(node == null){
			return 0;
		}else{
			int l = 1;
			l = l + countnodes(node.getleft());
			l = l + countnodes(node.getright());
			return l;
		}
	}
	
	
	public BSTNode delete(BSTNode node, int n){
		if(node == null){
			System.out.println("The node is empty");
		}else if (n < node.getdata()){
			node.left = delete(node.getleft(), n);
		}else if(n > node.getdata()){
			node.right = delete(node.getright(),n);
		}else if(node.right == null){
			return node.left;
		}else if (node.left == null){
			return node.right;
		}else {
			//get data from rightmost node to left subtree
			node.data = retrievedata(node.left);
			//delete rightmost data in left subtree
			node.left = delete(node.left,node.data);
			
		}
		return node;
		
	}
	
	public int retrievedata(BSTNode node){
		while(node.right != null)
			node = node.right;
			return node.data;
	}
	
	//inorder
	
	public void inorder(BSTNode node){
			if(node != null){
				inorder(node.getleft());
				System.out.print(node.getdata() + " ");
				inorder(node.getright());
			}
		}
		
	
//		preorder	
	public BSTNode preorder(BSTNode node){
			if(node != null){
				System.out.print(node.getdata() + " ");
				preorder(node.getleft());
				preorder(node.getright());
			}	return node;
		}
		
	
		//post order
		public BSTNode postorder(BSTNode node){
			if(node != null){
				postorder(node.getleft());
				postorder(node.getright());
				System.out.print(node.getdata() + " ");
			}return node;
		}
	
	
		 public void run(){
		        BSTNode root = new BSTNode(10);
		        insert(root,new BSTNode(20));
		        insert(root,new BSTNode(5));
		        insert(root,new BSTNode(4));
		       // insert(root,new BSTNode(3));
		        insert(root,new BSTNode(15));
		         
		       System.out.println("Inorder : "); 
		       inorder(root);
		       System.out.println();
		       System.out.println("Preorder : ");
		       preorder(root);
		       System.out.println();
		       System.out.println(" Post order : ");
		       postorder(root);
		       System.out.println("\n" + " Checking if 240 exists in tree : " + search(root,new BSTNode(240)));
		       System.out.println(countnodes(root));
		       
		       delete(root,20);
		       System.out.println("Inorder : "); 
		       inorder(root);
		       System.out.println();
		       System.out.println("Preorder : ");
		       preorder(root);
		       System.out.println();
		       System.out.println(" Post order : ");
		       postorder(root);
		       
		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTcode bst = new BSTcode();
		bst.run();
	}

}
