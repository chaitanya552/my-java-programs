

import java.util.Scanner;

public class SecondMaximumInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int[] b = { 12, 35, 10, 34, 1 };
		for (int i = 0; i < 5; i++) {
			if (b[i] > max1) {
				// System.out.println("yes");
				max2 = max1;
				max1 = b[i];
			} else if (b[i] > max2) {
				max2 = b[i];
			}

		}

		System.out.println(max1 + "max1");
		System.out.println(max2 + "max2");

	}

}
