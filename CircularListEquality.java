class CircularLinkedList {
    int value;
    CircularLinkedList next;

    CircularLinkedList(int value) {
        this.value = value;
        this.next = null;
    }
}

public class CircularListEquality {
    public static boolean areCircularListsEquivalent(CircularLinkedList L, CircularLinkedList M) {
        // Step 1: Get lengths and elements
        String LSequence = getSequence(L);
        String MSequence = getSequence(M);

        if (LSequence == null || MSequence == null) {
            return LSequence == MSequence; // Both null -> true, one null -> false
        }

        if (LSequence.length() != MSequence.length()) {
            return false;
        }

        // Step 3: Simulate circular nature and check sequence equivalence
        String MSequenceExtended = MSequence + MSequence; // Repeat M's sequence
        return MSequenceExtended.contains(LSequence);
    }

    private static String getSequence(CircularLinkedList list) {
        if (list == null) return null;

        StringBuilder sb = new StringBuilder();
        CircularLinkedList current = list;

        do {
            sb.append(current.value).append(",");
            current = current.next;
        } while (current != list);

        return sb.toString();
    }

    public static void main(String[] args) {
        // Example usage:

        // Create circular list L: 1 -> 2 -> 3 -> back to 1
        CircularLinkedList L = new CircularLinkedList(1);
        L.next = new CircularLinkedList(2);
        L.next.next = new CircularLinkedList(3);
        L.next.next.next = L;

        // Create circular list M: 2 -> 3 -> 1 -> back to 2
        CircularLinkedList M = new CircularLinkedList(2);
        M.next = new CircularLinkedList(3);
        M.next.next = new CircularLinkedList(1);
        M.next.next.next = M;

        // Check equivalence
        boolean result = areCircularListsEquivalent(L, M);
        System.out.println("Are circular lists equivalent? " + result);
    }
}
