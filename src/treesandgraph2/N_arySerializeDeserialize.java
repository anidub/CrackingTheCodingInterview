package treesandgraph2;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//http://interviewpractise.blogspot.com/2014/11/serialize-and-deserialize-n-ary-tree.html
/*Encoding:

Data of each node will be represented using begin '.' and end '.'

')' will represent no more child for the node.

The basic idea is pack the tree using DFS, ')' will be written whenever current node's all child are written*/
public class N_arySerializeDeserialize {

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
	  
	public static void main(String[] args) throws UnsupportedEncodingException {
		Node root = new Node("5");  
        Node ch1 = new Node("8");  
        Node ch2 = new Node("9");  
        Node ch3 = new Node("11");  
        root.addChild(ch1);  
        root.addChild(ch2);  
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
        String packed = Node.serialize(root);  
        System.out.println(packed);  
        Node compareTo = Node.deserialize(packed);  
        System.out.println(root.equals(compareTo));  

	}
	
	public void levelOrder(Node root){
		if(null != root){
			System.out.println(root.key);
			
		}
	}
	
	 public static String serialize(Node root) {  
         StringBuilder result = new StringBuilder();  
         if (null != root) {  
              result.append(".");  
              result.append(root.key);  
              result.append(".");  
              for (Node child : root.childs) {  
                   result.append(Node.serialize(child));  
              }  
              result.append(")");  
         }  
         return result.toString();  
    }             
	 
  private static Node deserialize(String node)  throws UnsupportedEncodingException {  
         Node result = null;  
         Stack<Node> stack = new Stack<Node>();  
         boolean isData = false;  
         StringBuilder data = null;  
         for (int i = 0; i < node.length(); i++) {  
              if (node.charAt(i) == '.') {  
                   isData = !isData;  
                   if (isData) {  
                        data = new StringBuilder();  
                   } else {  
                        Node child = new Node(data.toString());  
                        if (!stack.isEmpty()) {  
                             Node parent = stack.peek();  
                             parent.addChild(child);  
                        } else {  
                             result = child;  
                        }  
                        stack.push(child);  
                   }  
              } else {  
                   if (isData) {  
                        data.append(node.charAt(i));  
                   } else if (node.charAt(i) == ')') {  
                        stack.pop();  
                   } else {  
                        throw new UnsupportedEncodingException(  
                                  "Format not recognized.");  
                   }  
              }  
         }  
         return result;  
    }  

		public boolean equals(Node compareTo) {
			if (null == compareTo) {
				return false;
			}
			if (this.key.equals(compareTo.key)) {
				boolean result = true;
				for (int i = 0; i < this.childs.size(); i++) {
					result = result && this.childs.get(i).equals(compareTo.childs.get(i));
				}
				return result;
			} else {
				return false;
			}
		}
	}
}
