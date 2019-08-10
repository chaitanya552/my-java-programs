
/*
 * https://www.geeksforgeeks.org/optimal-file-merge-patterns/
 * 2,3,4,8,10,11
 * If more than 2 files need to be merged then it can be done in pairs. For example, if need to merge 4 files A, B, C, D. First Merge A with B to get X1, merge
 * X1 with C to get X2, merge X2 with D to get X3 as the output file.
 * If we have two files of sizes m and n, the total computation time will be m+n. Here, we use greedy strategy by merging two smallest size files among all the
 * files present.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class OptimiseFilesEncoding_Amz
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final int files[] = { 2, 4, 7, 5, 6, 3 };
        final OptimiseFilesEncoding_Amz instance = new OptimiseFilesEncoding_Amz();
        final int result = instance.encodeAndCompressFiles(files);
        System.out.println(result);

    }

    private int encodeAndCompressFiles(final int[] files)
    {
        int sum = 0;
        Arrays.sort(files);

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        final List<Integer> list = new ArrayList<>();
        for (final int a : files) {
            pq.add(a);
        }
        while (pq.size() > 1) {
            final int temp = pq.poll() + pq.poll();
            pq.add(temp);// every time pq gets sorted and min elements will be compressed
            sum = sum + temp;
        }
        return sum;
    }

}
