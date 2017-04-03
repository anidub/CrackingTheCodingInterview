package StacksandQueues;
import java.util.Stack;

public class Hanoitower {
		
		static Stack<Integer> disks;
		int index;
		
		public Hanoitower(int i){
			index = i;
			disks = new Stack<Integer>();
		}
		
		public int index() {
			  return index;
			 }
		
		public void add(int disk){
			if(!disks.empty() && disk > disks.peek()){
				System.out.println("Unable to add " + disk + " since " + disk + " is greater than" + disks.peek());
			}else
				disks.push(disk);
		}
		
		public static void movedisks(int n, Hanoitower source, Hanoitower destination, Hanoitower buffer){
			if(n <= 0) return;
			
			movedisks(n-1, source, buffer, destination);
			
			movetop(destination);
			
			movedisks(n-1, buffer,destination, source);
		}
		
		public static void movetop(Hanoitower tower){
			int top = disks.pop();
			tower.add(top);
		//System.out.println("Move disk " + top + " from source to " + tower.index);
		}
		
		 public void print() {
			  System.out.println("Contents of Tower: " + index());
			  for (int i = disks.size() - 1; i >= 0; i--) {
			   System.out.println(disks.get(i) + " ");
			  }
		
		 }
		 
		 
	public static void main(String[] args) {
				
		final int disk_num = 5;
		Hanoitower[] towers = new Hanoitower[3];
		
		for(int i = 0; i < towers.length; i++){
			towers[i] = new Hanoitower(i);
		}
		
		for(int i = disk_num; i > 0; i--){
			towers[0].add(i);
		}
		
		towers[0].print();
					
		System.out.println("-------Moving Disks-----");
		movedisks(disk_num, towers[0],towers[2], towers[1]);
				
		System.out.println("-----Destination tower-----");
		System.out.println("[TOP]");
	
		while(!towers[2].disks.isEmpty()){
			System.out.println(towers[2].disks.pop() + " ");
		}
		
	}


}
