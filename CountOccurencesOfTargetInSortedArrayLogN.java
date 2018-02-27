/*
 * Given a sorted array of integers containing duplicates, count occurrences of a number provided.
 *  If the element is not found in the array, report that as well.
 *  We can easily solve this problem in O(log(n)) time by modifying binary search algorithm. 
 * The idea is to find the index of first and last occurrence of given num
 */
public class CountOccurencesOfTargetInSortedArrayLogN {
	public static void main(String[] args) {
		int[] A = { 2, 5, 5, 5, 6, 6, 8, 9, 9, 9 };
		int key = 5;

		int first = binarySearch(A, key, true); // true for first occurrence
		int last = binarySearch(A, key, false); // false for last occurrence

		int count = last - first + 1;

		if (first != -1) {
			System.out
					.println("Element " + key + " occurs " + count + " times");
		} else {
			System.out.println("Element not found in the array");
		}
	}

	// If searchFirst is true, we return the first occurrence of a number
	// in sorted array of integers; else we return its last occurrence
	public static int binarySearch(int[] A, int x, boolean searchFirst) {
		// search space is A[left..right]
		int left = 0;
		int right = A.length - 1;

		// initialize the result by -1
		int result = -1;

		// iterate till search space contains at-least one element
		while (left <= right) {
			// find the mid value in the search space and
			// compares it with key value
			int mid = (left + right) / 2;

			// if key is found, update the result
			if (x == A[mid]) {
				result = mid;

				// go on searching towards left (higher indices)
				if (searchFirst) {
					right = mid - 1;
				}
				// go on searching towards right (righter indices)
				else {
					left = mid + 1;
				}
			}

			// if key is less than the mid element, discard right half
			else if (x < A[mid]) {
				right = mid - 1;
			}
			// if key is more than the mid element, discard left half
			else {
				left = mid + 1;
			}
		}

		// return the found index or -1 if the element is not found
		return result;
	}

}