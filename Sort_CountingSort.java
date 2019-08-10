
public class Sort_CountingSort
{
    public static void main(final String[] args)
    {
        final int[] A = { 2, 5, 6, 7, 1, 1 };
        final int[] result = counting_sort(A);
        for (final int r : result) {
            System.out.print(r);
        }
    }

    static int[] counting_sort(final int A[])
    {

        // First, find the maximum value in A[]
        int K = 0;
        final int N = A.length;
        for (int i = 0; i < N; i++) {
            if (A[i] > K) {
                K = A[i];
            }
        }

        // Initialize the elements of Aux[] with 0
        final int[] Aux = new int[K + 1];
        System.out.println(K);
        for (int i = 0; i <= K; i++) {
            Aux[i] = 0;
        }

        // Store the frequencies of each distinct element of A[],
        // by mapping its value as the index of Aux[] array
        for (int i = 0; i < N; i++) {
            Aux[A[i]]++;
        }

        int j = 0;
        final int[] sorted = new int[N];
        for (int i = 0; i <= K; i++) {
            int tmp = Aux[i];
            // Aux stores which element occurs how many times,
            // Add i in sortedA[] according to the number of times i occured in A[]
            while (tmp-- > 0) {
                // cout << Aux[i] << endl;
                sorted[j] = i;
                j++;
            }
        }
        return sorted;
    }
}