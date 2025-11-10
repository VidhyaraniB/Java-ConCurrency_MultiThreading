package javaconcurrency;
class MyThread extends Thread
{
	public void run() {
		System.out.println("Thread1 Started");
	}
}

public class CreateThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Main Thread Started");
		
		MyThread thread1=new MyThread();
		thread1.start();
		
		//Using Java8 -----------------------------------
		Thread thread2=new Thread(()->
		{
			System.out.println("Thread2 started");
		});
		thread2.start();
		
		//Using runnable------------------------------------
//		Runnable objRunnable=new Runnable()
//				{
//					@Override
//					public void run() {
//						System.out.println("Thread3 started");
//					}
//				};   OR 
				
	   Runnable objRunnable=()->                                                  //Using Runnable and Java8
	                {
	                	System.out.println("Thread3 started"); 
	                	System.out.println(Thread.currentThread().getName());
	                	System.out.println(Thread.currentThread().getState());
	                	try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                	System.out.println("Thread3 ended"); 
	                };
								
		Thread thread3=new Thread(objRunnable,"THREAD-3");
		//thread3.setDaemon(true);
		thread3.start();


	}
}
