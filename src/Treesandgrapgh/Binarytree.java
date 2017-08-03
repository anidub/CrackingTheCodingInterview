package Treesandgrapgh;
import java.util.Scanner;


//public class Binarytree {
	//class BTNode
	class BTNode{
		BTNode left,right;
		int data;
		
		//constructor
		public BTNode(){
			left = null;
			right = null;
			data = 0;
		}
		//constructor
		public BTNode(int n){
			left = null;
			right = null;
			data = n;
		}
		//function to set left node
		public void setLeft(BTNode n){
			left = n;
		}
		//function to set right node
		public void setRight(BTNode n){
			right = n;
		}
		//function to get left node
		public BTNode getLeft(){
			return left;
		}
		//function to get right node
		public BTNode getRight(){
			return right;
		}
		//function to set data to node
		public void setData(int d){
			data = d;
		}
		//function to get data from node
		public int getData(){
			return data;
		}
		
	}
	
	class BT{
		private BTNode root;
		//constructor
		public BT(){
			root = null;
			}
		//function to check if tree is empty
		public boolean isEmpty(){
			return root == null;
		}
		//function to insert data
		public void insert(int data){
			root = insert(root,data);
		}
		//function to insert data recursively
	private BTNode insert(BTNode node, int data) {
		if (node == null) {
			node = new BTNode(data);
		} else {
			if (node.getRight() == null)
				node.right = insert(node.right, data);
			else
				node.left = insert(node.left, data);
		}
		return node;
	}
		//function to count number of nodes
		public int countNodes(){
			return countNodes(root);
		}
			//function to count number of nodes recursively
		private int countNodes(BTNode r){
			if(r==null)
				return 0;
			else{
				int l = 1;
				l = l + countNodes(r.getLeft());
				l = l + countNodes(r.getRight());
				return l;
			}
		}
		
		//function to search for an element
		public boolean search(int val){
			return search(root,val);
		}
		//function to search for an element recursively
		private boolean search(BTNode r, int val){
			if(r.getData() == val)
				return true;
			if(r.getLeft() != null)
				if(search(r.getLeft(), val))
					return true;
			if(r.getRight() != null)
				if(search(r.getRight(), val))
					return true;
			return false;
		}
	
		//function for inorder traversal
		public void inorder(){
			inorder(root);
		}
		public void inorder(BTNode r){
			if(r != null){
				inorder(r.getLeft());
				System.out.print(r.getData() + " ");
				inorder(r.getRight());
			}
		}
			//function for pre order traversal
		public void preorder(){
			preorder(root);
		}
		public void preorder(BTNode r){
			if( r != null){
				System.out.print(r.getData() + " ");
				preorder(r.getLeft());
				preorder(r.getRight());
			}
		}
		//function to post order traversal
		public void postorder(){
			postorder(root);
		}
		public void postorder(BTNode r){
			if( r != null){
				postorder(r.getLeft());
				postorder(r.getRight());
				System.out.print(r.getData() + " ");
			}
		}
	}
	
public class Binarytree {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// create object of BT
		BT bt = new BT();
		// perform tree operation
		System.out.println("Binary Tree Test \n");
		char ch;
		do {
			System.out.println("\nBinary Tree Operation\n");
			System.out.println("1.Insert");
			System.out.println("2.Search");
			System.out.println("3.Count Nodes");
			System.out.println("4.Check empty");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert : ");
				bt.insert(scanner.nextInt());
				break;

			case 2:
				System.out.println("Enter integer element to search : ");
				System.out.println("Search result: " + bt.search(scanner.nextInt()));
				break;

			case 3:
				System.out.println("Nodes = " + bt.countNodes());
				break;

			case 4:
				System.out.println("Empty status = " + bt.isEmpty());
				break;

			default:
				System.out.println("Enter valid choice \n");
				break;
			}

			// display tree
			System.out.println("\n Post Order : ");
			bt.postorder();

			System.out.println("\n Pre Order : ");
			bt.preorder();

			System.out.println("\n In Order : ");
			bt.inorder();

			System.out.println("\n\n Do you want to continue (Type y or n) \n");
			ch = scanner.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}
}