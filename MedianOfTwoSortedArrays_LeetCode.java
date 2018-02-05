
/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Solution
 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
 * 
 * 
 * 
 *X x1,x2||x3,x4
 *Y y1,y2||y3,y4
 *initially we make a partition by binary search in the middle of x and partition Y accordingly
 *Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
 *now our aim should be to see if all left partion elements are <= right partition elements 
 *this can be checked by x2<y3 && y2<x3
 *if  the above condition fails and we observe x2>y3 then we move to move partiton towards left of x ( ie. end =partitionX-1)
 *if the above condition fails and if y2>x3 then we have to move to move partion towards right of x( ie. start =partitionX+1)
 *
 * Time complexity is O(log(min(x,y))
 * Space complexity is O(1)
 *
 *
 *
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * https://www.youtube.com/watch?v=LPFhl65R7ww
 */
public class MedianOfTwoSortedArrays_LeetCode {

    public double findMedianSortedArrays(int input1[], int input2[]) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int start = 0;
        int end = x;
        while (start <= end) {
            int partitionX = (start + end)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                end = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                start = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 18, 19, 21, 25};

        MedianOfTwoSortedArrays_LeetCode instance1 = new MedianOfTwoSortedArrays_LeetCode();
        System.out.println(instance1.findMedianSortedArrays(x, y));
    }
}