// السؤال: Implement a method with signature concatenate(LinkedQueue Q2) for the LinkedQueue class that takes all elements of Q2 and appends them to the end of the original queue.
// الترجمة: نفذ طريقة ذات التوقيع concatenate(LinkedQueue Q2) لفئة LinkedQueue تأخذ جميع عناصر Q2 وتلحقها بنهاية الـ Queue الأصلي.

public class LinkedQueue3<E> implements Queue<E> {
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

    /**
     * طريقة concatenate() لإلحاق جميع عناصر Q2 بنهاية الـ Queue الأصلي.
     * @param Q2 الـ Queue الذي سيتم نقل عناصره.
     */
    public void concatenate(LinkedQueue3<E> Q2) {
        if (Q2.isEmpty()) {
            return; // إذا كانت Q2 فارغة، لا نحتاج لفعل أي شيء
        }

        if (this.isEmpty()) {
            // إذا كانت الـ Queue الأصلي فارغة، نجعل مقدمة ونهاية الـ Queue الأصلي يشيران إلى مقدمة ونهاية Q2
            this.front = Q2.front;
        } else {
            // نربط نهاية الـ Queue الأصلي بمقدمة Q2
            this.rear.next = Q2.front;
        }

        // نجعل نهاية الـ Queue الأصلي تشير إلى نهاية Q2
        this.rear = Q2.rear;

        // نزيد حجم الـ Queue الأصلي بحجم Q2
        this.size += Q2.size;

        // نجعل Q2 فارغة
        Q2.front = null;
        Q2.rear = null;
        Q2.size = 0;
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
        LinkedQueue3<Integer> queue1 = new LinkedQueue3<>();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        LinkedQueue3<Integer> queue2 = new LinkedQueue3<>();
        queue2.enqueue(4);
        queue2.enqueue(5);
        queue2.enqueue(6);

        System.out.println("الـ Queue الأصلي قبل الإلحاق:");
        queue1.printQueue();

        System.out.println("الـ Queue Q2 قبل الإلحاق:");
        queue2.printQueue();

        // إلحاق عناصر Q2 بالـ Queue الأصلي
        queue1.concatenate(queue2);

        System.out.println("الـ Queue الأصلي بعد الإلحاق:");
        queue1.printQueue();

        System.out.println("الـ Queue Q2 بعد الإلحاق:");
        queue2.printQueue();
    }
}