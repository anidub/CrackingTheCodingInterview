package Linkedlist;

import java.util.Scanner;


public class Linkedlist {

	public static void main(String[] args) {
		/*Scanner s = new Scanner(System.in);
		
		//creation of nodes
		MyList a = new MyList();
		MyList b = new MyList();
		MyList c = new MyList();
		
		//sorting the data into the info field of nodes
		
		System.out.println("Please enter the data for info field of node a");
		a.info = s.nextInt();
		
		System.out.println("Please enter the data for info field of node b");
		b.info = s.nextInt();
		
		System.out.println("Please enter the data for info field of node c");
		c.info = s.nextInt();

		//linking of nodes
		
		a.link = b;
		b.link = c;
		
		//printing the values
		while(a != null){
		System.out.print(a.info + " --> ");
		a = a.link;
		}
		System.out.print("null");
		*/ //the above is for basic understanding
	
	Scanner sc = new Scanner(System.in);
	
	char c;
	MyList s = new MyList();
	MyList t = s;
	
	System.out.println("Please enter the data for the info field : ");
	s.info = sc.nextInt();
	
	while(true){
		System.out.println(" to add a node press y or n ");
		c = sc.next().charAt(0);
		if(c == 'n' || c == 'N'){
			break;
		}
		
		//MyList l = new MyList();
		s.link = new MyList();
		
		System.out.println("Please enter the data for the info field ");
		s.link.info = sc.nextInt();
		
		s = s.link; //links the node
	}
	s=t;
		while(s != null){
			System.out.print(s.info + "->");
			s=s.link;
		}
		System.out.println("null");
		
		}
		
	
	}

