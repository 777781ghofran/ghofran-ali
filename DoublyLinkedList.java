public class DoublyLinkedList<T> {
    // Node class (inner class)
    private static class Node<T> {
        T data; // Generic data type
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // DoublyLinkedList properties
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Constructor
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the size of the list
    public int size() {
        return size;
    }

    // Get the first element (head)
    public T first() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    // Get the last element (tail)
    public T last() {
        if (isEmpty()) {
            return null;
        }
        return tail.data;
    }

    // Add an element at the beginning of the list
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Add an element at the end of the list
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Remove and return the first element
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T data = head.data;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }

    // Remove and return the last element
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T data = tail.data;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }

    // Print the list (for testing purposes)
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test with Integer
        DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();
        intList.addFirst(10);
        intList.addLast(20);
        intList.addFirst(5);
        intList.printList(); // Output: 5 <-> 10 <-> 20 <-> null

        System.out.println("First: " + intList.first()); // Output: 5
        System.out.println("Last: " + intList.last());   // Output: 20
        System.out.println("Size: " + intList.size());   // Output: 3

        System.out.println("Removed First: " + intList.removeFirst()); // Output: 5
        System.out.println("Removed Last: " + intList.removeLast());   // Output: 20
        intList.printList(); // Output: 10 <-> null

        System.out.println("Is Empty: " + intList.isEmpty()); // Output: false

        // Test with String
        DoublyLinkedList<String> strList = new DoublyLinkedList<>();
        strList.addFirst("Hello");
        strList.addLast("World");
        strList.addFirst("Hi");
        strList.printList(); // Output: Hi <-> Hello <-> World <-> null

        System.out.println("First: " + strList.first()); // Output: Hi
        System.out.println("Last: " + strList.last());   // Output: World
        System.out.println("Size: " + strList.size());   // Output: 3

        System.out.println("Removed First: " + strList.removeFirst()); // Output: Hi
        System.out.println("Removed Last: " + strList.removeLast());   // Output: World
        strList.printList(); // Output: Hello <-> null

        System.out.println("Is Empty: " + strList.isEmpty()); // Output: false
    }
}
