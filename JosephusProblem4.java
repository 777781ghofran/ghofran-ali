// السؤال: Use a queue to solve the Josephus Problem.
// الترجمة: استخدم Queue لحل مشكلة جوزيفوس.

import java.util.LinkedList;
import java.util.Queue;

public class JosephusProblem4 {

    /**
     * طريقة لحل مشكلة جوزيفوس باستخدام Queue.
     * @param n عدد الأشخاص.
     * @param k الخطوة (عدد العد قبل الإخراج).
     * @return الشخص الذي سيبقى في النهاية.
     */
    public static int solveJosephus(int n, int k) {
        // ننشئ Queue لتخزين الأشخاص
        Queue<Integer> queue = new LinkedList<>();

        // نضيف جميع الأشخاص إلى الـ Queue
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // نستمر حتى يبقى شخص واحد فقط في الـ Queue
        while (queue.size() > 1) {
            // نمر على الأشخاص من 1 إلى k-1 وننقلهم إلى نهاية الـ Queue
            for (int i = 1; i < k; i++) {
                queue.add(queue.remove());
            }
            // نخرج الشخص رقم k من الـ Queue
            queue.remove();
        }

        // نُرجع الشخص الذي بقي في الـ Queue
        return queue.remove();
    }

    public static void main(String[] args) {
        int n = 7; // عدد الأشخاص
        int k = 3; // الخطوة (عدد العد قبل الإخراج)

        // حل مشكلة جوزيفوس
        int survivor = solveJosephus(n, k);

        // طباعة النتيجة
        System.out.println("الشخص الذي سيبقى في النهاية هو: " + survivor);
    }
}