/*
 * Given an array and a value, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.
 */
import java.util.Arrays;

public class RemoveElementInPlace_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 3, 2, 2, 3, 3 };
		int val = 3;
		int len = removeElement(nums, val);
		System.out.println(len + "length");
		System.out.println(Arrays.toString(nums));

	}

	public static int removeElement(int[] nums, int val) {
		// i is slow pointer j is fast pointer
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				System.out.println(j + " j value");
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
}
/*
 * Now consider cases where the array contains few elements to remove. For
 * example, nums = [1,2,3,5,4], val = 4nums=[1,2,3,5,4],val=4. The previous
 * algorithm will do unnecessary copy operation of the first four elements.
 * Another example is nums = [4,1,2,3,5], val = 4nums=[4,1,2,3,5],val=4. It
 * seems unnecessary to move elements [1,2,3,5][1,2,3,5] one step left as the
 * problem description mentions that the order of elements could be changed.
 * 
 * Algorithm
 * 
 * When we encounter nums[i] = valnums[i]=val, we can swap the current element
 * out with the last element and dispose the last one. This essentially reduces
 * the array's size by 1.
 * 
 * Note that the last element that was swapped in could be the value you want to
 * remove itself. But don't worry, in the next iteration we will still check
 * this element.
 * 
 * swap the value to last and reducing last by one n--
 * public int removeElement(int[] nums, int val) {
    int i = 0;
    int n = nums.length;
    while (i < n) {
        if (nums[i] == val) {
            nums[i] = nums[n - 1];
            // reduce array size by one
            n--;
        } else {
            i++;
        }
    }
    return n;
}
 * 
 */
