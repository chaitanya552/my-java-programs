package multiThreading;

import java.util.Arrays;

/*public class ThreadExampleClass implements Runnable {

	@Override
	public void run() {
		System.out.println("hi");
	}
	
	Thread t1 = new Thread(new ThreadExampleClass ());
	t1.start();

}*/

//method 2
//Extending Java Thread
//The second way to create a thread is to create a new class that extends Thread, then override the run() 
public class ThreadExampleClass extends Thread {
	private String country;
	public ThreadExampleClass(String country)
	{
		this.country= country;
	}
	
	public void run()
	{
		System.out.println("hello "+ country );
	}
	
	
   public static void main( String[] args)
   {
	   String[] countries = {"India", "germany", "pakisthan"};
	   for( String country : countries)
	   {
		   ThreadExampleClass t1= new ThreadExampleClass(country);
		   t1.start();
	   }
  }
  
}

