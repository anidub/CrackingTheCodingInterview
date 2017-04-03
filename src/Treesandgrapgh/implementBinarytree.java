package Treesandgrapgh;

import java.util.Scanner;

import javax.xml.soap.Node;

//public class implementBinarytree {
	
		class BTNode{
			BTNode left,right;
			int data;
			
			public BTNode(){
				left = null;
				right = null;
				data = 0;
			}
			
			public BTNode(int n){
				left = null;
				right = null;
				data = n;
			}
			
			//setdata
			public void setdata(int n){
				data = n;
			}
			//set right
			public void setright(BTNode n){
				right = n;
			}
			//set left
			public void setleft(BTNode n){
				left = n;
			}
			//get data
			public int getdata(){
				return data;
			}
			//get left
			public BTNode getleft(){
				return left;
			}
			//get right
			public BTNode getright(){
				return right;
			}
			
		}
		
		
		class BT{
			private BTNode root;
	
			public BT(){
				root = null;
			}
			
			//empty
			public boolean isempty(){
				return root == null;
			}
			//insert
			public void insert(int data){
				root = insert(root, data);
			}
			
			private BTNode insert(BTNode node, int data){
				if(node == null)
					node = new BTNode(data);
				else{
						if(node.right == null)
							node.right = insert(node.right,data);
						else 
							node.left = insert(node.left,data);
				}
				return node;
			}
			
			//search
			public boolean search(int n){
				return search(root,n);
			}
			
			private boolean search(BTNode node,int val){
				if(node.getdata() == val)
					return true;
				else{
					if(node.getleft() != null){
						if(search(node.left, val))
							return true;
					}
					if(node.getright() != null){
						if(search(node.right, val))
							return true;
					}				
							
				}
				return false;
			}
			
			
			public int countnodes(){
				return countnodes(root);
			}
			
			private int countnodes(BTNode node){
				if(node == null)
					return 0;
				else{
					int l = 1;
					l = l + countnodes(node.getleft());
					l = l + countnodes(node.getright());
					return l;
				}
			}
			
			//inorder
			public void inorder(){
				inorder(root);
			}
			
			private void inorder(BTNode node){
				if(node != null){
					inorder(node.getleft());
					System.out.println(node.getdata() + " ");
					inorder(node.getright());
				}
			}
			
			public void preorder(){
				preorder(root);
			}
			
			private void preorder(BTNode node){
				if(node != null){
					System.out.println(node.getdata()+ " ");
					preorder(node.getleft());
					preorder(node.getright());
				}
			}
			
			public void postorder(){
				postorder(root);
			}
			
			private void postorder(BTNode node){
				if(node != null){
					postorder(node.getleft());
					System.out.println(node.getdata() + " ");
					postorder(node.getright());
				}
			}
		}
		
	/*
  	class BTNode{
		BTNode left;
		BTNode right;
		int data;
		
	//constructor
		public BTNode(){
			left = null;
			right = null;
			data  = 0;
		}
		//constructor
		public BTNode(int n){
			left = null;
			right = null;
			data = n;
		}
		//set left node
		public void setLeft(BTNode n){
			left = n;
		}
		//get left node
		public BTNode getLeft(){
			return left;
		}
		//set right node
		public void setRight(BTNode n){
			right = n;
		}
		//get right node
		public BTNode getRight(){
			return right;
		}
		
		//function to set data
		public void setData(int d){
			data = d;
		}
		//get data
		public int getData(){
			return data;
		}
	}
	
	
	class BT{
		private BTNode root;
		
		public BT(){
			root = null;
		}
		//function to check empty
		public boolean isEmpty(){
			return root == null;
		}
		//function to insert data
		public void insert(int data){
			root = insert(root,data);
		}
		//function to insert data recursively
		private BTNode insert(BTNode node,int data){
			if(node == null)
				node = new BTNode(data);
			else{
				if(node.right == null)
					node.right = insert(node.right,data);
				else
					node.left = insert(node.left,data);
			}
			return node;
		
		}
		
		public int Countnodes(){
			return Countnodes(root);
		}
		
		private int Countnodes(BTNode r){
			if( r == null){
				return 0;
			}else{
				int l = 1;
				l = l + Countnodes(r.getLeft());
				l = l + Countnodes(r.getRight());
				return l;
			}
		}
		
		
		 public boolean Search(int val){
			 return Search(root, val);
		 }
		 
		 private boolean Search(BTNode r, int val){
			 if(r.getData() == val)
				 return true;
			 if(r.getLeft() != null){
				 if( Search(r.getLeft(),val));
			 		return true;
			 }	
			 if(r.getRight() != null){
				 if(Search(r.getRight(),val));
			 		return true;
			 }
			 return false;		
			 }
		 
	//function for inorder traversal
		 public void Inorder(){
			 Inorder(root);
		 }
		 
		 private void Inorder(BTNode r){
			 if(r != null){
				 Inorder(r.getLeft());
				 System.out.println(r.getData() + " ");
				 Inorder(r.getRight());
			 }
		 }
		 
		 //function for pre order
		 public void Preorder(){
			 Preorder(root);
		 }
		 
		 private void Preorder(BTNode r){
			 if(r != null){
				 System.out.println(r.getData() + " ");
				 Preorder(r.getLeft());
				 Preorder(r.getRight());
			 }
		 }
		 
		 public void Postorder(){
			 Postorder(root);
		 }
		 
		 private void Postorder(BTNode r){
			 if(r != null){
				 Postorder(r.getLeft());
				 Postorder(r.getRight());
				 System.out.println(r.getData() + " ");
			 }
		 }
		}
	*/

	public class implementBinarytree {
	public static void main(String[] args) {
				
		BT bt = new BT();
		Scanner scanner = new Scanner(System.in);
		char ch;
		do{
		System.out.println("Binary operations :");
		System.out.println("1.Insert");
		System.out.println("2.search");
		System.out.println("3.countnodes");
		System.out.println("4.check empty");
		 
		int choice = scanner.nextInt();
		
		switch(choice){
		case 1 : 
			System.out.println("Enter element to insert : ");
			bt.insert(scanner.nextInt());
			break;
				
		case 2: 
			System.out.println("Enter the elment to search : ");
			System.out.println(bt.search(scanner.nextInt()));
			break;
		
		case 3 : 
			System.out.println("The number of nodes are : " + bt.countnodes() );
			break;
			
		case 4 : 
			System.out.println("Empty status : " + bt.isempty());
			break;
		
			default:
				System.out.println("Enter valid choice ! ");
				break;
		}
		
		//display tree
		System.out.println("Inorder  : ");
		bt.inorder();
		
		System.out.println("Preorder : ");
		bt.preorder();
		
		System.out.println("Postorder : ");
		bt.postorder();
		
		System.out.println("Do you want to continue : (type y or n ) ");
		ch = scanner.next().charAt(0);
		
	}while(ch == 'Y' || ch == 'y');
	
	
		
		/*
		
		Scanner scanner = new Scanner(System.in);
		BT bt = new BT();
		char ch;
		do{
			System.out.println("Binary Tree operations");
			System.out.println("\n1.Insert");
			System.out.println("\n2.Search");
			System.out.println("\n3.Count Nodes");
			System.out.println("\n4. Check Empty");
			
			int choice = scanner.nextInt();
			
			switch(choice){
			case 1:
				System.out.println("Enter Integer element to insert : ");
				bt.insert(scanner.nextInt());
				break;
			
			case 2:
				System.out.println("Enter the integer element to search : ");
				System.out.println("Search result : " + bt.search(scanner.nextInt()));
				break;
				
			case 3:
				System.out.println("Nodes = " + bt.countnodes());
				break;
			
			case 4:
				System.out.println("Empty status = " + bt.isempty());
				break;
			
			default:
				System.out.println("Enter valid choice ");
			}
			
			//display tree
			System.out.println("\nPreorder : ");
			bt.preorder();
			System.out.println("\nPostOrder : ");
			bt.postorder();
			System.out.println("\nInorder : ");
			bt.inorder();
			
			System.out.println("Do you want to continue( Type y or n ");
			ch = scanner.next().charAt(0);
			
			
		}while(ch == 'Y' || ch == 'y');
		*/
	}
	}

