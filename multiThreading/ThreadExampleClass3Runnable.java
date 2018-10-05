package multiThreading;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

//public class ThreadExampleClass3Runnable extends Thread { these threads cant be inherited anymoreso we use runnable
public class ThreadExampleClass3Runnable implements Runnable {
	private String country;

	public ThreadExampleClass3Runnable(String country) {
		this.country = country;
	}

	public void run() {
		try {
			//Thread.sleep(10000);
			//or 
			TimeUnit.MICROSECONDS.sleep(10000000);
		} catch (InterruptedException e) {
			System.out.println();
		}
		long threadId = Thread.currentThread().getId();
		System.out.println(Thread.currentThread().getState());
		System.out.println(threadId + " hello " + country);
	}

	public static void main(String[] args) {
		String[] countries = { "India", "germany", "pakistan" };
		for (String country : countries) {
			// Syntax when implements runnable
			/*
			 * Thread t1 = new Thread(new MyClass ()); t1.start();
			 */

			// Syntax when extends thread
			/*
			 * MyClass t1 = new MyClass (); T1.start();
			 */
			ThreadExampleClass3Runnable example = new ThreadExampleClass3Runnable(country);
			System.out.println(country);
			Thread t1 = new Thread(example, country);
			t1.start();
		}
	}

}
