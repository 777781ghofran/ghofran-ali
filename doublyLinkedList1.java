
    public class doublyLinkedList1<T> {
        // Node class (inner class)
        private static class Node<T> {
            T data;
            Node<T> prev;
            Node<T> next;

            public Node(T data) {
                this.data = data;
                this.prev = null;
                this.next = null;
            }
        }

        // DoublyLinkedList properties
        private Node<T> header; // Sentinel node at the beginning
        private Node<T> trailer; // Sentinel node at the end
        private int size;

        // Constructor
        public doublyLinkedList1() {
            header = new Node<>(null); // Create header sentinel
            trailer = new Node<>(null); // Create trailer sentinel
            header.next = trailer; // Link header to trailer
            trailer.prev = header; // Link trailer to header
            size = 0;
        }

        // Method to find the middle node
        public T findMiddle() {
            if (isEmpty()) {
                return null; // If the list is empty, return null
            }

            Node<T> slow = header.next; // Start slow pointer at the first node
            Node<T> fast = header.next; // Start fast pointer at the first node

            // Move fast pointer two steps at a time and slow pointer one step at a time
            while (fast != trailer && fast.next != trailer) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // When fast reaches the end, slow will be at the middle
            return slow.data;
        }

        private boolean isEmpty() {
            return size == 0;
        }

        // Other methods (addFirst, addLast, isEmpty, etc.) go here...

        // Main method for testing
        public static void main(String[] args) {
            doublyLinkedList1<Integer> list = new doublyLinkedList1<>();
            list.addLast(10);
            list.addLast(20);
            list.addLast(30);
            list.addLast(40);
            list.addLast(50);

            System.out.println("Middle element: " + list.findMiddle()); // Output: 30

            list.addLast(60);
            System.out.println("Middle element: " + list.findMiddle()); // Output: 30 (left of center)
        }

        private void addLast(T i) {
        }
    }

