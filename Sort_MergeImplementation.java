
/*
 * for reference: https://www.youtube.com/watch?v=TzeBrDU-JaY
 */
import java.util.Arrays;

public class Sort_MergeImplementation
{
    int[] inputArray;

    Sort_MergeImplementation(final int[] arr)
    {
        inputArray = arr;
    }

    void printArray()
    {

        for (final int element : inputArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final int[] arr = { 2, 6, 8, 4, 3, 7, 5, 1 };
        final Sort_MergeImplementation obj = new Sort_MergeImplementation(arr);
        System.out.println("unsorted");
        obj.printArray();
        obj.mergeSort(arr);
        System.out.println("sorted");
        obj.printArray();

    }

    public void mergeSort(final int[] arr)
    {
        // base case
        final int n = arr.length;
        if (n < 2) {
            return;
        }
        // so if it comes divide the array by 2 and so on
        final int mid = n / 2;
        final int[] left = Arrays.copyOfRange(arr, 0, mid);
        /*
         * System.out.print("left->"); for (int i = 0; i < left.length; i++) {
         * System.out.print(left[i]); } System.out.println();
         */
        final int[] right = Arrays.copyOfRange(arr, mid, n);
        /*
         * System.out.print("right->"); for (int i = 0; i < left.length; i++) {
         * System.out.print(right[i]); } System.out.println();
         */
        mergeSort(left);

        mergeSort(right);

        // System.out.println(arr.length);
        merge(arr, left, right);

    }

    public int[] merge(final int[] arr, final int[] arr1, final int[] arr2)
    {
        int i = 0;
        int j = 0;
        int k = 0;
        // System.out.println("array length is:" + arr.length);

        while ((i < arr1.length) && (j < arr2.length)) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
            }
            else {
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

/*
 * without passing left and right array and without using new array everytime
 * just pass indexes everytime to save space
 * class MergeSort
 * {
 * // Merges two subarrays of arr[].
 * // First subarray is arr[l..m]
 * // Second subarray is arr[m+1..r]
 * void merge(int arr[], int l, int m, int r)
 * {
 * // Find sizes of two subarrays to be merged
 * int n1 = m - l + 1;
 * int n2 = r - m;
 * Create temp arrays
 * int L[] = new int [n1];
 * int R[] = new int [n2];
 * Copy data to temp arrays
 * for (int i=0; i<n1; ++i)
 * L[i] = arr[l + i];
 * for (int j=0; j<n2; ++j)
 * R[j] = arr[m + 1+ j];
 * Merge the temp arrays
 * // Initial indexes of first and second subarrays
 * int i = 0, j = 0;
 * // Initial index of merged subarry array
 * int k = l;
 * while (i < n1 && j < n2)
 * {
 * if (L[i] <= R[j])
 * {
 * arr[k] = L[i];
 * i++;
 * }
 * else
 * {
 * arr[k] = R[j];
 * j++;
 * }
 * k++;
 * }
 * Copy remaining elements of L[] if any
 * while (i < n1)
 * {
 * arr[k] = L[i];
 * i++;
 * k++;
 * }
 * Copy remaining elements of R[] if any
 * while (j < n2)
 * {
 * arr[k] = R[j];
 * j++;
 * k++;
 * }
 * }
 * // Main function that sorts arr[l..r] using
 * // merge()
 * void sort(int arr[], int l, int r)
 * {
 * if (l < r)
 * {
 * // Find the middle point
 * int m = (l+r)/2;
 * // Sort first and second halves
 * sort(arr, l, m);
 * sort(arr , m+1, r);
 * // Merge the sorted halves
 * merge(arr, l, m, r);
 * }
 * }
 * A utility function to print array of size n
 * static void printArray(int arr[])
 * {
 * int n = arr.length;
 * for (int i=0; i<n; ++i)
 * System.out.print(arr[i] + " ");
 * System.out.println();
 * }
 * // Driver method
 * public static void main(String args[])
 * {
 * int arr[] = {12, 11, 13, 5, 6, 7};
 * System.out.println("Given Array");
 * printArray(arr);
 * MergeSort ob = new MergeSort();
 * ob.sort(arr, 0, arr.length-1);
 * System.out.println("\nSorted array");
 * printArray(arr);
 * }
 * }
 */

/* This code is contributed by Rajat Mishra */