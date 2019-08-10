public class example
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         * int val;
         * ListNode next;
         * ListNode(int x) { val = x; }
         * }
         */
        class Solution
        {
            // iterative prev, head, curr
            public ListNode reverseList(final ListNode head)
            {
                ListNode curr = head;
                ListNode prev = null;
                ListNode after;
                while (curr != null) {
                    after = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = after;
                }
                return prev;
            }
            /*
             * iterative
             * public ListNode reverseList(ListNode head) {
             * if(head==null)
             * {
             * return null;
             * }
             * ListNode prev =null;
             * ListNode curr=head;
             * return recursiveRev(curr, prev);
             * }
             * public ListNode recursiveRev(ListNode curr, ListNode prev) {
             * if(curr==null)
             * {
             * return prev;
             * }
             * ListNode after;
             * after= curr.next;
             * curr.next=prev;
             * prev=curr;
             * curr=after;
             * return recursiveRev(curr, prev);
             * }
             */

        }

    }

}
