package StacksandQueues;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Setofstacks {
	private int capacity;
	private int totalsize;
	private List<Stack> stacks;
		
	public Setofstacks(int capacity) {
		this.capacity = capacity;
		totalsize = 0;
		stacks = new ArrayList<Stack>();
	}
	
	public Stack getlateststack() {
		if (stacks.size() == 0) {
			return null;
		}
		return stacks.get(stacks.size() - 1);
	}
		
	public void push(Object item) {
		totalsize++;

		int stackindex = (totalsize - 1) / capacity;
		if (stacks.size() - 1 < stackindex) {
			Stack newstack = new Stack();
			newstack.push(item);
			stacks.add(newstack);
		} else {
			getlateststack().push(item);
		}
	}
		
	public Object pop() {
		Stack lateststack = getlateststack();
		if (lateststack == null || lateststack.empty()) {
			return null;
		}
		Object item = lateststack.pop();
		if (lateststack.empty()) {
			stacks.remove(lateststack);
		}
		totalsize--;
		return item;
	}
		
	public String toString() {
		String str = "";
		for (Stack stack : stacks) {
			str = str + "stacks " + stack.toString() + "->";
		}
		return str;
	}		
			
	public static void main(String[] args) {	
		Setofstacks setofstacks= new Setofstacks(2);
		setofstacks.push(2);
		System.out.println(setofstacks.toString());
		setofstacks.push(4);
		System.out.println(setofstacks.toString());
		setofstacks.push(6);
		System.out.println(setofstacks.toString());
		setofstacks.push(8);
		System.out.println(setofstacks.toString());
		setofstacks.push(10);
		System.out.println(setofstacks.toString());
		setofstacks.pop();
		System.out.println(setofstacks.toString());		
	}
}