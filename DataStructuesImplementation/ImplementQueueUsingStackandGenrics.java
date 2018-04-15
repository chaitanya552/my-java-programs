import java.util.Iterator;
import java.util.Stack;

public class ImplementQueueUsingStackandGenrics<Object> {
	Stack<Object> s = new Stack<Object>();
	Stack<Object> temp = new Stack<Object>();

	public void add(Object element) {
		s.push(element);
	}

	public void remove() {

		while (!s.isEmpty()) {

			temp.push((Object) s.pop());
		}
		if (!temp.isEmpty()) {
			temp.pop();
			while (!temp.isEmpty()) {
				s.push((Object) temp.pop());
			}
		}
	}
	public void printQueue()
	{
		System.out.println(s);
	}
	public static void main(String[] args) {

		// new Stack<Integer>();
		ImplementQueueUsingStackandGenrics<Integer> q1 = new ImplementQueueUsingStackandGenrics<Integer>();
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
		ImplementQueueUsingStackandGenrics<String>  q2 = new ImplementQueueUsingStackandGenrics<String> ();
		q2.add("hi");
		q2.printQueue();

	}

}
