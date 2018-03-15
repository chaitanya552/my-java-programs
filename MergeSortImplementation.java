/*
 * for reference: https://www.youtube.com/watch?v=TzeBrDU-JaY
 */
import java.util.Arrays;

public class MergeSortImplementation {
	int[] inputArray;

	MergeSortImplementation(int[] arr) {
		this.inputArray = arr;
	}

	void printArray() {

		for (int p = 0; p < inputArray.length; p++) {
			System.out.print(inputArray[p] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 6, 8, 4, 3, 7, 5, 1 };
		MergeSortImplementation obj = new MergeSortImplementation(arr);
		System.out.println("unsorted");
		obj.printArray();
		obj.mergeSort(arr);
		System.out.println("sorted");
		obj.printArray();

	}

	public void mergeSort(int[] arr) {
		// base case
		int n = arr.length;
		if (n < 2) {
			return;
		}
		// so if it comes divide the array by 2 and so on
		int mid = n / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		/*
		 * System.out.print("left->"); for (int i = 0; i < left.length; i++) {
		 * 
		 * System.out.print(left[i]); } System.out.println();
		 */
		int[] right = Arrays.copyOfRange(arr, mid, n);
		/*
		 * System.out.print("right->"); for (int i = 0; i < left.length; i++) {
		 * 
		 * System.out.print(right[i]); } System.out.println();
		 */
		mergeSort(left);
		mergeSort(right);
		// System.out.println(arr.length);
		merge(arr, left, right);

	}

	public int[] merge(int[] arr, int[] arr1, int[] arr2) {
		int i = 0;
		int j = 0;
		int k = 0;
		// System.out.println("array length is:" + arr.length);

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				arr[k] = arr1[i];
				i++;
			} else {
				arr[k] = arr2[j];

				j++;
			}
			k++;

		}
		while (i < arr1.length) {
			arr[k] = arr1[i];
			i++;
			k++;
		}

		while (j < arr2.length) {

			arr[k] = arr2[j];
			j++;
			k++;
		}

		/*
		 * System.out.print("merged->"); for (int p = 0; p < arr.length; p++) {
		 * System.out.print(arr[p] + " "); } System.out.println();
		 */
		return arr;
	}
}
