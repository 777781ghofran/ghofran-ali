import java.util.LinkedList;
import java.util.Queue;

class RoundRobinScheduling5 {



    // تعريف قائمة الانتظار كمتغير عام
    public static Queue<String> queue = new LinkedList<>();

    // تعريف الوحدة الزمنية (Time Quantum) كمتغير عام
    public static int timeQuantum = 2;

    // تعريف العمليات كمتغير عام
    public static String[] processes = {"P1", "P2", "P3", "P4"};

    // دالة لمحاكاة Round Robin Scheduling
    public static void roundRobinScheduling() {
        // إضافة جميع العمليات إلى قائمة الانتظار
        for (String process : processes) {
            queue.add(process);
        }

        // حلقة حتى تصبح قائمة الانتظار فارغة
        while (!queue.isEmpty()) {
            // استخراج العملية من مقدمة قائمة الانتظار
            String currentProcess = queue.poll();

            // طباعة العملية الحالية التي يتم تنفيذها
            System.out.println("جاري تنفيذ العملية: " + currentProcess);

            // محاكاة تنفيذ العملية لمدة الوحدة الزمنية (Time Quantum)
            // هنا نفترض أن كل عملية تحتاج إلى 1 وحدة زمنية للتنفيذ
            // إذا كانت العملية تحتاج إلى وقت أكثر، نعيد إضافتها إلى قائمة الانتظار
            if (timeQuantum > 1) {
                System.out.println("العملية " + currentProcess + " لم تنته بعد، يتم إعادتها إلى قائمة الانتظار.");
                queue.add(currentProcess);
            }

            // تقليل الوحدة الزمنية المتبقية للعملية
            timeQuantum--;
        }

        System.out.println("تم تنفيذ جميع العمليات.");
    }

    // الدالة الرئيسية
    public static void main(String[] args) {
        // استدعاء الدالة لبدء الجدولة
        roundRobinScheduling();
    }
}