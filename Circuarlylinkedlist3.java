public class Circuarlylinkedlist3 {
        private static class Node {
            int element;       // البيانات داخل العقدة
            Node next;         // الإشارة إلى العقدة التالية

            public Node(int element, Node next) {
                this.element = element;
                this.next = next;
            }
        }

        private Node tail; // الإشارة إلى العقدة الأخيرة

        public Circuarlylinkedlist3() {
            tail = null;
        }

        public boolean isEmpty() {
            return tail == null;
        }

        public int size() {
            if (isEmpty()) return 0;

            int count = 1;
            Node current = tail.next;
            while (current != tail) {
                count++;
                current = current.next;
            }
            return count;
        }

        // دالة equals لمقارنة قائمتين دائريتين
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true; // إذا كانت القائمتان نفس الكائن
            if (!(obj instanceof CircularlyLinkedList)) return false; // إذا لم يكن obj قائمة دائرية

            Circuarlylinkedlist3 other = (Circuarlylinkedlist3) obj;

            // إذا كانت الأحجام مختلفة، القائمتان غير متساويتين
            if (this.size() != other.size()) return false;

            // اجتياز القائمة الحالية والقائمة الأخرى ومقارنة العناصر
            Node currentA = this.tail == null ? null : this.tail.next;
            Node currentB = other.tail == null ? null : other.tail.next;

            for (int i = 0; i < this.size(); i++) {
                if (currentA.element != currentB.element) return false; // إذا كانت القيم مختلفة
                currentA = currentA.next;
                currentB = currentB.next;
            }

            return true; // القائمتان متساويتان
        }
    public static void main(String[] args) {
        Circuarlylinkedlist3 list1 = new Circuarlylinkedlist3();
        Circuarlylinkedlist3 list2 = new Circuarlylinkedlist3();

        // اختبار القائمتين الفارغتين
        System.out.println(list1.equals(list2)); // Output: true

        // إضافة عناصر إلى list1
        list1.tail = new Circuarlylinkedlist3.Node(10, null);
        list1.tail.next = new Circuarlylinkedlist3.Node(20, list1.tail);
        list1.tail = list1.tail.next;

        // إضافة نفس العناصر إلى list2
        list2.tail = new Circuarlylinkedlist3.Node(10, null);
        list2.tail.next = new Circuarlylinkedlist3.Node(20, list2.tail);
        list2.tail = list2.tail.next;

        // اختبار القائمتين المتماثلتين
        System.out.println(list1.equals(list2)); // Output: true

        // إضافة عنصر مختلف إلى list2
        list2.tail.next = new Circuarlylinkedlist3.Node(30, list2.tail.next);
        list2.tail = list2.tail.next;

        // اختبار القائمتين غير المتساويتين
        System.out.println(list1.equals(list2)); // Output: false
    }

}


