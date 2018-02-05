/*
 * Assumptions:
 * Case 1: if both linkedlist is null, then reuturn null
 * Case 2: if either one of them is null, then return the other one
 * 
 * Steps:
 * 		Create a new listNode called sol, compare each two node on two input lists,
 * 		the smaller one will connect to sol, and then smaller
 * 		one goes to next node. if a list is reach its tail, then new listNode 
 * 		connect the remaining part of the other one.
 * 
 * Return the listNode that we create.
 * 
 * Time Complexity: O(the total number of node from two input listNode) Space: same as Time Complexity.
 */
public class MergeTwoSortedLists_LeetCode {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode sol = new ListNode(0);
		ListNode curr = sol;
		while(l1 != null && l2 != null){
			if(l1.val <= l2.val){
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		curr.next = l1 == null ? l2 : l1;
		return sol.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
 * using recursion
 *  public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        ListNode mergeHead = l1.val < l2.val ? l1 : l2;
        mergeHead.next = mergeTwoLists(mergeHead.next, mergeHead == l1 ? l2 : l1);
        return mergeHead;
        
    }
 */


