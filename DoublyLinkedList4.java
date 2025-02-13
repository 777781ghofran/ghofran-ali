public class DoublyLinkedList4<T> {
    private class Node {
        T value; // قيمة العقدة
        Node next; // الإشارة إلى العقدة التالية
        Node prev; // الإشارة إلى العقدة السابقة

        Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head; // الرأس: العقدة الأولى في القائمة
    private Node tail; // الذيل: العقدة الأخيرة في القائمة

    public DoublyLinkedList4() {
        this.head = null;
        this.tail = null;
    }

    public void append(T value) {
        /**
         * وظيفة لإضافة عقدة جديدة إلى نهاية القائمة.
         */
        Node newNode = new Node(value);
        if (head == null) { // إذا كانت القائمة فارغة
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // ربط الذيل بالعقدة الجديدة
            newNode.prev = tail; // ربط العقدة الجديدة بالذيل
            tail = newNode;      // تحديث الذيل ليصبح العقدة الجديدة
        }
    }

    public boolean equals(DoublyLinkedList4<T> other) {
        /**
         * مقارنة قائمتين مرتبطتين مزدوجتين لتحديد إذا ما كانتا متساويتين.
         */
        // التحقق من أن الكائن الآخر ليس فارغًا
        if (other == null) {
            return false;
        }

        // البدء من رأس كل قائمة
        Node current1 = this.head;
        Node current2 = other.head;

        // المرور على العقد في القائمتين
        while (current1 != null && current2 != null) {
            if (!current1.value.equals(current2.value)) { // مقارنة القيم في كل عقدة
                return false; // إذا كانت القيم مختلفة، القائمتان غير متساويتين
            }

            current1 = current1.next; // الانتقال إلى العقدة التالية في القائمة الأولى
            current2 = current2.next; // الانتقال إلى العقدة التالية في القائمة الثانية
        }

        // التحقق من أن كلتا القائمتين انتهتا (إذا لم تكونا بنفس الطول)
        if (current1 != null || current2 != null) {
            return false;
        }

        return true; // القائمتان متساويتان
    }

    // أمثلة للاستخدام
    public static void main(String[] args) {
        DoublyLinkedList4<Integer> list1 = new DoublyLinkedList4<>();
        list1.append(1);
        list1.append(2);
        list1.append(3);

        DoublyLinkedList4<Integer> list2 = new DoublyLinkedList4<>();
        list2.append(1);
        list2.append(2);
        list2.append(3);

        DoublyLinkedList4<Integer> list3 = new DoublyLinkedList4<>();
        list3.append(1);
        list3.append(2);

        System.out.println(list1.equals(list2)); // True: القائمتان متساويتان
        System.out.println(list1.equals(list3)); // False: القائمتان غير متساويتين
    }
}

