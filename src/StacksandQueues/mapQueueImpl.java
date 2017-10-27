package StacksandQueues;

import java.util.HashMap;

public class mapQueueImpl implements MapQueue{

	Integer insertionCounter = 0;
	Integer removalCounter = 0;
	HashMap<Integer, String> map = new HashMap<>();
	
	@Override
	public void enqueue(String item) {
		if(item == null || item.length() == 0) return;
		if(insertionCounter == null){
			insertionCounter = 1;
		}
		map.put(insertionCounter, item);
		insertionCounter++;
		
	}

	@Override
	public String dequeue() {
		if(map.isEmpty() || removalCounter > insertionCounter) return null;
		String item = map.get(removalCounter);
		map.remove(removalCounter);
		removalCounter++;
		return item;
	}
	
	public static void main(String[] args) {
		String item1 = "Hello";
		String item2 = "World";
		String item3 = "Anish";
		
		mapQueueImpl a = new mapQueueImpl();
		a.enqueue(item1);
		a.enqueue(item2);
		a.enqueue(item3);
		
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
	}
}