package Treesandgrapgh;

public class BSTPractise {
	
	static class BSTNode{
		BSTNode left,right;
		int data;
		
	public BSTNode(int n){
		left = null;
		right = null;
		data = n;
	}
	
	//set data
	public void setdata(int n){
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
	
	public boolean isempty(BSTNode node){
		return node == null;
	}
	}
	//insert
	public void insert(BSTNode root, BSTNode n){
		if(root == null || n == null) return;
		if(n.getdata() < root.getdata()){
			if(root.getleft() == null){
				root.setleft(n);
				System.out.println("Added " + n.getdata() + "  to the left of " + root.getdata());
			}else{
				insert(root.left, n);
			}
		}else if(n.getdata() > root.getdata()){
				if(root.getright() == null){
					root.setright(n);
					System.out.println("Added " + n.getdata() + "  to the right of " + root.getdata());
				}else{
					insert(root.getright(),n);
				}
			}
		
	}
	//countnodes
	public int countnodes(BSTNode node){
		if(node == null) return 0;
		else{
			int l = 1;
			l = l + countnodes(node.left);
			l = l + countnodes(node.right);
			return l;
		}
		
	}	
	//search
		public boolean search(BSTNode root, int val){
			if(root == null)
				return false;
			else{
				if(val < root.getdata()){
					return search(root.getleft(), val);
				}else if(val > root.getdata()){
					return search(root.getright(), val);
				}else if(val == root.getdata()){
					return true;
				}
			}
			return true;
		}
		
		
		//delete
		public BSTNode delete(BSTNode node, int val){
			if(node == null)
				System.out.println("The tree is empty ");
			if(search(node,val) == true){
			if(val < node.getdata()){
				node.left = delete(node.getleft(), val);
			}else if(val > node.getdata()){
				node.right = delete(node.getright(),val);
			}else if(node.right == null){
				return node.left;
			}else if(node.left == null){
				return node.right;
			}else {
				//get data from rightmost node to left subtree
				node.data = retrievenode(node.left);
				//delete rightmost data in left subtree
				node.left = delete(node.left, node.data);
			}
			}
			else
				System.out.println("The value : " + val + " is not present ");
				
			
			return node;
		}
		
		
		public int retrievenode(BSTNode node){
			while(node.right != null)
				node = node.right;
				return node.data;
			
		}
		
		
		public void run(){
			BSTNode root = new BSTNode(10);
			insert(root, new BSTNode(6));
			insert(root, new BSTNode(11));
			insert(root, new BSTNode(12));
			insert(root, new BSTNode(7));
			insert(root, new BSTNode(1));
			System.out.println();
			System.out.println("Inorder : " );
			inorder(root);
			System.out.println();
			System.out.println(countnodes(root));
			System.out.println();
			delete(root, 10);
			System.out.println("Inorder : ");
			inorder(root);
			System.out.println();
			System.out.println(search(root,10));
			delete(root, 10);
			System.out.println("Inorder : ");
			inorder(root);
			
		}
				
		//inorder
		public BSTNode inorder(BSTNode node){
			if(node != null){
				inorder(node.getleft());
				System.out.print(" " + node.getdata());
				inorder(node.getright());
			}return node;
		}
	
	
	
	
	public static void main(String[] args) {
			BSTPractise bstp = new BSTPractise();
			bstp.run();

	}

	
}

	
