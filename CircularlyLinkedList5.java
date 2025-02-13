class CircularLinkedList {
    int value;
    CircularLinkedList next;

    CircularLinkedList(int value) {
        this.value = value;
        this.next = null;
    }
}

public class CircularListSplit {

    public static void splitList(CircularLinkedList L) {
        if (L == null || L.next == L) {
            // List is empty or has only one node, no split needed
            return;
        }

        CircularLinkedList slow = L;
        CircularLinkedList fast = L;

        // Step 1: Find the midpoint
        // Move fast pointer two steps and slow pointer one step at a time
        while (fast != L && fast.next != L) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Now, slow is at the midpoint, so split the list
        CircularLinkedList L1 = L;
        CircularLinkedList L2 = slow.next;

        // Step 2: Terminate the first list at the midpoint
        slow.next = L1;  // L1 should end at slow

        // Step 3: Make the second list circular by linking the last node of L2 to the first node
        CircularLinkedList temp = L2;
        while (temp.next != L2) {
            temp = temp.next;
        }
        temp.next = L2;  // L2 should be circular

        // Print both lists to verify
        System.out.println("List 1:");
        printList(L1);
        System.out.println("List 2:");
        printList(L2);
    }

    // Utility function to print a circular linked list
    public static void printList(CircularLinkedList list) {
        if (list == null) return;

        CircularLinkedList temp = list;
        do {
            System.out.print(temp.value + " ");
            temp = temp.next;
        } while (temp != list);
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a circular linked list L: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> back to 1
        CircularLinkedList L = new CircularLinkedList(1);
        L.next = new CircularLinkedList(2);
        L.next.next = new CircularLinkedList(3);
        L.next.next.next = new CircularLinkedList(4);
        L.next.next.next.next = new CircularLinkedList(5);
        L.next.next.next.next.next = new CircularLinkedList(6);
        L.next.next.next.next.next.next = L;  // making it circular

        // Split the circular linked list into two smaller circular lists
        splitList(L);
    }
}
