class ListNode {
	int val;
	ListNode next;

	/*
	 * ListNode(int x) { val = x; }
	 */
}

public class RemoveDuplicatesFromSortedList_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */
	/*
	 * Algorithm
	 * 
	 * This is a simple problem that merely tests your ability to manipulate
	 * list node pointers. Because the input list is sorted, we can determine if
	 * a node is a duplicate by comparing its value to the node after it in the
	 * list. If it is a duplicate, we change the next pointer of the current
	 * node so that it skips the next node and points directly to the one after
	 * the next node
	 * 1,1,1,2 move the pointer of middle 1 to next one(third one), 
	 * now it will compare first one to 2
	 * if it is different pointer iterates or else repeats previous step
	 */

	public ListNode deleteDuplicates(ListNode head) {
		ListNode focusNode = head;
		// focusNode!=null to check empty list
		if (head == null) {
			return head;
		}
		while (focusNode.next != null) {
			if (focusNode.val == focusNode.next.val) {
				if (!(focusNode.next.next == null)) {
					focusNode.next = focusNode.next.next;

				} else {
					// for edge case of the last two elements 4,4 here we cant
					// change pointer to blank so we make current.next to null
					focusNode.next = null;
				}
			} else {
				focusNode = focusNode.next;
			}
		}
		return head;
	}
}