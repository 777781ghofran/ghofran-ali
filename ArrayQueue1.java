// السؤال: Augment the ArrayQueue implementation with a new rotate() method having semantics identical to the combination, enqueue(dequeue()).
// الترجمة: قم بتحسين تنفيذ ArrayQueue بإضافة طريقة جديدة rotate() لها نفس دلالات الجمع بين enqueue(dequeue()).

public class ArrayQueue1<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 10; // السعة الافتراضية للـ Queue
    private E[] data; // مصفوفة لتخزين العناصر
    private int front = 0; // مؤشر لمقدمة الـ Queue
    private int size = 0; // عدد العناصر في الـ Queue

    // Constructor لإنشاء Queue بالسعة الافتراضية
    public ArrayQueue1() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    // Constructor لإنشاء Queue بسعة محددة
    public ArrayQueue1(int capacity) {
        data = (E[]) new Object[capacity];
    }

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
        return data[front]; // نُرجع العنصر الموجود في المقدمة
    }

    @Override
    public void enqueue(E e) {
        if (size == data.length) {
            throw new IllegalStateException("الـ Queue ممتلئة"); // إذا كانت الـ Queue ممتلئة، نرمي استثناء
        }
        int rear = (front + size) % data.length; // حساب مؤشر النهاية
        data[rear] = e; // إضافة العنصر إلى النهاية
        size++; // زيادة الحجم
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("الـ Queue فارغة"); // إذا كانت الـ Queue فارغة، نرمي استثناء
        }
        E element = data[front]; // نحتفظ بالعنصر الموجود في المقدمة
        data[front] = null; // نُزيل العنصر
        front = (front + 1) % data.length; // تحديث مؤشر المقدمة
        size--; // نقص الحجم
        return element; // نُرجع العنصر الذي تمت إزالته
    }

    /**
     * طريقة rotate() لتدوير عناصر الـ Queue.
     * يتم نقل العنصر الموجود في المقدمة إلى النهاية.
     */
    public void rotate() {
        if (isEmpty()) {
            throw new IllegalStateException("الـ Queue فارغة"); // إذا كانت الـ Queue فارغة، نرمي استثناء
        }
        E element = data[front]; // نحتفظ بالعنصر الموجود في المقدمة
        data[front] = null; // نُزيل العنصر من المقدمة
        front = (front + 1) % data.length; // تحديث مؤشر المقدمة
        int rear = (front + size - 1) % data.length; // حساب مؤشر النهاية
        data[rear] = element; // نضع العنصر في النهاية
    }

    // طباعة محتويات الـ Queue (لأغراض الاختبار)
    public void printQueue() {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % data.length;
            System.out.print(data[index] + " ");
        }
        System.out.println();
    }

    // اختبار الكود
    public static void main(String[] args) {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("الـ Queue قبل التدوير:");
        queue.printQueue();

        // تدوير الـ Queue
        queue.rotate();

        System.out.println("الـ Queue بعد التدوير:");
        queue.printQueue();
    }
}