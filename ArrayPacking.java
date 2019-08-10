
// vidu assesment
import java.io.*;
public class ArrayPacking {
	public static int arrayPacking(int[] a) throws Exception {
	    if(1 <= a.length && a.length <= 4) {
	        int result = 0;
	        for(int index=0;index<a.length;index++) {
	            if(a[index]>256 || a[index]<0) {
	                throw new Exception();
	            }
	            else {
	            	System.out.println();
	                result += a[index] << 8 * index;
	            }
	        }
	        
	        return result;
	    }
	    else {
	        throw new Exception();
	    }
	}
	public static void main(String[] args) throws Exception {
		int [ ] num = {24, 85, 0};
		int answer= arrayPacking(num); 
		System.out.println("final answer is "+answer);
		System.out.println(Integer.toString(24,2));//Method call
		System.out.println(Integer.toString(85,2));
		System.out.println(Integer.toString(0,2));
		
		// TODO Auto-generated method stub

	}

}
