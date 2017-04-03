package StacksandQueues;

public class Singlearrayimplement3stacks {
	static int[] stackpointer = {-1,-1,-1};
	static int stacksize = 100;
	static int[] buffer = new int[stacksize * 300];
	
	public static int abstopofstack(int stacknum){
		return stacknum*stacksize + stackpointer[stacknum];
	}
	
	public static boolean isempty(int stacknum){
		if(stackpointer[stacknum] == -1)
			return true;
		else
			return false;
	}
	
	public void push(int stacknum, int value){
		if(stackpointer[stacknum] + 1 >stacksize){
			System.out.println("The mentioned stack is full");
		}
		stackpointer[stacknum]++;
		buffer[abstopofstack(stacknum)] = value; 
	}
	
	public int pop(int stacknum){
		if(isempty(stacknum)){
			System.out.println("The mentioned stack is empty");
		}
		int value = buffer[abstopofstack(stacknum)];
		buffer[abstopofstack(stacknum)] = 0;
		stackpointer[stacknum]--;
		return value;
	}
	
	public static int peek(int stacknum){
		if(isempty(stacknum)){
			System.out.println("The mentioned stack is empty");
		}
		return buffer[abstopofstack(stacknum)];
	}
	
	
    public static void main(String[] args) {
		Singlearrayimplement3stacks stack = new Singlearrayimplement3stacks();
		stack.push( 2, 4 );
		stack.push( 2, 6 );
		stack.push( 2, 8 );
        System.out.println ( "Peek stacknumber(2):" + peek (2 ));
        stack.push(0, 101);
        stack.push(0, 103);
        stack.push(0, 105);
        stack.pop(0);
        System.out.println ( "Peek stacknumber(0):" + peek (0 ));

	}

}
