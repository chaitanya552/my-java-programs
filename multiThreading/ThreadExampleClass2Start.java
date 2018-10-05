package multiThreading;

import java.util.Arrays; 
public class ThreadExampleClass2Start extends Thread {
	private String country;
	public ThreadExampleClass2Start(String country)
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
		   ThreadExampleClass2Start t1= new ThreadExampleClass2Start(country);
		   t1.start(); 
	   }
  }
  
}

