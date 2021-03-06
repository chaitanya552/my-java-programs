// Java program to merge two sorted arrays
/*
 * Given two sorted integer arrays nums1 and nums2, 
 * merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space 
 (size that is greater or equal to m + n) to hold additional elements
 from nums2. The number of elements initialized in 
 nums1 and nums2 are m and n respectively.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class MergeTwoSortedintoFirstArray {
	// Merge arr1[0..n1-1] and arr2[0..n2-1]
	// into arr3[0..n1+n2-1]

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7, 0, 0, 0, 0 };
		int n1 = 4;

		int[] arr2 = { 2, 4, 6, 8 };
		int n2 = arr2.length;

		// int[] arr3 = new int[n1 + n2];

		merge(arr1, n1, arr2, n2);

		System.out.println("Array after merging");
		for (int i = 0; i < arr1.length; i++)
			System.out.print(arr1[i] + " ");
	}

	// num1[]= 2,4,6,8,0,0,0,0
	// num2[2]=1,3,5,7
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k] = nums1[i];
				k--;
				i--;
			} else {
				nums1[k] = nums2[j];
				k--;
				j--;

			}

		}
		while (j >= 0) {
			nums1[k] = nums2[j];
			k--;
			j--;
		}
	}
}
