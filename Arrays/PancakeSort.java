package Arrays;
/*
 * Pancake Sort
 * Given an array of integers arr:
 * Write a function flip(arr, k) that reverses the order of the first k elements in the array arr.
 * Write a function pancakeSort(arr) that sorts and returns the input array. You are allowed to use only the function flip you wrote in the first step in order
 * to make changes in the array.
 * Example:
 * input: arr = [1, 5, 4, 3, 2]
 * output: [1, 2, 3, 4, 5] # to clarify, this is panca
 */

class PancakeSort
{

    static int[] pancakeSort(final int[] arr)
    {
        // your code goes here

        // 1 5 4 3 2
        for (int i = 0; i < arr.length; i++) {
            final int k = getMaxIndex(arr, arr.length - i); // 1
            flip(arr, k + 1);// k=2 , after flip 5 1 4 3 2
            flip(arr, arr.length - i);
            // swap I did
            /*
             * final int temp = arr[0];
             * arr[0] = arr[arr.length - i - 1];
             * arr[arr.length - i - 1] = temp;
             */
            // can do another flip

        }
        return arr;

    }

    static int getMaxIndex(final int[] arr, final int z)
    {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < z; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static void flip(final int[] arr, final int k)
    {
        // reverse first k elements in arr
        int temp;
        for (int i = 0; i < (k / 2); i++) {
            temp = arr[i];
            arr[i] = arr[k - i - 1];
            arr[k - i - 1] = temp;

        }
    }

    // 1 5 4 3 2
    // k will be current minimum
    // 5 4 3 2
    // 2 3 4 5
    // 3 4 5

    public static void main(final String[] args)
    {
        final int[] arr = { 1, 5, 4, 3, 2 };
        // flip(arr,4);
        // can you hear me??
        pancakeSort(arr);
        for (final int element : arr) {
            System.out.println(element);
        }

    }

}