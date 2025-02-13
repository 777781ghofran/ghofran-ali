// السؤال: Create Stack Using Linked Lists
// الترجمة: إنشاء Stack باستخدام القوائم المرتبطة

public class LinkedStack<E> implements Stack<E> {
    private static class Node<E> {
        E data; // البيانات المخزنة في العقدة
        Node<E> next; // الإشارة إلى العقدة التالية

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> top; // أعلى الـ Stack
    private int size; // عدد العناصر في الـ Stack

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0; // الـ Stack فارغة إذا كان الحجم يساوي 0
    }

    @Override
    public int size() {
        return size; // نُرجع عدد العناصر
    }

    @Override
    public E top() {
        if (isEmpty()) {
            throw new IllegalStateException("الـ Stack فارغة"); // إذا كانت الـ Stack فارغة، نرمي استثناء
        }
        return top.data; // نُرجع العنصر الموجود في أعلى الـ Stack
    }

    @Override
    public void push(E e) {
        Node<E> newNode = new Node<>(e); // ننشئ عقدة جديدة
        newNode.next = top; // نربط العقدة الجديدة بأعلى الـ Stack
        top = newNode; // نجعل العقدة الجديدة هي أعلى الـ Stack
        size++; // نزيد الحجم
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("الـ Stack فارغة"); // إذا كانت الـ Stack فارغة، نرمي استثناء
        }
        E element = top.data; // نحتفظ بالعنصر الموجود في الأعلى
        top = top.next; // نجعل العقدة التالية هي أعلى الـ Stack
        size--; // ننقص الحجم
        return element; // نُرجع العنصر الذي تمت إزالته
    }
}