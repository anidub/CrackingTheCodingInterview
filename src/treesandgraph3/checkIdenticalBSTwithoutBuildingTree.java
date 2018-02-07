package treesandgraph3;
/*
 * https://www.geeksforgeeks.org/check-for-identical-bsts-without-building-the-trees/
 * Check for Identical BSTs without building the trees
 * https://www.ideserve.co.in/learn/check-if-identical-binary-search-trees-without-building-them-set-1
 * Time complexity : O(N2)
 * space complexity : O(log n)
 * 
 * The idea is to look for the element in both given arrays which would be used to construct the same part of the trees.
For example, given two arrays {3,5,4,6,1,0,2} and {3,1,5,2,4,6,0}; 
in both of these arrays element 3 would be used to construct the root of the tree. Now in both of these arrays, 
if we search for an element which would be used to construct the root of the right sub-tree of node '3' then that element would turn out to be 5. 
The reason for this is that both of these arrays, element 5 is the first element found which is greater than 3. Similarly, 
if we search for an element which would be used to construct the root of the left sub-tree of node '3', 
that element would be 1. This is because element 1 is the first element found in both of these arrays which is less than 3. 
Until this point we know that for both of these BSTs - root 3, and it's left and right sub-tree roots(node 1 and node 5 respectively) are same. 
Moving ahead, to construct root of the left sub-tree of node '5', we look for the first element which is less than 5 but greater than 3.
 The first such element found in both of the arrays is 4. Similarly, to construct the root of the right sub-tree of node '1', 
 we look for the first element in array which is greater than 1 but less than 3. 
 Using this ides we check for equality of elements in two arrays corresponding to identical parts of the BSTs and
  we check this for all possible parts of BSTs using recursion.  
 */
public class checkIdenticalBSTwithoutBuildingTree {

	public static void main(String[] args) {
        int[] arrayForTree1 = {3,5,4,6,1,0,2};         
        int[] arrayForTree2 = {3,1,5,2,4,6,0,5};         
        System.out.println("Check if identical BSTs: " + isIdentical(arrayForTree1, arrayForTree2));
	}

	public static boolean isIdentical(int[] arr1, int[] arr2){
		if(arr1.length != arr2.length) return false;
		return isIdenticalUtil(arr1, arr2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isIdenticalUtil(int[] arr1, int[] arr2, int index1, int index2, int min, int max){
		int j,k;
		
		for(j = index1; j < arr1.length; j++){
			if(arr1[j] > min && arr1[j] < max)
				break;
		}
		
		for(k = index2; k < arr2.length; k++){
			if(arr2[k] > min && arr2[k] < max)
				break;
		}
		
		/*
         * since we are constructing same part of the trees for both arrays element found should be same. If element not found,
         * then that means we found no node satisfying this condition. If this is the case then this should be the case for both the trees
         */
		if(j == arr1.length && k == arr2.length)
			return true;
		/* Return false if any of the following is true
	      a) If the parent element is leaf in one array, but non-leaf in other.
	      b) The elements satisfying constraints are not same. We either search
	         for left child or right child of the parent element (decinded by min
	         and max values). The child found must be same in both arrays */
		if(j == arr1.length || k == arr2.length || arr1[j] != arr2[k])
			return false;
		
		/* Make the current child as parent and recursively check for left and right
	      subtrees of it. Note that we can also pass a[k] in place of a[j] as they
	      are both are same */
		return isIdenticalUtil(arr1, arr2, j+1, k+1, min, arr1[j]) && isIdenticalUtil(arr1, arr2, j+1, k+1, arr1[j], max);
	} 
}
