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
		System.out.println("abs " + abstopofstack(1) );
        System.out.println ( "Peek stacknumber(2):" + peek (2 ));
        stack.push(0, 101);
        stack.push(0, 103);
        stack.push(0, 105);
        System.out.println("abs " + abstopofstack(0) );
        stack.pop(0);
        System.out.println ( "Peek stacknumber(0):" + peek (0 ));
	}
    
   //http://shashank7s.blogspot.com/2011/07/implement-3-stack-using-single-array.html
//    /https://codereview.stackexchange.com/questions/12663/describe-how-you-could-use-a-single-array-to-implement-three-stacks
/*    In this approach, any stack can grow as long as there is any free space in the array. We sequentially allocate space 
    to the stacks and we link new blocks to the previous block. This means any new element in a stack keeps a pointer 
    to the previous top element of that particular stack.
    In this implementation, we face a problem of unused space. For example, if a stack deletes some of its elements, 
    the deleted elements may not necessarily appear at the end of the array. So, in that case, we would not be able 
    to use those newly freed spaces. To overcome this deficiency, we can maintain a free list and the whole array space
    would be given initially to the free list. For every insertion, we would delete an entry from the free list. 
    In case of deletion, we would simply add the index of the free cell to the free list.
    In this implementation we would be able to have flexibility in terms of variable space 
    utilization but we would need to increase the space complexity.*/
    class StackNode {
    	 public int previous;
    	 public int value;
    	 public StackNode(int p, int v){
    	    value = v;
    	    previous = p;
    	 }
    int stackSize = 300;
    int indexUsed = 0;
    int[] stackPointer = {-1,-1,-1};
    StackNode[] buffer = new StackNode[stackSize * 3];
    void push(int stackNum, int value) {
       int lastIndex = stackPointer[stackNum];
       stackPointer[stackNum] = indexUsed;
       indexUsed++;
       buffer[stackPointer[stackNum]]=new StackNode(lastIndex,value);
    }

   int pop(int stackNum) {
       int value = buffer[stackPointer[stackNum]].value;
       int lastIndex = stackPointer[stackNum];
       stackPointer[stackNum] = buffer[stackPointer[stackNum]].previous;
       buffer[lastIndex] = null;
       indexUsed--;
       return value;
    }
    int peek(int stack) { 
    	return buffer[stackPointer[stack]].value;
    }
    boolean isEmpty(int stackNum) { 
    	return stackPointer[stackNum] == -1;
    }    
    
    }
}
