package StacksandQueues;

public class Implementstack  {

	static int top;
	 static int maxsize;
	int len;
	static int[] arr;
	
	public Implementstack(int s){
		top = -1;
		len = 0;
		maxsize = s;
		arr = new int[maxsize];
	}
	
	public static boolean isempty(){
		return top == -1;
	}
	
	public static boolean isfull(){
		return top == maxsize - 1;
	}
	public void push(int i){
		if(top +1 >= maxsize){
			System.out.println(" Overflow exception");
		}
		if(top + 1 < maxsize){
			len++;
			arr[++top] = i;
		}
	}
	
	public int pop(){
		if(isempty()){
			System.out.println(" The stack is empty");
		}
			len--;
			return arr[top--];
		
	}
		
	public int peek(){
		if(isempty()){
			System.out.println("Underflow exception");
		}
		return arr[top];
	}
	
	public static void display (){
		if(top >= 0){
			for(int i = top; i >= 0; i--){
			System.out.println(arr[i]+ " ");
		}
	}
		else{
			isempty();
		}

	}

	public static void main(String[] args){
		Implementstack st = new Implementstack(3);
		st.push(10);
		st.push(15);
		st.push(20);
		st.pop();
		
		display();
		
	}
}
