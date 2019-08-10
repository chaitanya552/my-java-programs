// Java implementation to insert node
// at the middle of the linked list

class InsertAtMiddleLinkedList
{
    static Node head; // head of list

    /* Node Class */
    static class Node
    {
        int data;
        Node next;

        // Constructor to create a new node
        Node(final int d)
        {
            data = d;
            next = null;
        }
    }

    // function to insert node at the
    // middle of the linked list
    static void insertAtMid(final int x)
    {
        // if list is empty
        if (head == null) {
            head = new Node(x);
        }
        else {
            // get a new node
            final Node newNode = new Node(x);

            Node ptr = head;
            int len = 0;

            // calculate length of the linked list
            // , i.e, the number of nodes
            while (ptr != null) {
                len++;
                ptr = ptr.next;
            }

            // 'count' the number of nodes after which
            // the new node is to be inserted
            int count = ((len % 2) == 0) ? (len / 2) : (len + 1) / 2;
            ptr = head;

            // 'ptr' points to the node after which
            // the new node is to be inserted
            while (count-- > 1) {
                ptr = ptr.next;
            }

            // insert the 'newNode' and adjust
            // the required links
            newNode.next = ptr.next;
            ptr.next = newNode;
        }
    }

    // function to display the linked list
    static void display()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Driver program to test above
    public static void main(final String[] args)
    {
        // Creating the list 1.2.4.5
        head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);

        System.out.println("Linked list before " + "insertion: ");
        display();

        final int x = 3;
        insertAtMid(x);

        System.out.println("\nLinked list after" + " insertion: ");
        display();
    }
}