package Linkedlist;

public class Node {
	public int data;   
     public Node next;
	public Node arbitrary;   
     public Node(int d)// node class Constructor.   
     {  
           data = d;   
          next= null;   
      	this.arbitrary = this.next = null;
     }  

}
