package treesandgraph2;

public class sucessorAndPredeccesor {

	   static Node pre;
	   static Node suc;
	public static void main(String[] args) {
		int key = 65;    //Key to be searched in BST
		 
		   /* Let us create following BST
		              50
		           /     \
		          30      70
		         /  \    /  \
		       20   40  60   80 */
		    Node root = new Node(50);
		    root.left = new Node(30);
		    root.left.left = new Node(20);
		    root.left.right = new Node(40);
		    
		    root.right = new Node(70);
		    root.right.left = new Node(60);
		    root.right.right = new Node(80);
		
		    findPreSuc(root, key);
		    System.out.println(pre.data);
		    System.out.println(suc.data);
	}
	
	public static void findPreSuc(Node root, int key){
		if(root == null) return;
		if(root.data == key){
			if(root.left != null){
				Node temp = root.left;
				while(temp.right != null) temp = temp.right;
				pre = temp;
			}
			if(root.right != null){
				Node temp = root.right;
				while(temp.left != null) temp = temp.left;
				suc = temp;
			}
		}
		if(key > root.data){
			pre = root;
			findPreSuc(root.right, key);
		}else if(key < root.data){
			suc = root;
			findPreSuc(root.left, key);
		}
	}
}