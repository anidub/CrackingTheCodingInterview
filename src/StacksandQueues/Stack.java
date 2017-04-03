package StacksandQueues;

public class Stack {
	static int top;
	int maxsize,len;
	static int[] arr;
	
	//constructor for array stack
	public Stack(int s){
		top = -1;
		maxsize = s;
		len = 0;
		arr = new int[maxsize];
	}
	
	public static boolean isempty(){
		return top == -1;
	}
	
	public boolean isfull(){
		return top == maxsize -1;
	}
	
	public void push(int i){
		if(top + 1 >= maxsize){
			System.out.println("Overflow exception");
		} 
		if(top  + 1 < maxsize){
			arr[++top] = i;
	        len++;
	}
	}
	
	public int pop(){
		if(isempty()){
			System.out.println(" underflow exception");
		}
		len--;
		return arr[top--];
	}
	public int peek(){
		if(isempty()){
			System.out.println(" Underflow exception");
		}
		return arr[top];
	}
	
	public static void  display(){
				if(top >= 0){
				for(int i = top; i >= 0; i--){
					System.out.println(arr[i]+ " ");
					System.out.println();
				}
				}
				else
					isempty();
		
}
	
	public static void main(String[] args)  {
		Stack st = new Stack(10);
		st.push(20);
		st.push(30);
		st.push(40);
		display();		
		st.pop();
		st.pop();
		st.pop();
		st.push(50);
		//st.push(50);
		//st.push(50);
		System.out.println("After pop : ");
		display();
	}
}