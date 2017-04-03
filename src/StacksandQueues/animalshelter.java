package StacksandQueues;

import java.util.LinkedList;

public class animalshelter {
	/*
		LinkedList<Animal> Cats = new LinkedList<Animal>();
		LinkedList<Animal> Dogs = new LinkedList<Animal>();
		int time = 0;
		enum Type {Cat,Dog};
		
			class Animal{
			Type type;
			String name;
			int timestamp;
			
			
			public Animal(Type type, String name){
				this.type = type;
				this.name = name;
			}
			
			public String toString(){
				return type + " : " + name;
			}
			
		} 
		
		public void enqueue(Animal a){
			a.timestamp = ++time;
			switch(a.type){
			case Cat : Cats.add(a);break;
			case Dog : Dogs.add(a);break;
			}
		}
		
		public Animal dequeuedogs(){
			if(Dogs.isEmpty()){
				System.out.println("Dogs not available");
			}
			return Dogs.removeFirst();
		}
		
		public Animal dequeuecats(){
			if(Cats.isEmpty()){
				System.out.println("Cats not available ");
			}
				return Cats.removeFirst();
		}
		
		public Animal dequeueany(){
			if(Cats.isEmpty() && Dogs.isEmpty()){
				System.out.println("No animals available");
			} else if(Cats.isEmpty()){
				return dequeuedogs();
			} else if (Dogs.isEmpty()){
				return dequeuecats();
			}else if (Dogs.getFirst().timestamp < Cats.getFirst().timestamp){
				return dequeuedogs();
			}else
				return dequeuecats();
				return null;
		}
		
	*/
	    LinkedList<Animal> Dogs = new LinkedList<Animal>();
		LinkedList<Animal> Cats = new LinkedList<Animal>();
		int time = 0;
		enum Type {Cat,Dog};
		
		public class Animal{
			Type type;
			String name;
			int timestamp;
		
			
		public Animal(Type type, String name){
			this.type = type;
			this.name = name;
			}
		
		public String toString(){
			return type + " : " + name;
		}
		
}
		
		public void enqueue(Animal a){
			a.timestamp = ++time;
			switch(a.type){
			case Cat : Cats.add(a); break;
			case Dog : Dogs.add(a); break;
 			}
		}
		
		public Animal dequeuedogs(){
			if(Dogs.isEmpty()){
				System.out.println("No dogs available");
			}
			return Dogs.removeFirst();
		}
		
		public Animal dequeuecats(){
			if(Cats.isEmpty()){
				System.out.println("No cats available");
			}
			return Cats.removeFirst();
		}
		
		public Animal dequeueAny(){
			if(Dogs.isEmpty() && Cats.isEmpty()){
				System.out.println("No animals available");
			}else if(Dogs.isEmpty()){
				return dequeuecats();
			}else if(Cats.isEmpty()){
				return dequeuedogs();
			}else if(Dogs.getFirst().timestamp < Cats.getFirst().timestamp){
				return dequeuedogs();
			}else
				
				return dequeuecats();
			return null;
			
		}
		
 		
	public static void main(String[] args) {
		animalshelter q = new animalshelter();
		q.enqueue(q.new Animal(Type.Cat,"lily"));
		q.enqueue(q.new Animal(Type.Dog, "tiger"));
		q.enqueue(q.new Animal(Type.Cat,"billy"));
		q.enqueue(q.new Animal(Type.Dog, "tommy"));
		
		System.out.println(q.dequeueAny());
        System.out.println(q.dequeuecats());
        System.out.println(q.dequeueAny());
        
	
        q.enqueue(q.new Animal(Type.Dog, " Moti"));
        System.out.println(q.dequeueAny());
        System.out.println(q.dequeuedogs());
        System.out.println(q.dequeuecats());

	}

}
