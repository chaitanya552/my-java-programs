package multiThreading;

import java.util.Arrays; 
public class ThreadExampleClass2Run extends Thread {
	private String country;
	public ThreadExampleClass2Run(String country)
	{
		this.country= country;
	}
	
	public void run()
	{
		long threadId = Thread.currentThread().getId();
		System.out.println(threadId+" hello "+ country );
	}
	
	
   public static void main( String[] args)
   {
	   String[] countries = {"India", "germany", "pakisthan"};
	   for( String country : countries)
	   {
		   ThreadExampleClass2Run t1= new ThreadExampleClass2Run(country);
		   t1.run(); //dont do this it will be treated as a single thread
	   }
  }
  
}

