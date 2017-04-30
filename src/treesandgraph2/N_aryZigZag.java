package treesandgraph2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
///https://www.careercup.com/question?id=5638785930887168
// Though constrained by O(n), it operates at 2n time.
public class N_aryZigZag {
	
	private static class Node {  
	      String key;  
	      List<Node> childs = null;  
	      public Node(String key) {  
	           this.key = key;  
	           this.childs = new ArrayList<Node>();  
	      }  
	      public void addChild(Node child) {  
	           this.childs.add(child);  
	      }
	
		public String getkey() {
			return key;
		}

		public void setkey(String key) {
			this.key = key;
		}

		public List<Node> getChildren() {
			return childs;
		}
	}

	public static void main(String[] args) {
		Node root = new Node("5"); // 										5
        Node ch1 = new Node("8");  	//									8				9				 11		
        Node ch2 = new Node("9"); 	//							13			17						25	  			27		 
        Node ch3 = new Node("11");  //							18			23					28		31
        root.addChild(ch1);  //									20								32		33 34 29
        root.addChild(ch2);  //									22	
        root.addChild(ch3);  
        Node ch4 = new Node("13");  
        Node ch5 = new Node("17");  
        Node ch6 = new Node("18");  
        Node ch7 = new Node("20");  
        Node ch8 = new Node("22");  
        ch1.addChild(ch4);  
        ch1.addChild(ch5);  
        ch4.addChild(ch6);  
        ch6.addChild(ch7);  
        ch7.addChild(ch8);  
        Node ch9 = new Node("23");  
        Node ch10 = new Node("25");  
        Node ch11 = new Node("27");  
        Node ch12 = new Node("28");  
        Node ch13 = new Node("32");  
        Node ch14 = new Node("31");  
        Node ch15 = new Node("33");  
        Node ch16 = new Node("34");  
        Node ch17 = new Node("29");  
        ch5.addChild(ch9);  
        ch3.addChild(ch10);  
        ch3.addChild(ch11);  
        ch10.addChild(ch12);  
        ch10.addChild(ch14);  
        ch12.addChild(ch13);  
        ch14.addChild(ch15);  
        ch14.addChild(ch16);  
        ch14.addChild(ch17);  
        printZigZag(root);
	}
	
	public static void printZigZag(Node node){
	    Stack<Node> thisLevel = new Stack<Node>();
	    Stack<Node> nextLevel = new Stack<Node>();
	    Stack<Node> temp;
	    boolean isLeftToRight = false;
	    StringBuilder line = new StringBuilder();

	    thisLevel.push(node);
	    while(!thisLevel.isEmpty()){
	       while(!thisLevel.isEmpty()){
	            node = thisLevel.pop();
	            line.append(node.key);
	            line.append(' ');
	            if(isLeftToRight){
	            	List<Node> cc = node.getChildren();
	                for(int i = 0; i < cc.size(); i++){
	                    nextLevel.push(cc.get(i));
	                }
	            }else{
	            	List<Node> cc = node.getChildren();
	                for(int i =  cc.size() -1; i > -1; i--){
	                    nextLevel.push(cc.get(i));
	                }
	            }
	       }
	     System.out.println(line.toString());
	       line.setLength(0);
	       temp = thisLevel;
	       thisLevel = nextLevel;
	       nextLevel = temp;
	       isLeftToRight = !isLeftToRight;
	    }
	}
}
