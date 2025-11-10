package javaconcurrency;

class SharedReource{
	
	private  boolean flag=false; 
	//private volatile boolean flag=false;     //Use Volatile keyword to fix visibility problem or add synchronized keyword with getter and setter methods

	public synchronized boolean isFlag() {
		return flag;
	}

	public synchronized void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
public class SynchronizeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //Visibility Problem --> when  we updating data at CPU1 into main memory and 
		                           //at same time CPU2 trying to fetch from main memory
	
		
		SharedReource resource=new SharedReource();
		
		//Thread1
		new Thread(()->                                                  //Using Thread and Java8
        {
        	System.out.println("Thread1 started"); 
        	
        	try {
        		System.out.println("Thread1 Logic started"); 
				Thread.sleep(1000);
				System.out.println("Thread1 Logic ended"); 
				resource.setFlag(true);
				System.out.println("Flag set by thread1"); 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }).start();
		
		//Thread2
		new Thread(()->                                                  //Using Thread and Java8
        {
        	System.out.println("Thread2 started"); 
        	
           while(!resource.isFlag())
           {
        	   //It will run until flag value is true
           }
				System.out.println("Thread2 Logic ended"); 
				
			
        }).start();
		
		
		
	
	
	}

}
