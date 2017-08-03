package treesandgraph2;

import java.util.ArrayList;

public class serializeandDesereailzeBinaryTree {
//https://www.youtube.com/watch?v=jwzo6IsMAFQ
	//http://articles.leetcode.com/serializationdeserialization-of-binary/	
	//http://www.geeksforgeeks.org/serialize-deserialize-binary-tree/
	public void Serialize(Node root, ArrayList<Integer> array){
		if(root == null){
			array.add(-1);
			return;
		}
		
		array.add(root.data);
		Serialize(root.left, array);
		Serialize(root.right, array);
	}
	
	int index = 0;
public Node deSerialize(ArrayList<Integer> array){
	if(index == array.size() || array.get(index) == -1){
		index +=1;
		return null;
	}
	
	Node root = new Node(array.get(index));
	index += 1;
	root.left = deSerialize(array);
	root.right = deSerialize(array);
	return root;
}
	
	public static void main(String[] args) {
		
	}
}
