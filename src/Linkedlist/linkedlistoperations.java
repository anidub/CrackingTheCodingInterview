package Linkedlist;

import java.util.Scanner;


public class linkedlistoperations {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int data ,ch,size = 0;
		Node head = null;
		Node tail = head;
		while(true){
			System.out.println("Please enter the operation : \n1.Insert \n2.Display \n3.Delete \n4.Exit");
			ch = in.nextInt();
			switch(ch){
			case 1:
				System.out.println("Please enter the element : ");
				data = in.nextInt();
				Node newnode = new Node(data);
				if(head == null){
					head = newnode;
					tail = head;
				}
				else{
					tail.next = newnode;
					tail = newnode;
					System.out.println("Head : " + head.data);
					System.out.println("Tail : " + tail.data);
				}size++;
				break;
			case 2:
				if(size > 0){
				for(Node temp = head; temp != null; temp = temp.next){
					System.out.print(temp.data + "\t");
					System.out.println();
				}
				}break;
			case 3:
				if(size > 0){
				System.out.println("Please enter the element to delete : ");
				data = in.nextInt();
				if(head.data == data){
					head = head.next;
					}else{
					tail = head;
					Node temp = head.next;
					while(temp != null){
						if(temp.data == data){
							tail.next = temp.next;
							size--;
							break;
						}else
							tail = temp;
							temp = tail.next;
						}							
					}					
				}else
				System.out.println("Linkedlist is empty ");
			break;
			default : System.exit(0);				
			}
		}		
	}			
	}