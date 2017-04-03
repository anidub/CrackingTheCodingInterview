 package Thread;

class RunnableDemo implements Runnable {
	   private Thread t;
	   private String threadName;
	   
	   RunnableDemo( String name){
	       threadName = name;
	       System.out.println("Creating " +  threadName );
	   }
	   public void run() {
	      System.out.println("Running " +  threadName );
	      try {
	         for(int i = 3; i > 0; i--) {
	            System.out.println("Thread: " + threadName + ",  " + i);
	            // Let the thread sleep for a while.
	            Thread.sleep(50);
	         }
	     } catch (InterruptedException e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	     }
	     System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	   public void start ()
	   {
	      System.out.println("Starting " +  threadName );
	      if (t == null)
	      {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }

	}

public class simpleThread {

	public static void main(String[] args) {
		
		
	    RunnableDemo R1 = new RunnableDemo( "Thread-1");
	      R1.start();
	      
	      RunnableDemo R2 = new RunnableDemo( "Thread-2");
	      R2.start();
	      
	}

}

/*
Creating Thread-1
Starting Thread-1 	 
Creating Thread-2
Starting Thread-2
Running Thread-1
Thread: Thread-1,  3
Running Thread-2
Thread: Thread-2,  3
Thread: Thread-1,  2
Thread: Thread-2,  2
Thread: Thread-2,  1
Thread: Thread-1,  1
Thread Thread-1 exiting.
Thread Thread-2 exiting.
*/