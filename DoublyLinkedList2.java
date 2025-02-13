public class DoublyLinkedList2<T> {
    // Node class (inner class)
    private static class Node<T> {
        T data; // البيانات المخزنة في العقدة
        Node<T> prev; // مؤشر إلى العقدة السابقة
        Node<T> next; // مؤشر إلى العقدة التالية

        // Constructor لإنشاء عقدة جديدة
        public Node(T data) {
            this.data = data;
            this.prev = null; // العقدة السابقة تُهيأ بقيمة null
            this.next = null; // العقدة التالية تُهيأ بقيمة null
        }
    }

    // خصائص القائمة المزدوجة
    private Node<T> header; // عقدة وهمية (sentinel) في بداية القائمة
    private Node<T> trailer; // عقدة وهمية (sentinel) في نهاية القائمة

    // Constructor لتهيئة القائمة المزدوجة
    public DoublyLinkedList2() {
        header = new Node<>(null); // إنشاء العقدة الوهمية في البداية
        trailer = new Node<>(null); // إنشاء العقدة الوهمية في النهاية
        header.next = trailer; // ربط العقدة الوهمية في البداية بالعقدة الوهمية في النهاية
        trailer.prev = header; // ربط العقدة الوهمية في النهاية بالعقدة الوهمية في البداية
    }

    // Method لحساب حجم القائمة (عدد العقد)
    public int size() {
        int count = 0; // تهيئة عداد لحساب عدد العقد
        Node<T> current = header.next; // بدء المؤشر من العقدة الأولى بعد الـ header

        // التكرار عبر القائمة حتى نصل إلى العقدة الوهمية في النهاية (trailer)
        while (current != trailer) {
            count++; // زيادة العداد بمقدار 1
            current = current.next; // تحريك المؤشر إلى العقدة التالية
        }

        return count; // إرجاع العدد الكلي للعقد
    }

    // يمكن إضافة طرق أخرى هنا مثل addFirst, addLast, isEmpty, إلخ...

    // Main method لاختبار الكود
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(); // إنشاء قائمة جديدة
        list.addLast(10); // إضافة عنصر 10 في النهاية
        list.addLast(20); // إضافة عنصر 20 في النهاية
        list.addLast(30); // إضافة عنصر 30 في النهاية

        // طباعة حجم القائمة
        System.out.println("Size of the list: " + list.size()); // الإخراج: 3
    }

    private void addLast(T i) {
    }
}
