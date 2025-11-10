package javaconcurrency;

public class MultiThreading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object sharedObject=new Object();                     //Example for shared Object
		
		Runnable objRunnable1=()->                                                  //Using Runnable and Java8
        {
        	System.out.println("Thread1 started"); 
        	System.out.println(sharedObject.hashCode()); 
        	System.out.println(Thread.currentThread().getName());
        	System.out.println(Thread.currentThread().getState());
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("Thread1 ended"); 
        };
        
		Runnable objRunnable2=()->                                                  //Using Runnable and Java8
        {
        	System.out.println("Thread2 started"); 
        	System.out.println(sharedObject.hashCode()); 
        	System.out.println(Thread.currentThread().getName());
        	System.out.println(Thread.currentThread().getState());
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("Thread2 ended"); 
        };
					
Thread thread1=new Thread(objRunnable1,"THREAD-1");
thread1.start();

Thread thread2=new Thread(objRunnable2,"THREAD-2");
thread2.start();


	}

}
