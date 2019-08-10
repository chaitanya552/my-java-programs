
// Radix sort Java implementation
import java.util.Arrays;

class Radix
{

    // A utility function to get maximum value in arr[]
    static int getMax(final int arr[], final int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(final int arr[], final int n, final int exp)
    {
        final int output[] = new int[n]; // output array
        int i;
        final int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            // output[ count[(66/1%10)
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(final int arr[], final int n)
    {
        // Find the maximum number to know number of digits
        final int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passi ng digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; (m / exp) > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    // A utility function to print an array
    static void print(final int arr[], final int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /* Driver function to check for above function */
    public static void main(final String[] args)
    {
        final int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        final int n = arr.length;
        radixsort(arr, n);
        print(arr, n);
    }
}
/* This code is contributed by Devesh Agrawal */
