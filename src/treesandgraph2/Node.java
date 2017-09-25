package treesandgraph2;



public class Node {
	public Node left;
	public Node right;
	public int data;
	
	public Node(){
		this.left = null;
		this.right = null;
		data = 0;
	}
	
	public Node(int n){
		this.left = null;
		this.right = null;
		data = n;
	}
	
	
	//set data
	public void setdata(int n){
		data = n;
	}
	
	//set right 
	public void setright(Node node){
		right = node;
	}

	//set left  
	public void setleft(Node node){
		left = node;
	}
	
	//get data
	public int getdata(){
		return data;
	}

	public Node getleft(){
		return left;
	}
	
	public Node getright(){
		return right;
	}
	

}
