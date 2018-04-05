package treesandgraph3;

import java.util.ArrayList;
import java.util.List;

import Treesandgrapgh.issymmetric.TreeNode;
/*
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/discuss/98100/Java-4ms-Beats-100-Extra-O(1)-solution-No-Map
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * Given BST [1,null,2,2],
   1
    \
     2
    /
   2
   Note: If a tree has more than one mode, you can return them in any order.
   Time complexity: O(n)
   Space Complexity: O(1)Assume that the implicit stack space incurred due to recursion does not count
 */
public class FindMostFrequentElementBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static Integer previous = null;
	static int count = 1;
	static int max = 0;
	
	public static List<Integer> getMode(TreeNode root){
		if(root == null) return null;
		List<Integer> list = new ArrayList<>();
		traverse(root, list);
		return list;
	}
	
	public static void traverse(TreeNode root, List<Integer> list){
		if(root == null) return;
		traverse(root.left, list);
		if(previous != null){
			if(previous == root.value){
				count++;
			}else{
				count = 1;
			}
		}
		if(count > max){
			max = count;
			list.clear();
			list.add(root.value);
		}else if(count == max){
			list.add(root.value);
		}
		previous = root.value;
		traverse(root.right, list);
	}
}
