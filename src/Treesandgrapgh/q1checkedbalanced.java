package Treesandgrapgh;

public class q1checkedbalanced {
	
		public class BTtreeNode{
			BTtreeNode right,left;
			int data;
		
		public BTtreeNode(){
			left = null;
			right = null;
			data = 0;
		}
		
		public BTtreeNode(int n ){
			data = n;
			left = null;
			right = null;
		}
		
		public void setRight(BTtreeNode n){
			right = n;
		}
		
		public void setLeft(BTtreeNode n){
			left = n;
		}
		
		public void setData(int n){
			data = n;
		}
		
		public int getdata(){
			return data;
		}
		
		public BTtreeNode getleft(){
			return left;
		}
		
		public BTtreeNode getright(){
			return right;
		}
			
		}
	
	class BTtree {
		private BTtreeNode root;

		public BTtree() {
			root = null;
		}

		public boolean isEmpty() {
			return root == null;
		}

		public void insert(int n) {
			insert(root, n);
		}

		private BTtreeNode insert(BTtreeNode node, int d) {
			if (node == null) {
				node = new BTtreeNode(d);
			} else {
				if (node.getright() == null) {
					node.right = insert(node.right, d);
				}
				if (node.getleft() == null) {
					node.left = insert(node.left, d);
				}
			}
			return node;
		}

		public int countlength() {
			return countlength(root);
		}

		private int countlength(BTtreeNode node) {
			if (root == null) {
				return 0;
			} else {
				int l = 1;
				l = l + countlength(node.getleft());
				l = l + countlength(node.getright());
				return l;
			}
		}

		public boolean search(int n) {
			return search(root, n);
		}

		private boolean search(BTtreeNode node, int n) {
			if (node.getdata() == n) {
				return true;
			}
			if (node.getright() != null) {
				if (search(node.getright(), n))
					return true;
			}
			if (node.getleft() != null) {
				if (search(node.getleft(), n))
					return true;
			}
			return false;
		}

		public void inorder() {
			inorder(root);
		}

		private void inorder(BTtreeNode r) {
			while (r != null) {
				inorder(r.getleft());
				System.out.println(r.getdata() + " ");
				inorder(r.getright());
			}
		}

		public void preorder() {
			preorder(root);
		}

		private void preorder(BTtreeNode r) {
			while (r != null) {
				System.out.println(r.getdata() + " ");
				preorder(r.getleft());
				preorder(r.getright());
			}
		}

		public void postorder() {
			postorder(root);
		}

		private void postorder(BTtreeNode r) {
			while (r != null) {
				System.out.println(r.getdata() + " ");
				postorder(r.getleft());
				postorder(r.getright());
			}
		}

		public int checkheight(BTtreeNode root) {
			if (root == null)
				return 0;

			int leftheight = checkheight(root.left);
			if (leftheight == -1) {
				return -1;
			}

			int rightheight = checkheight(root.right);
			if (rightheight == -1) {
				return -1;
			}

			int heightdiff = leftheight - rightheight;
			if (Math.abs(heightdiff) > 1) {
				return -1;
			} else {
				return Math.max(leftheight, rightheight) + 1;
			}
		}

		public boolean balanced(BTtreeNode root) {
			if (checkheight(root) == -1) {
				return false;
			}
			return true;
		}
		
	}
	public static void main(String[] args) {
	}
}
