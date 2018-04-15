public class LinkedListEx2 {
	Node head;// initially head is empty
	static int count = 0;// mem location

	public void insert(int data) {
		// inserting at the end33333333
		Node node = new Node();
		node.data = data;
		node.next = null;
		// now assume there are no elements and this is the first element
		if (head == null) {
			head = node;// now head points to first element

			// System.out.println("yes first ele");
		} else {
			// System.out.println("not first");
			Node var = head;// initialized var mem to head which is null
			while (var.next != null) {
				var = var.next;
			}
			// here new element is added at last
			var.next = node;

		}

	}

	void deleteDuplicatesInSortedList() {

		Node focusNode = head;
		while (focusNode.next != null) {
			if (focusNode.data == focusNode.next.data) {
				if (!(focusNode.next.next == null)) {
					focusNode.next = focusNode.next.next;

				} else {
					focusNode.next = null;
				}
			} else {
				focusNode = focusNode.next;
			}
		}

	}

	public void insertAtStart(int data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		head = node;
	}

	public void insertAt(int index, int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		// now assume there are no elements and this is the first element
		Node var = head;// start from first element
		for (int i = 0; i < index - 1; i++) {
			var = var.next;
		}
		node.next = var.next;
		var.next = node;

	}

	public void show() {
		Node var = head;// initialized var mem to head which is null
		while (var.next != null) {
			System.out.println(var.data);
			var = var.next;
			count++;
		}
		count = count + 1;
		System.out.println(var.data);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Node front =new Node(25,null);
		// System.out.println(front);
		LinkedListEx2 listx = new LinkedListEx2();
		listx.insert(1);
		
		listx.insert(3);
		listx.insert(3);
		listx.insert(3);
		listx.insert(4);
		listx.insert(4);
		listx.insert(4);
		listx.deleteDuplicatesInSortedList();
		listx.show();

		System.out.println("list size is " + count);
	}

}
