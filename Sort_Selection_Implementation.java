
public class Sort_Selection_Implementation
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final int arr[] = { 4, 1, 2, 3, 9, 13, 11 };
        // i sorted array
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int minPos = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minPos = j;
                }
            }
            swap(arr, minPos, i);

        }

        for (final int k : arr) {
            System.out.print(k);
        }

    }

    private static void swap(final int[] arr, final int minPos, final int i)
    {
        final int temp = arr[i];
        arr[i] = arr[minPos];
        arr[minPos] = temp;
    }
}
