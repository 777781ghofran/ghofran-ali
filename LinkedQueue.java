// السؤال: Create Queue Using Linked Lists
// الترجمة: إنشاء Queue باستخدام القوائم المرتبطة

public class LinkedQueue<E> implements Queue<E> {
    private static class Node<E> {
        E data; // البيانات المخزنة في العقدة
        Node<E> next; // الإشارة إلى العقدة التالية

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> front; // مقدمة الـ Queue
    private Node<E> rear; // نهاية الـ Queue
    private int size = 0; // عدد العناصر في الـ Queue

    @Override
    public boolean isEmpty() {
        return size == 0; // الـ Queue فارغة إذا كان الحجم يساوي 0
    }

    @Override
    public int size() {
        return size; // نُرجع عدد العناصر
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new IllegalStateException("الـ Queue فارغة"); // إذا كانت الـ Queue فارغة، نرمي استثناء
        }
        return front.data; // نُرجع العنصر الموجود في المقدمة
    }

    @Override
    public void enqueue(E e) {
        Node<E> newNode = new Node<>(e); // ننشئ عقدة جديدة
        if (isEmpty()) {
            front = newNode; // إذا كانت الـ Queue فارغة، نضع العقدة في المقدمة
        } else {
            rear.next = newNode; // نربط العقدة الجديدة بنهاية الـ Queue
        }
        rear = newNode; // نجعل العقدة الجديدة هي النهاية
        size++; // نزيد الحجم
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("الـ Queue فارغة"); // إذا كانت الـ Queue فارغة، نرمي استثناء
        }
        E element = front.data; // نحتفظ بالعنصر الموجود في المقدمة
        front = front.next; // نجعل العقدة التالية هي المقدمة
        size--; // ننقص الحجم
        if (isEmpty()) {
            rear = null; // إذا أصبحت الـ Queue فارغة، نجعل النهاية null
        }
        return element; // نُرجع العنصر الذي تمت إزالته
    }

    // طباعة محتويات الـ Queue (لأغراض الاختبار)
    public void printQueue() {
        Node<E> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // اختبار الكود
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("الـ Queue بعد الإضافة:");
        ((LinkedQueue<Integer>) queue).printQueue();

        System.out.println("العنصر الموجود في المقدمة: " + queue.first());

        System.out.println("العنصر الذي تمت إزالته: " + queue.dequeue());
        System.out.println("الـ Queue بعد الإزالة:");
        ((LinkedQueue<Integer>) queue).printQueue();
    }
}