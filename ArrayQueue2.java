// السؤال: Implement the clone() method for the ArrayQueue class.
// الترجمة: نفذ طريقة clone() لفئة ArrayQueue.

import java.util.Arrays;

public class ArrayQueue2<E> implements Queue<E>, Cloneable {
    private static final int DEFAULT_CAPACITY = 10; // السعة الافتراضية للـ Queue
    private E[] data; // مصفوفة لتخزين العناصر
    private int front = 0; // مؤشر لمقدمة الـ Queue
    private int size = 0; // عدد العناصر في الـ Queue

    // Constructor لإنشاء Queue بالسعة الافتراضية
    public ArrayQueue2() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    // Constructor لإنشاء Queue بسعة محددة
    public ArrayQueue2(int capacity) {
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
     * طريقة clone() لإنشاء نسخة عميقة من الـ Queue.
     * @return نسخة عميقة من الـ Queue.
     */
    @Override
    public ArrayQueue2<E> clone() {
        try {
            // إنشاء نسخة سطحية من الكائن
            ArrayQueue2<E> clonedQueue = (ArrayQueue2<E>) super.clone();

            // إنشاء نسخة عميقة من المصفوفة
            clonedQueue.data = Arrays.copyOf(this.data, this.data.length);

            // إرجاع النسخة العميقة
            return clonedQueue;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("لا يمكن استنساخ الكائن", e);
        }
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
        ArrayQueue2<Integer> queue = new ArrayQueue2<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("الـ Queue الأصلي:");
        queue.printQueue();

        // إنشاء نسخة من الـ Queue باستخدام clone()
        ArrayQueue2<Integer> clonedQueue = queue.clone();

        System.out.println("النسخة المنسوخة من الـ Queue:");
        clonedQueue.printQueue();

        // التأكد من أن النسخة مستقلة عن الأصل
        queue.enqueue(4); // إضافة عنصر جديد إلى الـ Queue الأصلي
        System.out.println("الـ Queue الأصلي بعد الإضافة:");
        queue.printQueue();
        System.out.println("النسخة المنسوخة بعد الإضافة:");
        clonedQueue.printQueue();
    }
}