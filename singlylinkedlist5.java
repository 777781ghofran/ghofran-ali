public class singlylinkedlist5<T> {
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

    // دمج قائمتين (L و M) معًا
    public void concatenate(singlylinkedlist5<T> otherList) {
        if (head == null) {
            head = otherList.head;
            return;
        }

        // الوصول إلى العقدة الأخيرة في القائمة الحالية
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        // ربط العقدة الأخيرة في L مع أول عقدة في M
        current.next = otherList.head;
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

    // دالة اختبار القائمة المترابطة
    public static void main(String[] args) {
        singlylinkedlist5<Integer> listL = new singlylinkedlist5<>();
        singlylinkedlist5<Integer> listM = new singlylinkedlist5<>();

        listL.add(1);
        listL.add(2);
        listL.add(3);

        listM.add(4);
        listM.add(5);

        // قبل الدمج
        System.out.println("List L:");
        listL.printList();

        System.out.println("List M:");
        listM.printList();

        // دمج القائمتين
        listL.concatenate(listM);

        // بعد الدمج
        System.out.println("List L after concatenation:");
        listL.printList();
    }
}
