public class ConsecutiveSubArrayMaxDPWithIndexes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={ -20, -5, -2, -9 };
		//int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		// {-3,2,4,1,4,3,9};
		// decision has to be made
		// current elemnet + previous sum >max then add it to sequence
		// else reset
		// {-2,1,-3,4,-1,2,1,-5,4}
		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		int start = 0;
		int max_start =0;
		int end = 0;
		int sum = nums[0];
		int local_max = nums[0];
		int global_max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int current_element = nums[i];
			// local_max = Math.max(local_max +current_element,
			// current_element);
			if (local_max + current_element >= current_element) {
				local_max = local_max + current_element;

			} else {
				local_max = current_element;
				start = i;
				System.out.println("start updated"+i);
		       

			}
			// System.out.println(local_max);

			// global_max = Math.max(local_max, global_max);
			if (local_max > global_max) {
			 max_start= start;
				global_max = local_max;
				end=i;
			}

			// System.out.println(global_max);
		}
		System.out.println("start index is: "+max_start+" end index is "+end);
		System.out.println("max is: " + global_max);
		return 0;
	}
}
