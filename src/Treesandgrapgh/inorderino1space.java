package Treesandgrapgh;

public class inorderino1space {
	static void printInorder(Node root) {
		while (root != null)  {
			while (root.left != null) {
				Node p = root;
				while (p.left.left != null) {
					p = p.left;
				}
				System.out.println(p.left.data);
				p.left = p.left.right;
			}
			System.out.println(root.data);
			root = root.right;
		}
	}
}
