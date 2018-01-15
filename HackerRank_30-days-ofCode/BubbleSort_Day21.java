import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BubbleSort_Day21 {
	public static void bubbleSort(int[] x) {
		int len = x.length;
		int swapCount = 0;
		int lastSwapPosition;
		int endPosition = x.length - 1;

		while (endPosition > 0) {
			lastSwapPosition = 0;
			for (int j = 0; j < endPosition; j++) {
				if (x[j] > x[j + 1]) {
					int temp = x[j];
					x[j] = x[j + 1];
					x[j + 1] = temp;
					swapCount++;
					lastSwapPosition = j;

				}
			}
			endPosition = lastSwapPosition;
		}
		System.out.println("Array is sorted in " + swapCount + " swaps.");
		System.out.println("First Element: " + x[0]);
		System.out.println("Last Element: " + x[len - 1]);
		/*System.out.print("sorted array is: ");
		for (int i : x) {
			System.out.print(i + " ");
		}*/

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		// Write Your Code Here
		bubbleSort(a);
	}
}
