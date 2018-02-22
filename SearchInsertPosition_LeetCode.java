/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
 */
public class SearchInsertPosition_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 3, 6, 7, 7, 8, 9, 10};
		int target = 5;

		System.out.println(searchInsert(nums, target));
	}

	public static int searchInsert(int[] nums, int target) {
		int low=0;
		int high=nums.length-1;
		int middle=0;
		while( low <= high){
        middle = ((low + high)/2);
        if ( nums[middle] == target)
        {
        	return middle;
        }
        else if(target < nums[middle] )
        {
        	high = middle-1;
        }
        else
        {
        	low =middle+1;
        }
		}
		return low;
	}
}
