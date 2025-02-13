public class singlylinkedlist6<T> {
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

    // إضافة عنصر للقائمة
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

    // دالة لعكس القائمة
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null) {
            next = current.next;      // حفظ الرابط التالي
            current.next = prev;      // عكس الرابط الحالي
            prev = current;           // التقدم بـ prev ليصبح العقدة الحالية
            current = next;           // الانتقال إلى العقدة التالية
        }

        head = prev;  // في النهاية prev سيشير إلى الرأس الجديد
    }

    // طباعة القائمة
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

    // دالة اختبار
    public static void main(String[] args) {
        singlylinkedlist6<Integer> list = new singlylinkedlist6<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // طباعة القائمة الأصلية
        System.out.println("Original List:");
        list.printList();

        // عكس القائمة
        list.reverse();

        // طباعة القائمة بعد العكس
        System.out.println("Reversed List:");
        list.printList();
    }
}
