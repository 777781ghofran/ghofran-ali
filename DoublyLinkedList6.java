// السؤال:
// قم بإعادة تنفيذ صف DoublyLinkedList بحيث يعتمد على عقدة حارس واحدة فقط تحمي كلا طرفي القائمة (البداية والنهاية) بدلاً من استخدام عقدتي حارس.
// الترجمة:
// Reimplement the DoublyLinkedList class using only one sentinel node that guards both ends of the list instead of two.

public class DoublyLinkedList6<T> {
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

    private Node sentinel; // عقدة حارس واحدة لحماية كلا الطرفين

    public DoublyLinkedList6() {
        // إنشاء عقدة الحارس وربطها بنفسها
        this.sentinel = new Node(null);
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
    }

    public void append(T value) {
        /**
         * وظيفة لإضافة عقدة جديدة إلى نهاية القائمة.
         */
        Node newNode = new Node(value);
        newNode.prev = sentinel.prev; // ربط العقدة الجديدة بالعقدة السابقة للحارس
        newNode.next = sentinel;      // ربط العقدة الجديدة بالحارس
        sentinel.prev.next = newNode; // تحديث الإشارة للعقدة السابقة للحارس
        sentinel.prev = newNode;      // تحديث الإشارة الخلفية للحارس
    }

    public boolean equals(DoublyLinkedList6<T> other) {
        /**
         * مقارنة قائمتين مرتبطتين مزدوجتين لتحديد إذا ما كانتا متساويتين.
         */
        // التحقق من أن الكائن الآخر ليس فارغًا
        if (other == null) {
            return false;
        }

        // البدء من أول عقدة فعلية في كل قائمة
        Node current1 = this.sentinel.next;
        Node current2 = other.sentinel.next;

        // المرور على العقد في القائمتين
        while (current1 != this.sentinel && current2 != other.sentinel) {
            if (!current1.value.equals(current2.value)) { // مقارنة القيم في كل عقدة
                return false; // إذا كانت القيم مختلفة، القائمتان غير متساويتين
            }

            current1 = current1.next; // الانتقال إلى العقدة التالية في القائمة الأولى
            current2 = current2.next; // الانتقال إلى العقدة التالية في القائمة الثانية
        }

        // التحقق من أن كلتا القائمتين انتهتا (إذا لم تكونا بنفس الطول)
        if (current1 != this.sentinel || current2 != other.sentinel) {
            return false;
        }

        return true; // القائمتان متساويتان
    }

    public void concatenate(DoublyLinkedList6<T> other) {
        /**
         * دمج قائمتين مرتبطتين مزدوجتين مع وجود عقدة حارس واحدة.
         */
        if (other == null || other.sentinel.next == other.sentinel) {
            return; // إذا كانت القائمة الأخرى فارغة، لا حاجة للدمج
        }

        // ربط الذيل الحالي برأس القائمة الأخرى (بعد الحارس)
        this.sentinel.prev.next = other.sentinel.next;
        other.sentinel.next.prev = this.sentinel.prev;

        // تحديث الحارس ليشير إلى الذيل الآخر
        this.sentinel.prev = other.sentinel.prev;
        other.sentinel.prev.next = this.sentinel;

        // إعادة تعيين القائمة الأخرى لتصبح فارغة
        other.sentinel.next = other.sentinel;
        other.sentinel.prev = other.sentinel;
    }

    // أمثلة للاستخدام
    public static void main(String[] args) {
        DoublyLinkedList6<Integer> list1 = new DoublyLinkedList6<>();
        list1.append(1);
        list1.append(2);
        list1.append(3);

        DoublyLinkedList6<Integer> list2 = new DoublyLinkedList6<>();
        list2.append(4);
        list2.append(5);
        list2.append(6);

        list1.concatenate(list2);

        DoublyLinkedList6<Integer> list3 = new DoublyLinkedList6<>();
        list3.append(1);
        list3.append(2);
        list3.append(3);
        list3.append(4);
        list3.append(5);
        list3.append(6);

        System.out.println(list1.equals(list3)); // True: القائمتان متساويتان
    }
}
