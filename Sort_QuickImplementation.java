// Java program for implementation of QuickSort
class Sort_QuickImplementation
{
    /*
     * This function takes last element as pivot,
     * places the pivot element at its correct
     * position in sorted array, and places all
     * smaller (smaller than pivot) to left of
     * pivot and all greater elements to right
     * of pivot
     */
    int partition(final int arr[], final int low, final int high)
    {
        final int pivot = arr[high];
        System.out.println("low->" + low);
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                final int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.println(arr[i] + "->" + arr[j]);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        final int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /*
     * The main function that implements QuickSort()
     * arr[] --> Array to be sorted,
     * low --> Starting index,
     * high --> Ending index
     */
    void sort(final int arr[], final int low, final int high)
    {
        if (low < high) {
            /*
             * pi is partitioning index, arr[pi] is
             * now at right place
             */

            final int pi = partition(arr, low, high);
            System.out.println(pi + "->pi");

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(final int arr[])
    {
        final int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver program
    public static void main(final String args[])
    {
        final int arr[] = { 10, 80, 30, 90, 40, 50, 70 };
        final int n = arr.length;

        final Sort_QuickImplementation ob = new Sort_QuickImplementation();
        ob.sort(arr, 0, n - 1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
/* This code is contributed by Rajat Mishra */