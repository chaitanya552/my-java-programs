import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Factorial_recursion {

    static int factorial(int n) {
        // Complete this function
    	if(n==1)
    	{
    		//base case
    		return n;
    	}
    	else
    	{
    		//recursive case
    		return n*factorial(n-1);
    	}
    	
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
        while(in.hasNext())
        {
        	
        int n = in.nextInt();
        int result = factorial(n);
        System.out.println(result);
        }
         
        in.close();
    }
}
