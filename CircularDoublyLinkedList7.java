// تعريف العقدة باستخدام Generics
  class Node<T> {
    T data; // البيانات من النوع العام
    Node<T> next; // العقدة التالية
    Node<T> prev; // العقدة السابقة

    public Node(T data) {
        this.data = data;
        this.next = this; // في القائمة الدائرية، العقدة تشير إلى نفسها في البداية
        this.prev = this;
    }
}

// تعريف القائمة الدائرية المزدوجة باستخدام Generics
public class CircularDoublyLinkedList7<T> {
    private Node<T> head; // رأس القائمة

    // إضافة عنصر في نهاية القائمة
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> tail = head.prev; // الذيل هو العقدة السابقة للرأس
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    // تدوير القائمة للأمام
    public void rotate() {
        if (head != null) {
            head = head.next; // الرأس الجديد هو العقدة التالية
        }
    }

    // تدوير القائمة للخلف
    public void rotateBackward() {
        if (head != null) {
            head = head.prev; // الرأس الجديد هو العقدة السابقة
        }
    }

    // طباعة القائمة
    public void printList() {
        if (head == null) {
            System.out.println("القائمة فارغة");
            return;
        }
        Node<T> current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // اختبار القائمة
    public static void main(String[] args) {
        // قائمة تحتوي على أعداد صحيحة
        CircularDoublyLinkedList7<Integer> intList = new CircularDoublyLinkedList7<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);

        System.out.println("القائمة الأصلية (أعداد صحيحة):");
        intList.printList();

        System.out.println("بعد التدوير للأمام:");
        intList.rotate();
        intList.printList();

        System.out.println("بعد التدوير للخلف:");
        intList.rotateBackward();
        intList.printList();

        // قائمة تحتوي على نصوص
        CircularDoublyLinkedList7<String> stringList = new CircularDoublyLinkedList7<>();
        stringList.add("أ");
        stringList.add("ب");
        stringList.add("ج");
        stringList.add("د");

        System.out.println("القائمة الأصلية (نصوص):");
        stringList.printList();

        System.out.println("بعد التدوير للأمام:");
        stringList.rotate();
        stringList.printList();

        System.out.println("بعد التدوير للخلف:");
        stringList.rotateBackward();
        stringList.printList();
    }
}