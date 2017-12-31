class SubarraySumn2 {
	/*
	 * Returns true if the there is a subarray of arr[] with sum equal to 'sum'
	 * otherwise returns false. Also, prints the result
	 */
	public static void subArraySumy(int arr[], int n, int sum) {
		int curr_sum, i, j;
		boolean f = false;

		// Pick a starting point
		outerloop:
		for (i = 0; i < n; i++) {
			curr_sum = arr[i];

			// try all subarrays starting with 'i'
			for (j = i + 1; j <= n; j++) {
				System.out.println(curr_sum + "curr sum" + sum);
				if (curr_sum == sum) {
					int p = j - 1;
					System.out.println("Sum found between indexes " + i
							+ " and " + p);
					f = true;
				}
				if (f==true)
				{
					break outerloop;
				}
				
				if (curr_sum > sum || j == n ) {
					break ;
				}
				System.out.println(j + "jvalue");
				curr_sum = curr_sum + arr[j];
				System.out.println(curr_sum);
			}
			if (f==true)
			{
				break;
			}
		}
		if (f == false) {
			System.out.println("No subarray found");
		}

		// return 0;
	}

	public static void main(String[] args) {

		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int n = arr.length;
		int sum = 14;

		subArraySumy(arr, n, sum);
	}
}