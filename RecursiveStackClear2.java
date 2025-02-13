// السؤال: Give a recursive method for removing all the elements from a stack.
// الترجمة: قدم طريقة تعتمد على التكرار (Recursive) لإزالة جميع العناصر من الـ Stack.

import java.util.Stack;

public class RecursiveStackClear2 {

    /**
     * طريقة تعتمد على التكرار لإزالة جميع العناصر من الـ Stack.
     * @param stack الـ Stack المراد تفريغه.
     */
    public static <E> void clearStack(Stack<E> stack) {
        // الحالة الأساسية: إذا كان الـ Stack فارغًا، نوقف التكرار
        if (stack.isEmpty()) {
            return;
        }

        // نزيل العنصر الموجود في أعلى الـ Stack
        stack.pop();

        // نستدعي الطريقة نفسها بشكل تكرار (Recursive)
        clearStack(stack);
    }

    public static void main(String[] args) {
        // إنشاء Stack وإضافة عناصر إليه
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // طباعة محتويات الـ Stack قبل التفريغ
        System.out.println("الـ Stack قبل التفريغ: " + stack);

        // تفريغ الـ Stack باستخدام الطريقة التكرارية
        clearStack(stack);

        // طباعة محتويات الـ Stack بعد التفريغ
        System.out.println("الـ Stack بعد التفريغ: " + stack);
    }
}