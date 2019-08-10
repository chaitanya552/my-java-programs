
// our goal : Queue methods has to defined and we can use linkedlist methods
// so add at first and remove at last is the logic bcz linkedlist head is at first
import java.util.LinkedList;

interface Queue<Object>
{

    /**
     * Adds the given item to the top of the Queue.
     */
    void add(Object item);

    /**
     * Removes the top item from the Queue and returns it.
     *
     * @exception java.util.NoSuchElementException
     *                                             if the Queue is empty.
     */
    Object remove();

    /**
     * Returns the top item from the Queue without removeping it.
     *
     * @exception java.util.NoSuchElementException
     *                                             if the Queue is empty.
     */
    Object peek();

    /**
     * Returns the number of items currently in the Queue.
     */
    int size();

    /**
     * Returns whether the Queue is empty or not.
     */
    boolean isEmpty();
}

/**
 * A Queue class implemented as a wrapper around a java.util.LinkedList. All
 * Queue methods simply delegate to LinkedList methods.
 */
public class ImplementQueueInterfaceUsingLinkedList<Object> implements Queue<Object>
{
    private final LinkedList<Object> list = new LinkedList<Object>();

    public void add(final Object item)
    {

        list.addFirst(item);
    }

    public Object remove()
    {
        return list.removeLast();
    }

    public Object peek()
    {
        return list.getFirst();
    }

    public int size()
    {
        return list.size();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public static void main(final String[] args)
    {

        // instantiate the class
        final ImplementQueueInterfaceUsingLinkedList<Integer> q1 = new ImplementQueueInterfaceUsingLinkedList<Integer>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        System.out.println(q1.list);
        System.out.println(q1.remove());
        System.out.println(q1.remove());
        System.out.println(q1.peek());

        final ImplementQueueInterfaceUsingLinkedList<String> q2 = new ImplementQueueInterfaceUsingLinkedList<String>();
        q2.add("no1");
        q2.add("no2");
        q2.add("no3");
        q2.add("no4");
        System.out.println(q2.remove());
        System.out.println(q2.peek());

    }
}
