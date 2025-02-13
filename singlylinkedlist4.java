
public class singlylinkedlist4<T> {
    private Node<T> head;

    // Node class
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public singlylinkedlist4() {
        this.head = null;
    }

    // Add element to the end of the list
    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(data);
        }
    }

    // Rotate the list
    public void rotate() {
        if (head == null || head.next == null) {
            return;
        }

        Node<T> oldHead = head;
        head = head.next;
        oldHead.next = null;

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = oldHead;
    }

    // Print the elements of the list
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        singlylinkedlist4<Integer> list = new singlylinkedlist4<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Before rotate:");
        list.printList(); // طباعة القائمة قبل التدوير

        list.rotate(); // تدوير القائمة

        System.out.println("After rotate:");
        list.printList(); // طباعة القائمة بعد التدوير
    }
}
