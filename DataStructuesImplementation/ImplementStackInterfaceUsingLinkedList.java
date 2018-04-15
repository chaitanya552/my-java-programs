//our goal : stack methods has to defined and we can use linkedlist methods
// so add first(push and remove at first(pop) is the logic
import java.util.LinkedList;

interface Stack<Object> {

	/**
	 * Adds the given item to the top of the stack.
	 */
	void push(Object item);

	/**
	 * Removes the top item from the stack and returns it.
	 * 
	 * @exception java.util.NoSuchElementException
	 *                if the stack is empty.
	 */
	Object pop();

	/**
	 * Returns the top item from the stack without popping it.
	 * 
	 * @exception java.util.NoSuchElementException
	 *                if the stack is empty.
	 */
	Object peek();

	/**
	 * Returns the number of items currently in the stack.
	 */
	int size();

	/**
	 * Returns whether the stack is empty or not.
	 */
	boolean isEmpty();
}

/**
 * A stack class implemented as a wrapper around a java.util.LinkedList. All
 * stack methods simply delegate to LinkedList methods.
 */
public class ImplementStackInterfaceUsingLinkedList<Object> implements Stack<Object> {
	private LinkedList<Object> list = new LinkedList<Object>();

	public void push(Object item) {
	
		list.addFirst(item);
	}

	public Object pop() {
		return list.removeFirst();
	}

	public Object peek() {
		return list.getFirst();
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	public static void main(String[] args)
	{
		
		//instantiate the class
		ImplementStackInterfaceUsingLinkedList<Integer> s1  = new ImplementStackInterfaceUsingLinkedList<Integer>();
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.push(4);
		System.out.println(s1.pop());
		System.out.println(s1.peek());
		
		ImplementStackInterfaceUsingLinkedList<String> s2  = new ImplementStackInterfaceUsingLinkedList<String>();
		s2.push("no1");
		s2.push("no2");
		s2.push("no3");
		s2.push("no4");
		System.out.println(s2.pop());
		System.out.println(s2.peek());
		
	}
}
