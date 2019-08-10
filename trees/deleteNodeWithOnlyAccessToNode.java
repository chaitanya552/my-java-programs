package trees;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class deleteNodeWithOnlyAccessToNode
{
    public void deleteNode(final ListNode node)
    {

        // since we dont have access to previous node
        // 1->2->3->4 (delete 2 and u r at node 2)
        /*
         * usually we do pevious.next = current.next
         * but here since we dont have previous
         */
        node.val = node.next.val;
        // 1-> 3->3>4
        node.next = node.next.next;
        // 1->3->4

    }
}