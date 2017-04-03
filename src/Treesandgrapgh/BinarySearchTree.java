package Treesandgrapgh;

import java.util.Scanner;


class BSTNode{
	BSTNode left,right;
	int data;
	
	public BSTNode(){
		left = null;
		right = null;
		data = 0;
	}
	
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
	public void setright(BSTNode node){
		right = node;
	}

	//set left  
	public void setleft(BSTNode node){
		left = node;
	}
	
	//get data
	public int getdata(){
		return data;
	}

	public BSTNode getleft(){
		return left;
	}
	
	public BSTNode getright(){
		return right;
	}
	
}

	class BST{
		private BSTNode root;
		
		public BST(){
			root = null;
		}
		
		//check empty
		public boolean isempty(){
			return root == null; 
		}
		
		//insert
		public void insert(int data){
				root = insert(root,data);
		}
		
		private BSTNode insert(BSTNode n, int data){
			if(n == null){
				n  = new BSTNode(data);
			}else
				if(data <= n.getdata())
					n.left = insert(n.left,data);
				else
					n.right = insert(n.right,data);
								
					return n;
					
		}
		
		//function to count nodes
		public int countnodes(){
			return(countnodes(root));
		}
		
		private int countnodes(BSTNode n){
			if(n == null)
				return 0;
			else{
				int l = 1;
				l = l + countnodes(n.getleft());
				l = l + countnodes(n.getright());
				return l;
			}
		}
		
		//function to search
		public boolean search(int val){
			return search(root,val);
		}
		
	private boolean search(BSTNode n, int val) {
		boolean found = false;
		int nodevalue = n.getdata();
		while ((n != null) && !found) {
			if ((val < nodevalue))
				n = n.getleft();
			else if (val > nodevalue)
				n = n.getright();
			else {
				found = true;
				break;
			}
			found = search(n, val);
		}
		return found;
	}
		
		//function to delete
		public void delete(int k){
			delete(root,k);
		}
		
		private BSTNode delete(BSTNode node, int k){
			if( node == null)
				System.out.println("The tree is empty");
			else
				if(k < node.getdata())
					node.left = delete(node.left, k);
				else if(k > node.getdata())
					node.right = delete(node.right, k);
				else{
					if(node.left == null)
						return node.right;
					else if(node.right == null)
						return node.left;
						else{
							int min = getmin(node.right);
							node.right = delete(node.right, min);
							node.data = min;
						}
				}
				return node; 
			}
		
		
		public int getmin(BSTNode right){
			if(right.left == null)
				return right.data;
			else
				return getmin(right.left);
		}
		private int retrievedata(BSTNode node){
			while(node.right != null)
				node = node.right;
			return node.data;
		}
		
	/*
		public void delete(int k){
			if(isempty())
				System.out.println("Tree is empty");
			else if(search(k) == false)
				System.out.println("The element " + k + " is not present ");
			else {
				root = delete(root,k);
				System.out.println(k + " deleted from tree ");
			}
		}
		
		private BSTNode delete(BSTNode root, int k){
			BSTNode p,p2,n;
			if(root.getdata() == k){
				BSTNode lt,rt;
				lt = root.getleft();
				rt = root.getright();
				if( lt == null && rt == null)
					return null;
				else if(lt == null){
					p = rt;
					return p;
				}else if( rt == null){
					p = lt;
					return p;
				}else{
					p = lt;
					p2 = rt;
				while(p.getleft() != null)
					p = p.getleft();
					p.setleft(lt);
					return p2;
				
				}
				 if(k < root.getdata()){
					 n = delete(root.getleft(),k);
					 root.setleft(n);
				}else{
					n = delete(root.getright(),k);
					root.setright(n);
				}
				 return root;
			
		}
			*/
			
			//function inorder traversal
			public void inorder(){
				inorder(root);
			}
			
			private void inorder(BSTNode n){
				if( n != null){
				inorder(n.getleft());
					System.out.print(n.getdata() + " ");
					inorder(n.getright());
				}
			}
			
			
			//inorder iterative
		/*	public static void printInorderIterative(Node node) {
				  if (null == node) { return ;}
				   
				  Stack<Node> stack = new Stack<Node>();
				  System.out.println("iterative inorder: ");
				  while (null != node || !stack.isEmpty()) {
				   if (null != node) {
				    stack.push(node);
				    node = node.left;
				   }
				   if (null == node) {
				    node = stack.pop();
				    System.out.print(node.data + " ");
				    node = node.right;
				   }
				  }
				  System.out.println();
				   
				 }*/
			
			public void preorder(){
				preorder(root);
			}
			
			private void preorder(BSTNode n){
				if(n != null){
					System.out.print(n.getdata() + " ");
					preorder(n.getleft());
					preorder(n.getright());
				}
			}
			
			public void postorder(){
				postorder(root);
			}
			
			private void postorder(BSTNode n){
				if(n != null){
					postorder(n.getleft());
					postorder(n.getright());
					System.out.print(n.getdata()+ " ");
				}
			}
		
	}
public class BinarySearchTree {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
	        /* Creating object of BST */
	        BST bst = new BST(); 
	        System.out.println("Binary Search Tree Test\n");          
	        char ch;
	        /*  Perform tree operations  */
	        do    
	        {
	            System.out.println("\nBinary Search Tree Operations\n");
	            System.out.println("1. insert ");
	            System.out.println("2. delete");
	            System.out.println("3. search");
	            System.out.println("4. count nodes");
	            System.out.println("5. check empty"); 
	 
	            int choice = scan.nextInt();            
	            switch (choice)
	            {
	            case 1 : 
	                System.out.println("Enter integer element to insert");
	                bst.insert( scan.nextInt() );                     
	                break;                          
	            case 2 : 
	                System.out.println("Enter integer element to delete");
	                bst.delete( scan.nextInt() );                     
	                break;                         
	            case 3 : 
	                System.out.println("Enter integer element to search");
	                System.out.println("Search result : "+ bst.search( scan.nextInt() ));
	                break;                                          
	            case 4 : 
	                System.out.println("Nodes = "+ bst.countnodes());
	                break;     
	            case 5 :  
	                System.out.println("Empty status = "+ bst.isempty());
	                break;            
	            default : 
	                System.out.println("Wrong Entry \n ");
	                break;   
	            }
	            /*  Display tree  */ 
	                     
	            System.out.print("\nPost order : ");
	            bst.postorder();
	            System.out.print("\nPre order : ");
	            bst.preorder();
	            System.out.print("\nIn order : ");
	            bst.inorder();
	 
	            System.out.println("\nDo you want to continue (Type y or n) \n");
	            ch = scan.next().charAt(0);                        
	        } while (ch == 'Y'|| ch == 'y');          

	}

}
