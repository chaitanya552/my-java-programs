
public class Sort_InsertionImplementation
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final int arr[] = { 3, 2, 6, 5, 7 };
        // pointer for sorted
        int sortedIndex;

        // 3----2 6 5 7
        // i----key
        for (int i = 1; i < (arr.length - 1); i++) {
            sortedIndex = i - 1;

            final int key = arr[i]; // assume arr[1] is the unsorted element
            while ((sortedIndex >= 0) && (key <= arr[sortedIndex])) {

                arr[i] = arr[sortedIndex];

                arr[sortedIndex] = key;
                sortedIndex--;
            }

        }
        for (final int k : arr) {
            System.out.print(k);
        }
    }
}
