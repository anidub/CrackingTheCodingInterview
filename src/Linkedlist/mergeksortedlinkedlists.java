package Linkedlist;

import java.util.LinkedList;
import java.util.PriorityQueue;

import javax.management.ListenerNotFoundException;

public class mergeksortedlinkedlists {

	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.add(1);l1.add(2);l1.add(3);
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.add(11);l2.add(22);l2.add(33);
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		l3.add(111);l3.add(222);l3.add(333);
		
		LinkedList<LinkedList> lists = new LinkedList<>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);

	}
	
	public LinkedList<Integer> mergeLinkedLists(LinkedList<LinkedList> lists){
		if(lists == null) return null;
		
		/*PriorityQueue<LinkedList> queue = new PriorityQueue<LinkedList>(new Comparator<LinkedList>(){
			public int compare(LinkedList l1, LinkedList l2){
				return l1.val() - l2.vak();
			}
		});*/
	}

}
