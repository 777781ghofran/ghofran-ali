// السؤال: Implement the clone() method for the DoublyLinkedList class.
// الترجمة: نفذ طريقة clone() لفئة DoublyLinkedList.

// تعريف العقدة باستخدام Generics
  class node<T> {
    T data; // البيانات من النوع العام
    Node<T> next; // العقدة التالية
    Node<T> prev; // العقدة السابقة

    public node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// تعريف القائمة المرتبطة المزدوجة باستخدام Generics
public class DoublyLinkedList8<T> {
    private Node<T> head; // رأس القائمة
    private Node<T> tail; // ذيل القائمة

    // إضافة عنصر في نهاية القائمة
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // طباعة القائمة
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // تنفيذ طريقة clone() لإنشاء نسخة عميقة من القائمة
    public DoublyLinkedList8<T> clone() {
        // إنشاء قائمة جديدة
        DoublyLinkedList8<T> newList = new DoublyLinkedList8<>();
        Node<T> current = head;

        // تمر على القائمة الأصلية وإنشاء عقد جديدة بنفس البيانات
        while (current != null) {
            newList.add(current.data); // إضافة البيانات إلى القائمة الجديدة
            current = current.next;
        }

        return newList; // إرجاع القائمة الجديدة
    }

    // اختبار القائمة
    public static void main(String[] args) {
        // إنشاء قائمة أصلية
        DoublyLinkedList8<Integer> originalList = new DoublyLinkedList8<>();
        originalList.add(1);
        originalList.add(2);
        originalList.add(3);
        originalList.add(4);

        System.out.println("القائمة الأصلية:");
        originalList.printList();

        // إنشاء نسخة من القائمة الأصلية
        DoublyLinkedList8<Integer> clonedList = originalList.clone();

        System.out.println("القائمة المنسوخة:");
        clonedList.printList();

        // التأكد من أن القائمة المنسوخة مستقلة عن الأصلية
        System.out.println("إضافة عنصر جديد إلى القائمة الأصلية:");
        originalList.add(5);
        System.out.println("القائمة الأصلية بعد الإضافة:");
        originalList.printList();
        System.out.println("القائمة المنسوخة بعد الإضافة:");
        clonedList.printList();
    }
}