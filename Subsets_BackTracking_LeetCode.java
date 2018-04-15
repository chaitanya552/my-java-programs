import java.util.*;
public class Subsets_BackTracking_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,3};
		System.out.println(subsets(nums));
	}


public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> tempList =new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, tempList, nums, 0);
    return list;
}

private static void backtrack(List<List<Integer>> list ,List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
    	//System.out.println("start"+start);
    	tempList.add(nums[i]);
        
        //System.out.println(tempList);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}
}