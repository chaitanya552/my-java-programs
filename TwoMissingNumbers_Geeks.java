/*
 * find two missing numbers in a sequence 
  * 
Input  : arr[] = {1, 3, 5, 6}
Output : 2 4

Input : arr[] = {1, 2, 4}
Output : 3 5

Input : arr[] = {1, 2}
Output : 3 4
 */

/*
 * m1
 * Step 1: Take a boolean array mark that keeps track of all the elements present in the array.
 Step 2: Iterate from 1 to n, check for every element 
 if it is marked as true in the boolean array, if not then simply display that element.
 */

/*
 * m2
 *One of the numbers will be less than or equal to avg while the other one will be strictly greater then avg. 
 *Two numbers can never be equal since all the given numbers are distinct.
 We can find the first missing number as sum of natural numbers from 1 to avg,
 i.e., avg*(avg+1)/2 minus the sum of array elements smaller than avg
 We can find the second missing number as sum of natural numbers from avg+1 to n minus the sum of array elements greater than than avg 
 */
public class TwoMissingNumbers_Geeks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 1, 3, 4, 5 };
		int[] arr2 = { 1, 2, 4, 6 };
		findMissingM1(arr1).printMissing();
		System.out.println();
		findMissingM2(arr2).printMissing();
		;
	}

	public static result findMissingM1(int[] arr1) {
		int n = 2 + arr1.length;
		boolean[] check = new boolean[n + 1];

		for (int i = 0; i < n - 2; i++) {
			check[arr1[i]] = true;

		}
		int var1 = 0;
		int var2 = 0;
		for (int i = 1; i < n + 1; i++) {
			if (check[i] == false) {
				// System.out.println(i);

				if (var1 == 0) {
					var1 = i;
					continue;
				}

				if (var2 == 0) {
					var2 = i;
				}

			}
		}
		// System.out.println(var1+"o"+var2);
		return new result(var1, var2);
	}

	public static result findMissingM2(int[] arr2) {
		int n = 2 + arr2.length;

		int givenSum = 0;
		for (int i = 0; i < n - 2; i++) {
			givenSum += arr2[i];

		}
		int totalSum = n * (n + 1) / 2;
		int missingSum = (totalSum - givenSum);
		int avg = missingSum / 2;
		// first missing num will be less than equal to avg
		// sum from 1 to avg
		int sumSmallerHalf = 0, sumGreaterHalf = 0;
		for (int i = 0; i < n - 2; i++) {
			if (arr2[i] <= avg)
				sumSmallerHalf += arr2[i];
			else
				sumGreaterHalf += arr2[i];
		}
		// second missing num will be greater than avg
		int totalSmallerHalf = avg * (avg + 1) / 2;
		int totalGreaterHalf = totalSum - totalSmallerHalf;
		// We can find the second missing number as sum of natural numbers from
		// avg+1 to n
		// minus the sum of array elements greater than than avg
		int var1 = totalSmallerHalf - sumSmallerHalf;
		int var2 = totalGreaterHalf - sumGreaterHalf;
		// System.out.println(var1+"o"+var2);
		return new result(var1, var2);
	}
}

class result {
	int firstnum;
	int secondnum;

	result(int a, int b) {
		this.firstnum = a;
		this.secondnum = b;

	}

	void printMissing() {
		System.out.println(firstnum);
		System.out.println(secondnum);
	}
}