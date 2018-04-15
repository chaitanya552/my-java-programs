import java.util.Iterator;
import java.util.Stack;

public class ImplementQueueUsingStack {
	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> temp = new Stack<Integer>();

	public void add(int element) {
		s.push(element);
	}

	public void remove() {

		while (!s.isEmpty()) {

			temp.push((int) s.pop());
		}
		if (!temp.isEmpty()) {
			temp.pop();
			while (!temp.isEmpty()) {
				s.push((int) temp.pop());
			}
		}
	}
	public void printQueue()
	{
		System.out.println(s);
	}
	public static void main(String[] args) {

		// new Stack<Integer>();
		ImplementQueueUsingStack q1 = new ImplementQueueUsingStack();
		q1.add(1);
		q1.add(2);
		q1.add(3);
		q1.add(4);
		q1.add(5);
		q1.add(6);
		q1.printQueue();
		q1.remove();
		q1.printQueue();
		q1.remove();
		q1.remove();
		q1.printQueue();
		q1.add(7);
		q1.printQueue();

	}

}
