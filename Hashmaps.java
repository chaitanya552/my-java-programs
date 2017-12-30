//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

public class Hashmaps{
    public static void main(String []argh){
    	Map<String,Integer> myMap = new HashMap<String,Integer>();
    	Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            myMap.put(name,phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            myMap.get(s);
            if( myMap.get(s)!=null)
            {
            	System.out.println(s+"="+myMap.get(s));
            }
            else
            {
            	System.out.println("Not Found");
            }
        }
        in.close();
    }
}
