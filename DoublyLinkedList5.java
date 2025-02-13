public class DoublyLinkedList5<T> {
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

    public DoublyLinkedList5() {
        this.head = new Node(null); // الرأس (عقدة الحارس)
        this.tail = new Node(null); // الذيل (عقدة الحارس)
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void append(T value) {
        /**
         * وظيفة لإضافة عقدة جديدة إلى نهاية القائمة.
         */
        Node newNode = new Node(value);
        newNode.prev = tail.prev; // ربط العقدة الجديدة بالعقدة السابقة للذيل
        newNode.next = tail;      // ربط العقدة الجديدة بالذيل
        tail.prev.next = newNode; // تحديث الإشارة للعقدة السابقة للذيل
        tail.prev = newNode;      // تحديث الإشارة الخلفية للذيل
    }

    public boolean equals(DoublyLinkedList5<T> other) {
        /**
         * مقارنة قائمتين مرتبطتين مزدوجتين لتحديد إذا ما كانتا متساويتين.
         */
        // التحقق من أن الكائن الآخر ليس فارغًا
        if (other == null) {
            return false;
        }

        // البدء من رأس كل قائمة
        Node current1 = this.head.next;
        Node current2 = other.head.next;

        // المرور على العقد في القائمتين
        while (current1 != this.tail && current2 != other.tail) {
            if (!current1.value.equals(current2.value)) { // مقارنة القيم في كل عقدة
                return false; // إذا كانت القيم مختلفة، القائمتان غير متساويتين
            }

            current1 = current1.next; // الانتقال إلى العقدة التالية في القائمة الأولى
            current2 = current2.next; // الانتقال إلى العقدة التالية في القائمة الثانية
        }

        // التحقق من أن كلتا القائمتين انتهتا (إذا لم تكونا بنفس الطول)
        if (current1 != this.tail || current2 != other.tail) {
            return false;
        }

        return true; // القائمتان متساويتان
    }

    public void concatenate(DoublyLinkedList5<T> other) {
        /**
         * دمج قائمتين مرتبطتين مزدوجتين مع وجود عقدتي حارس (header وtrailer).
         */
        if (other == null || other.head.next == other.tail) {
            return; // إذا كانت القائمة الأخرى فارغة، لا حاجة للدمج
        }

        // ربط الذيل الحالي برأس القائمة الأخرى (بعد الحارس)
        this.tail.prev.next = other.head.next;
        other.head.next.prev = this.tail.prev;

        // تحديث الذيل ليشير إلى الذيل الآخر
        this.tail = other.tail;

        // إعادة تعيين القائمة الأخرى لتصبح فارغة
        other.head.next = other.tail;
        other.tail.prev = other.head;
    }

    // أمثلة للاستخدام
    public static void main(String[] args) {
        DoublyLinkedList5<Integer> list1 = new DoublyLinkedList5<>();
        list1.append(1);
        list1.append(2);
        list1.append(3);

        DoublyLinkedList5<Integer> list2 = new DoublyLinkedList5<>();
        list2.append(4);
        list2.append(5);
        list2.append(6);

        list1.concatenate(list2);

        DoublyLinkedList5<Integer> list3 = new DoublyLinkedList5<>();
        list3.append(1);
        list3.append(2);
        list3.append(3);
        list3.append(4);
        list3.append(5);
        list3.append(6);

        System.out.println(list1.equals(list3)); // True: القائمتان متساويتان
    }
}
