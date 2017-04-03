package Treesandgrapgh;

public class Binarysearchtreeimpl {
	 //this is the Node used in the tree
    static class BSTNode{
       /* private int data;
        private Node left;
        private Node right;
        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
        public void setLeft(Node left){
            this.left = left;
        }
        public void setRight(Node right){
            this.right = right;
        }
        public Node getLeft(){
            return this.left;
        }        
        public Node getRight(){
            return this.right;
        }
        public int getData(){
            return this.data;
        }
        public boolean equals(Node n){
            if(this.data ==(int) n.getData()) return true;
            else
                return false;
        }*/
    	
    	BSTNode left,right;
		int data;
		
		public BSTNode(){
			left = null;
			right = null;
			data = 0;
		}
		
		public BSTNode(int n){
			left = null;
			right = null;
			data = n;
		}
		
		//setdata
		public void setdata(int n){
			data = n;
		}
		//set right
		public void setright(BSTNode n){
			right = n;
		}
		//set left
		public void setleft(BSTNode n){
			left = n;
		}
		//get data
		public int getdata(){
			return data;
		}
		//get left
		public BSTNode getleft(){
			return left;
		}
		//get right
		public BSTNode getright(){
			return right;
		}

    }

  //execute the test case
    public void run(){
        BSTNode root = new BSTNode(10);
        insert(root,new BSTNode(20));
        insert(root,new BSTNode(5));
        insert(root,new BSTNode(4));
        insert(root,new BSTNode(5));
        insert(root,new BSTNode(15));
         
        inOrderTraverse(root);
        System.out.println("\n" + binarySearch(root,new BSTNode(650)));
    }
    
    // insert a node to the binary search tree
    public void insert(BSTNode root, BSTNode n){
        if(root == null|| n == null) return;
         
        if(root.getdata() > n.getdata()){
            if(root.getleft() == null){
                root.setleft(n);
                 System.out.println("Added node to left of "+root.getdata()+" of value "+n.getdata());            
            }else{
                insert(root.getleft(),n);
            }
 
        }else if(root.getdata() < n.getdata()){
            if(root.getright() == null){
                root.setright(n);
                System.out.println("Added node to Right of "+root.getdata()+" of value "+n.getdata());      
            }else{
                insert(root.getright(),n);
            }
             
        }
    }
    
    public void inOrderTraverse(BSTNode root){
        if(root != null){
            inOrderTraverse(root.getleft());
            System.out.print("  "+root.getdata());
            inOrderTraverse(root.getright());
        }
         
    }
    //binary search
    public boolean binarySearch(BSTNode root,BSTNode n){
        if(root == null || n == null) {
            return false;
        }
        System.out.println();
        System.out.println("  Testing out "+root.getdata()+" for value "+n.getdata());
        if(root.getdata() > n.getdata()){
           return  binarySearch(root.getleft(),n);
        }else if(root.getdata() < n.getdata()){
           return  binarySearch(root.getright(),n);
        }
        return true;
    }
    
	public static void main(String[] args) {
		
		Binarysearchtreeimpl bts = new Binarysearchtreeimpl();
        bts.run();
	
	}

}


