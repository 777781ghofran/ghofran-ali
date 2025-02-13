public class singlylinkedlist3<T> {
    private Node<T> head; // الرأس

    // تعريف عقدة القائمة.
    private static class Node<T> {
        T data;        // البيانات المخزنة في العقدة.
        Node<T> next;  // المؤشر إلى العقدة التالية.

        Node(T data) { // منشئ العقدة.
            this.data = data;
            this.next = null;
        }
    }

    // إضافة عنصر إلى نهاية القائمة.
    public void add(T data) {
        if (head == null) {
            head = new Node<>(data); // إذا كانت القائمة فارغة، اجعل الرأس يشير إلى العقدة الجديدة.
        } else {
            Node<T> current = head; // ابدأ من الرأس.
            while (current.next != null) { // ابحث عن العقدة الأخيرة.
                current = current.next;
            }
            current.next = new Node<>(data); // أضف العقدة الجديدة.
        }
    }

    // دالة لحساب حجم القائمة.
    public int size() {
        int count = 0; // عداد العقد.
        Node<T> current = head; // ابدأ من الرأس.
        while (current != null) { // استمر حتى تصل إلى نهاية القائمة.
            count++; // ازدياد العداد لكل عقدة.
            current = current.next; // انتقل إلى العقدة التالية.
        }
        return count; // أعد الحجم.
    }

    // الدالة الرئيسية لاختبار الكود.
    public static void main(String[] args) {
        singlylinkedlist3<Integer> list = new singlylinkedlist3<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Size of the list: " + list.size()); // الحجم: 4
        list.add(5);
        System.out.println("Size of the list after adding one element: " + list.size()); // الحجم: 5
    }
}
