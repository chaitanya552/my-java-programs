import java.util.PriorityQueue;

/*
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */
public class KthLargest_leetcode
{

    public static void main(final String[] args)
    {
        // final int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        final int[] nums = { 3, 2, 1, 4, 5, 6 };
        final int k = 3;

        System.out.println(findKthLargest(nums, 3));
    }

    private static int findKthLargest(final int[] nums, final int k)
    {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (final int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println(pq);
        return pq.peek();
        // final Queue<Integer> q =new LinkedList<Integer>();
    }

}
