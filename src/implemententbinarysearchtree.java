import java.util.Scanner;

public class implemententbinarysearchtree {

	class BSTNode{
		
		BSTNode left, right;
		int data;
		
		public BSTNode(){
			left = null;
			right = null;
			data = 0;
	
		}
		public BSTNode(int d){
			left = null;
			right = null;
			data = d;
		}
		
		//set data
		public void setdata(int d){
			data = d;
		}
		//set right
		
		public void setright(BSTNode n){
			right = n;
		}
		
		//set left
		public void setleft(BSTNode n){
			left = n;
		}
		//get data
		public int getdata(){
			return data;
		}
		
		//get left
		public BSTNode getleft(){
			return left;
		}
		
		//get right
		public BSTNode getright(){
			return right;
		}
		
	}

	class BST{
		private BSTNode root;
	
		
		//check if empty
		public boolean isempty(){
			return root == null;
		}
		
	//insert data
	
	private  void insert(BSTNode node, BSTNode n){
		if(node == null || n == null)
			return;
		if(n.getdata() < node.getdata()){
			if(node.getleft() == null){
				node.setleft(n);
				System.out.println("Added to the left of " + node.getdata() + " the value of " + n.getdata());
			}else{
				insert(node.getleft(), n);
			}
		}
		else if(n.getdata() > node.getdata()){
			if(node.getright() == null){
				node.setright(n);
				System.out.println("Added to the right of " + node.getdata() + " the value of " +n.getdata());
			}else{
				insert(node.getright(), n);
			}
		}
	}
	
	//countnodes
		public void countnodes(){
			countnodes(root);
		}
		
		private int countnodes(BSTNode node){
			if(node == null){
				return 0;
			}else{
				int l = 1;
				l = l + countnodes(node.getleft());
				l = l + countnodes(node.getright());
				return l;
			}
		}
		
		//search
		public boolean search(int val){
			return search(root,val);
		}
		
		private boolean search(BSTNode node, int val){
			boolean found = false;
			while(node != null && !found){
				int nodevalue = node.getdata();
				if(val < nodevalue){
					node = node.getleft();
				}else if ( val > nodevalue){
					node = node.getright();
				}else{
					found = true;
					break;
			}
				found  = search(node,val);
			}
			return found;
		}
		
		//delete
		public void deletenode(int n){
			deletenode(root,n);
		}
		
		private BSTNode deletenode(BSTNode node, int n){
			if(node == null){
				System.out.println( "The BST is empty ");
			}else if( n > node.getdata()){
				node.right = deletenode(node.right, n); 
			}else if( n < node.getdata()){
				node.left = deletenode(node.left, n);
			}else{
				if( node.right == null){
				return node.left;
			}else if(node.left == null){
				return node.right;
			}else{
				//get data from rightmost node to left subtree
				node.data = retrievenode(node.left);
			    //delete rightmost data in left subtree
				node.left = deletenode(node.left,node.data);
			}
			}
			return node;
		}
		
		public int retrievenode(BSTNode node){
			while(node.right != null)
				node = node.right;
				return node.data;
		}
	
	
	
	//inorder
	public void inorder(){
		inorder(root);
	}
	private BSTNode inorder(BSTNode node){
		while(node != null){
			inorder(node.getleft());
			System.out.println(node.getdata() + " ");
			inorder(node.getright());
		}return node;
	}
	
//	preorder
	public void preorder(){
		preorder(root);
	}
	
	private BSTNode preorder(BSTNode node){
		while(node != null){
			System.out.println(node.getdata() + " ");
			preorder(node.getleft());
			preorder(node.getright());
		}	return node;
	}
	
	//post order
	public void postorder(){
		postorder(root);
	}
	
	private BSTNode postorder(BSTNode node){
		while(node != null){
			postorder(node.getleft());
			postorder(node.getright());
			System.out.println(node.getdata() + " ");
		}return node;
	}
	

	
	}			
	public static void main(String[] args) {
		BST bst = new BST();
		Scanner scan = new Scanner(System.in);
		BSTNode root = new BSTNode(5);
        bst.insert(root,new BSTNode(4));
        bst.insert(root,new BSTNode(6));
	}
	

}
