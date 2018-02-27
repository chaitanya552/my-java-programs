/*For example, if {12, 9, 12, 9, 10, 9, 10, 11} is the input array,
 *  then the count of occurrences of each element is {12:2, 9:3, 10:2, 11:1}
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountRepeatations_Ap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 12, 9, 12, 9, 10, 9, 10, 11 };
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		for (int i = 0; i < a.length; i++) {
			if (!map.containsKey(a[i])) {
				map.put(a[i], 1);

			} else {
				int val = map.get(a[i]);
				map.put(a[i], val + 1);
			}
		}

		System.out.print(map);
	
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
		    System.out.println(entry.getKey() + " is repeated " + entry.getValue());
		}
	}

}
