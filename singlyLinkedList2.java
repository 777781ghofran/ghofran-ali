class singlyLinkedList2<T> {
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

    // Method to find the second-to-last node
    public Node<T> findSecondToLastNode() {
        // Case 1: List is empty or has only one node
        if (head == null || head.next == null) {
            return null;
        }

        // Case 2: Traverse the list to find the second-to-last node
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        return current;
    }

    // Method to add a node to the list for testing
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

    // Main method to test the solution
    public static void main(String[] args) {
        singlyLinkedList2<Integer> list = new singlyLinkedList2<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Node<Integer> secondToLast = list.findSecondToLastNode();
        if (secondToLast != null) {
            System.out.println("The second-to-last node is: " + secondToLast.data);
        } else {
            System.out.println("There is no second-to-last node.");
        }
    }
}
