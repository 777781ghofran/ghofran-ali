// السؤال: Create Stack Using Array
// الترجمة: إنشاء Stack باستخدام مصفوفة

public class ArrayStack<E> implements Stack<E> {
    private static final int CAPACITY = 1000; // السعة القصوى للـ Stack
    private E[] data; // مصفوفة لتخزين العناصر
    private int topIndex = -1; // مؤشر لأعلى عنصر في الـ Stack

    public ArrayStack() {
        data = (E[]) new Object[CAPACITY]; // إنشاء مصفوفة بالسعة المحددة
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1; // الـ Stack فارغة إذا كان topIndex يساوي -1
    }

    @Override
    public int size() {
        return topIndex + 1; // عدد العناصر هو topIndex + 1
    }

    @Override
    public E top() {
        if (isEmpty()) {
            throw new IllegalStateException("الـ Stack فارغة"); // إذا كانت الـ Stack فارغة، نرمي استثناء
        }
        return data[topIndex]; // نُرجع العنصر الموجود في أعلى الـ Stack
    }

    @Override
    public void push(E e) {
        if (size() == CAPACITY) {
            throw new IllegalStateException("الـ Stack ممتلئة"); // إذا كانت الـ Stack ممتلئة، نرمي استثناء
        }
        data[++topIndex] = e; // نضيف العنصر إلى أعلى الـ Stack
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("الـ Stack فارغة"); // إذا كانت الـ Stack فارغة، نرمي استثناء
        }
        E element = data[topIndex]; // نحتفظ بالعنصر الموجود في الأعلى
        data[topIndex--] = null; // نُزيل العنصر وننقص topIndex
        return element; // نُرجع العنصر الذي تمت إزالته
    }
}