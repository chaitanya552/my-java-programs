import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Input: [4,1,2,1,2]
Output: 4
 */
public class SingleNumber_LeetCode {
	public static void main(String[] args) {

		int[] nums = { 4, 1, 2, 1, 2 };
		System.out.println(singleNumber(nums));

	}

	public static int singleNumber(int[] nums) {
		Set<Integer> s = new HashSet<Integer>();
	    for (int i: nums){
	    	if(!s.add(i)){
	    		s.remove(i);
	    	}
	    }
	    return s.iterator().next();
	}
}
