import java.util.ArrayList;
import java.util.List;


public class Permutations_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,3};
		System.out.println(permute(nums));
	}


	public static List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   List<Integer> tempList= new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   backtrack(list, tempList, nums);
		   return list;
		}

		private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
			//System.out.println("called");
		   if(tempList.size() == nums.length){
		      list.add(new ArrayList<>(tempList));
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		         if(tempList.contains(nums[i])) continue; // element already exists, skip
		         tempList.add(nums[i]);
		       //  System.out.println(i+" i");
		         backtrack(list, tempList, nums);
		        // System.out.println(tempList+" before");
		         tempList.remove(tempList.size() - 1);
		       //  System.out.println(tempList+" after");
		      }
		   }
		} 

}