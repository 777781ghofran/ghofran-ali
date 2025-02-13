public class CircularLinkedList6 {
    class CircularLinkedList6 {
        int value;
        CircularLinkedList next;

        CircularLinkedList(int value) {
            this.value = value;
            this.next = null;
        }

        // Clone the circular linked list
        public CircularLinkedList clone() {
            // If the list is empty, return null
            if (this == null || this.next == null) {
                return null;
            }

            // Create a new circular list starting with a copy of the first node
            CircularLinkedList clonedHead = new CircularLinkedList(this.value);
            CircularLinkedList currentOriginal = this.next;
            CircularLinkedList currentClone = clonedHead;

            // Traverse the original list and clone each node
            while (currentOriginal != this) {
                CircularLinkedList newNode = new CircularLinkedList(currentOriginal.value);
                currentClone.next = newNode;
                currentClone = newNode;
                currentOriginal = currentOriginal.next;
            }

            // Finally, make the list circular by connecting the last node to the head
            currentClone.next = clonedHead;

            return clonedHead;  // Return the cloned list's head
        }

        // Utility function to print the circular linked list
        public void printList() {
            if (this == null) return;

            CircularLinkedList temp = this;
            do {
                System.out.print(temp.value + " ");
                temp = temp.next;
            } while (temp != this);
            System.out.println();
        }

        public static void main(String[] args) {
            // Create a circular linked list L: 1 -> 2 -> 3 -> back to 1
            CircularLinkedList L = new CircularLinkedList(1);
            L.next = new CircularLinkedList(2);
            L.next.next = new CircularLinkedList(3);
            L.next.next.next = L;  // making it circular

            // Clone the circular linked list
            CircularLinkedList clonedList = L.clone();

            // Print both the original and cloned lists
            System.out.println("Original List:");
            L.printList();

            System.out.println("Cloned List:");
            clonedList.printList();
        }
    }

}
