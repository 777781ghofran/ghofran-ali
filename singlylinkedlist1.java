public class singlylinkedlist1<T> {
    private Node<T> head;
    private int size;

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
    public singlylinkedlist1() {
        this.head = null;
        this.size = 0;
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
        size++;
    }

    // Overriding equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        singlylinkedlist1<?> other = (singlylinkedlist1<?>) obj;
        if (this.size != other.size) {
            return false;
        }

        Node<T> currentThis = this.head;
        Node<?> currentOther = other.head;

        while (currentThis != null && currentOther != null) {
            if (!currentThis.data.equals(currentOther.data)) {
                return false;
            }
            currentThis = currentThis.next;
            currentOther = currentOther.next;
        }

        return currentThis == null && currentOther == null;
    }

    // Overriding hashCode to align with equals (Optional)
    @Override
    public int hashCode() {
        int result = 1;
        Node<T> current = head;
        while (current != null) {
            result = 31 * result + (current.data == null ? 0 : current.data.hashCode());
            current = current.next;
        }
        return result;
    }

    // For testing purposes
    public static void main(String[] args) {
        singlylinkedlist1<Integer> list1 = new singlylinkedlist1<>();
        singlylinkedlist1<Integer> list2 = new singlylinkedlist1<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(1);
        list2.add(2);
        list2.add(3);

        System.out.println("Are lists equal? " + list1.equals(list2)); // Should print: Are lists equal? true

        list2.add(4);
        System.out.println("Are lists equal? " + list1.equals(list2)); // Should print: Are lists equal? false
    }
}
