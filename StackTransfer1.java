// السؤال: Implement a method with signature transfer(S, T) that transfers all elements from stack S onto stack T,
// so that the element that starts at the top of S is the first to be inserted onto T,
// and the element at the bottom of S ends up at the top of T.

// الترجمة: نفذ طريقة ذات التوقيع transfer(S, T) تقوم بنقل جميع العناصر من الـ Stack S إلى الـ Stack T،
// بحيث يصبح العنصر الموجود في أعلى S هو أول عنصر يتم إدخاله إلى T،
// والعنصر الموجود في أسفل S يصبح في أعلى T.

import java.util.Stack;

public class StackTransfer1 {

    /**
     * طريقة لنقل العناصر من Stack S إلى Stack T مع عكس الترتيب.
     * @param S الـ Stack المصدر.
     * @param T الـ Stack الهدف.
     */
    public static <E> void transfer(Stack<E> S, Stack<E> T) {
        // ننشئ Stack مؤقتًا لحفظ العناصر أثناء النقل
        Stack<E> tempStack = new Stack<>();

        // ننقل العناصر من S إلى Stack مؤقت
        while (!S.isEmpty()) {
            tempStack.push(S.pop()); // ننقل العنصر من S إلى Stack مؤقت
        }

        // ننقل العناصر من Stack المؤقت إلى T
        while (!tempStack.isEmpty()) {
            T.push(tempStack.pop()); // ننقل العنصر من Stack مؤقت إلى T
        }
    }

    public static void main(String[] args) {
        // إنشاء Stack S وإضافة عناصر إليه
        Stack<Integer> S = new Stack<>();
        S.push(1);
        S.push(2);
        S.push(3);

        // إنشاء Stack T (فارغ في البداية)
        Stack<Integer> T = new Stack<>();

        // طباعة محتويات Stack S قبل النقل
        System.out.println("Stack S قبل النقل: " + S);

        // نقل العناصر من S إلى T
        transfer(S, T);

        // طباعة محتويات Stack S و T بعد النقل
        System.out.println("Stack S بعد النقل: " + S);
        System.out.println("Stack T بعد النقل: " + T);
    }
}