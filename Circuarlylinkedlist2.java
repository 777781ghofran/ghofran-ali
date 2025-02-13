public class Circuarlylinkedlist2 {

        private static class Node {
            int element;       // البيانات داخل العقدة
            Node next;         // الإشارة إلى العقدة التالية

            public Node(int element, Node next) {
                this.element = element;
                this.next = next;
            }
        }

        private Node tail; // الإشارة إلى العقدة الأخيرة (دائرية، tail.next تشير إلى أول عنصر)

        public Circuarlylinkedlist2() {
            tail = null;
        }

        // التحقق إذا كانت القائمة فارغة
        public boolean isEmpty() {
            return tail == null;
        }

        // الدالة التي تحسب الحجم
        public int size() {
            if (isEmpty()) {
                return 0; // إذا كانت القائمة فارغة
            }

            int count = 1; // نبدأ العد بعقدة واحدة على الأقل
            Node current = tail.next; // نبدأ من رأس القائمة

            // اجتياز القائمة الدائرية
            while (current != tail) {
                count++;
                current = current.next; // الانتقال إلى العقدة التالية
            }

            return count; // إعادة العدد الإجمالي للعقد
        }
    public static void main(String[] args) {
        Circuarlylinkedlist2  list = new Circuarlylinkedlist2();
        System.out.println(list.size()); // Output: 0 (القائمة فارغة)

        // إضافة عناصر
        list.tail = new Node(10, null);
        list.tail.next = new Node(20, list.tail);
        list.tail = list.tail.next;

        System.out.println(list.size()); // Output: 2
    }

}


