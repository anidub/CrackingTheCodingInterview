package ArraysandString;

import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import javax.swing.plaf.basic.BasicTreeUI.TreeTraverseAction;

import Linkedlist.Node;

public class practise {
	
	static LinkedList<Animal> Cats = new LinkedList<Animal>();
	static LinkedList<Animal> Dogs = new LinkedList<Animal>();
	enum Type {Cat, Dog};
	int time = 0;
	
	public class Animal{
		Type type;
		String name;
		int timestamp;
		
		Animal(Type type, String name){
			this.type = type;
			this.name = name;
		}
		
		public String toString(){
			return type + " : " + name;
		}
	}
	
	public void enqueue(Animal a){
		a.timestamp = ++time;
		switch (a.type) {
		case Cat : Cats.add(a); break;
		case Dog : Dogs.add(a); break;
		}
	}

	public static Animal dequedogs(){
		if(Dogs.isEmpty()){
			System.out.println("No dogs available");
		}
			 return Dogs.removeFirst();
				
	}
	
	public static Animal dequeuecats(){
		if(Cats.isEmpty()){
			System.out.println("No cats available");
		}
			return Cats.removeFirst();

	}
	
	public static Animal dequeueAny(){
		if(Dogs.isEmpty() && Cats.isEmpty())
			System.out.println("no animals available ");
		else if(Dogs.isEmpty() && !Cats.isEmpty())
			return dequeuecats();
		else if(Cats.isEmpty() && !Dogs.isEmpty())
			return dequedogs();
		else if(Dogs.getFirst().timestamp < Cats.getFirst().timestamp)
			return dequedogs();
		else 
			return dequeuecats();
		
		return null;
	}
	
	public static void main(String[] args) {
		practise q = new practise();
		q.enqueue(q.new Animal(Type.Cat,"Lilly"));
		q.enqueue(q.new Animal(Type.Dog,"tigery"));
		q.enqueue(q.new Animal(Type.Cat,"billy"));
		
		System.out.println(practise.dequeueAny());
	
	}
	
	
	

	
}
