package Treesandgrapgh;

public class q3sortedarraytobst {
	
	class BNode{
		BNode left,right;
		int data;
		
		
		BNode(int d){
			left = null;
			right = null;
			data = d;
		}
		
		public void setLeft(BNode n){
			left = n;
		}
		//function to set right node
		public void setRight(BNode n){
			right = n;
		}
		//function to get left node
		public BNode getLeft(){
			return left;
		}
		//function to get right node
		public BNode getRight(){
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
			
		public  BNode sortarraytobst(int[] array, int start,int end){
				if(end < start)
					return null;
				int mid = start + (end - start)/2;
				BNode node = new BNode(array[mid]);
				node.right = sortarraytobst(array, mid + 1, end);
				node.left = sortarraytobst(array, start, mid-1);
				return node;			
		}	

		public BNode arraybst(int[] array) {
			return sortarraytobst(array, 0, array.length - 1);
		}
	}
	public static void main(String[] args) {
	}
}
