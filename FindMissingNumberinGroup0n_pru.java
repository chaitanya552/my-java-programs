public class FindMissingNumberinGroup0n_pru {

	// Java program to find missing Number

	public static void main(String args[]) {
		int seqArray[] = { 1, 2, 4, 5,6 };
		int len = seqArray.length;
		// total number of elements in actual array is len+1;{1,2,3,4,5,6}
		int missingNumber = getTheMissingNo(seqArray, len);
		System.out.println(missingNumber);
	}

	// Function to ind missing number
	static int getTheMissingNo(int a[], int size) {
		// total number of elements in actual array is len+1;{1,2,3,4,5,6}
		int i, total;
		int n = size + 1;
		//sum of numbers 1....n is n*(n+1)/2
		total = (n) * (n + 1) / 2;
		for (i = 0; i < size; i++) {
			total -= a[i];
		}
		return total;
	}

}
