// السؤال: Implement the clone() method for the ArrayStack class.
// الترجمة: نفذ طريقة clone() لفئة ArrayStack.

import java.util.Arrays;

public class ArayStack4<E> implements Cloneable {
    private static final int DEFAULT_CAPACITY = 10; // السعة الافتراضية للمكدس
    private E[] data; // مصفوفة لتخزين العناصر
    private int topIndex = -1; // مؤشر لأعلى عنصر في المكدس

    // Constructor لإنشاء مكدس بالسعة الافتراضية
    public ArayStack4() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    // Constructor لإنشاء مكدس بسعة محددة
    public ArayStack4(int capacity) {
        data = (E[]) new Object[capacity];
    }

    // إضافة عنصر إلى أعلى المكدس
    public void push(E element) {
        if (topIndex == data.length - 1) {
            resize(); // زيادة سعة المكدس إذا كان ممتلئًا
        }
        data[++topIndex] = element;
    }

    // إزالة العنصر من أعلى المكدس
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("المكدس فارغ");
        }
        E element = data[topIndex];
        data[topIndex--] = null; // إزالة المرجع لتجنب تسرب الذاكرة
        return element;
    }

    // التحقق مما إذا كان المكدس فارغًا
    public boolean isEmpty() {
        return topIndex == -1;
    }

    // الحصول على العنصر الموجود في أعلى المكدس دون إزالته
    public E top() {
        if (isEmpty()) {
            throw new IllegalStateException("المكدس فارغ");
        }
        return data[topIndex];
    }

    // زيادة سعة المكدس
    private void resize() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    /**
     * تنفيذ طريقة clone() لإنشاء نسخة عميقة من المكدس.
     * @return نسخة عميقة من المكدس.
     */
    @Override
    public ArayStack4<E> clone() {
        try {
            // إنشاء نسخة سطحية من الكائن
            ArayStack4<E> clonedStack = (ArayStack4<E>) super.clone();

            // إنشاء نسخة عميقة من المصفوفة
            clonedStack.data = Arrays.copyOf(this.data, this.data.length);

            // إرجاع النسخة العميقة
            return clonedStack;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("لا يمكن استنساخ الكائن", e);
        }
    }

    // طباعة محتويات المكدس (لأغراض الاختبار)
    public void printStack() {
        for (int i = 0; i <= topIndex; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    // اختبار الكود
    public static void main(String[] args) {
        // إنشاء مكدس وإضافة عناصر إليه
        ArayStack4<Integer> stack = new ArayStack4<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // طباعة المكدس الأصلي
        System.out.println("المكدس الأصلي:");
        stack.printStack();

        // إنشاء نسخة من المكدس باستخدام clone()
        ArayStack4<Integer> clonedStack = stack.clone();

        // طباعة النسخة المنسوخة
        System.out.println("النسخة المنسوخة:");
        clonedStack.printStack();

        // التأكد من أن النسخة مستقلة عن الأصل
        stack.push(4); // إضافة عنصر جديد إلى المكدس الأصلي
        System.out.println("المكدس الأصلي بعد الإضافة:");
        stack.printStack();
        System.out.println("النسخة المنسوخة بعد الإضافة:");
        clonedStack.printStack();
    }
}