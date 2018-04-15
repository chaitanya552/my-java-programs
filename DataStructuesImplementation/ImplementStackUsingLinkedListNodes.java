//uses Node and generics Object 
public class ImplementStackUsingLinkedListNodes<Object> {
	Node2 head;

	public ImplementStackUsingLinkedListNodes() {
		this.head = null;
	}

	// Remove value from the beginning of the list for demonstrating behaviour
	// of stack
	public Object pop() throws LinkedListEmptyException {
		if (head == null) {
			throw new LinkedListEmptyException();
		}
		Object value = (Object) head.data;
		head = head.next;
		return value;
	}

	// Add value to the beginning of the list for demonstrating behaviour of
	// stack
	public void push(Object value) {
		Node2 temp = new Node2();
		temp.data = value;
		temp.next = head;
		head = temp;
	}

	public static void printList(Node2 head) {
		Node2 temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;

		}
		System.out.println();
	}

	public static void main(String args[]) {
		ImplementStackUsingLinkedListNodes<Integer> s1 = new ImplementStackUsingLinkedListNodes<Integer>();
		s1.push(20);
		s1.push(50);
		s1.push(80);
		s1.push(40);
		s1.push(60);
		s1.push(75);
		System.out.println("Element removed from LinkedList: " + s1.pop());
		System.out.println("Element removed from LinkedList: " + s1.pop());
		s1.push(10);
		System.out.println("Element removed from LinkedList: " + s1.pop());
		printList(s1.head);

		ImplementStackUsingLinkedListNodes<String> s2 = new ImplementStackUsingLinkedListNodes<String>();
		s2.push("hi");
		s2.push("hie");
		s2.push("hielo");
		s2.push("hielos");
		s2.push("hielost");
		System.out.println("Element removed from LinkedList: " + s2.pop());
		System.out.println("Element removed from LinkedList: " + s2.pop());
		s2.push("bye");
		System.out.println("Element removed from LinkedList: " + s2.pop());
		printList(s2.head);
	}

}

/**
 * 
 * Exception to indicate that LinkedList is empty.
 */

class LinkedListEmptyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LinkedListEmptyException() {
		super();
	}

	public LinkedListEmptyException(String message) {
		super(message);
	}
}
