import java.util.Arrays;

/* using binary search logn  when you find go left for first index
also go right for last index
12255556789
first index is 3 left binary search
last index is 6 right binary gives this or string.lastindexof(5)
*/
//
public class CountRepeatationsofAnElementInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int arr[]={1,1,2,5,5,5,6,7};
    //replaces all commas,[] in output array to string conversion
    String str= Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", "");
  
    int firstIndex= str.indexOf("5");
    int lastIndex= str.lastIndexOf("5");
    int repeatations= lastIndex-firstIndex+1;
    System.out.println(repeatations+" times '5' repeated");
	}

}
