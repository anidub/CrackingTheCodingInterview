package Linkedlist;

public class addlinkedlistreverseorder {
	/*You have two numbers represented by a linked list, where each node contains a
	single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
	of the list. Write a function that adds the two numbers and returns the sum as a
	linked list*/
	
	public static void main(String[] args) {
		Node a = new Node(1);
		a.next = new Node(2);
		a.next.next = new Node(8);
		
		Node b = new Node(1);
		b.next = new Node(2);
		b.next.next = new Node(8);
		
		//Node b = new Node(7);
		//b.next = new Node(5);
	
		
		display(a);
		System.out.println();
		display(b);
		System.out.println("\n After addition : ");
		display(add(a, b));
	}

	public static void display(Node head){
		Node n = head;
		while(n != null){
			System.out.print("-->" + n.data);
			n = n.next;
		}
	}
	
	/*
	public static Node add(Node first, Node second){
		Node result = null;
		Node temp = null;
		Node prev = null;
		int sum = 0;
		int carry = 0;
		
		while(first != null || second != null){
			sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
			carry = (sum > 10) ? 1 : 0;
			
			sum = sum % 10;
			temp = new Node(sum);
			if(result == null)
				result = temp;
			else{
			prev.next = temp;
			}
			
			prev = temp;
			first = first.next;
			second = second.next;
			
			
				
			}
		if(carry > 0)
			temp.next = new Node(carry);
		
		
			return result;
			
		}*/
		
		//System.out.println(result.data);
	//}
	
	
	public static Node add(Node a, Node b){
		Node pointer = new Node(0);
		Node cursor = pointer;
		int carry = 0;
		while (a != null || b != null){
			int digitsum = carry + (a? a.data: 0) + (b? b.data: 0);
			 digitsum = carry;
			if( a != null){
				digitsum += a.data;
				a = a.next;
			}
			if(b != null){
				digitsum += b.data;
				b = b.next;
			}
		
			cursor.next = new Node(digitsum % 10);
			carry = digitsum/10;
			cursor = cursor.next;
		}
			if(carry != 0){
				cursor.next = new Node(carry);
			}
	
			
			return pointer.next;
		
	}
	
	/*
	public static void main(String[] args){
        Node l1 = new Node(1);
        Node l2 = new Node(3);
        Node l3 = new Node(2);
        Node l4 = new Node(9);
        Node l5 = new Node(8);
        Node l6 = new Node(7);
        Node l7 = new Node(2);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        //Node res = addListsFollowUp(l1, l4, 0);
        return;
    }

 /*   public static Node addListsFollowUp(Node l1, Node l2, int carry){
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        if(len1 < len2){
            l1 = padList(l1,len2-len1);
        }
        else{
            l2 = padList(l2,len1-len2);
        }
        ParitialSum sum = getPartialSum(l1,l2);
        if(sum.carry == 0){
            return sum.sum;
        }
        else{
            Node res = insertBefore(sum.sum, 1);
            return res;
        }
    }

    //get the partial sum of two numbers represented by l1 and l2
    private static ParitialSum getPartialSum(Node l1, Node l2){
        if(l1 == null && l2 == null){
            return new ParitialSum();
        }
        ParitialSum sum = getPartialSum(l1.next, l2.next);
        int value = sum.carry + l1.val + l2.val;
        Node res = insertBefore(sum.sum, value%10);
        sum.sum = res;
        sum.carry = value >= 10 ? 1 : 0;
        return sum;
    }

    //pad the list with zeros in the front
    private static Node padList(Node l, int count){
        Node head = l;
        for(int i = 1; i <= count; i++){
            Node node = new Node(0);
            node.next = head;
            head = node;
        }
        return head;
    }

    //insert the data in front of a linked list
    private static Node insertBefore(Node l, int data){
        Node node = new Node(data);
        node.next = l;
        return node;
    }

    //get the length of a linked list
    private static int getLength(Node l){
        int count = 0;
        Node curr = l;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }
	*/
	
	
	}
