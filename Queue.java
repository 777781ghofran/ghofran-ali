// السؤال: Create Queue Interface
// الترجمة: إنشاء واجهة Queue

public interface Queue<E> {
    /**
     * التحقق مما إذا كانت الـ Queue فارغة.
     * @return true إذا كانت الـ Queue فارغة، وإلا false.
     */
    boolean isEmpty();

    /**
     * الحصول على عدد العناصر في الـ Queue.
     * @return عدد العناصر في الـ Queue.
     */
    int size();

    /**
     * الحصول على العنصر الموجود في مقدمة الـ Queue دون إزالته.
     * @return العنصر الموجود في مقدمة الـ Queue.
     * @throws IllegalStateException إذا كانت الـ Queue فارغة.
     */
    E first();

    /**
     * إضافة عنصر جديد إلى نهاية الـ Queue.
     * @param e العنصر المراد إضافته.
     * @throws IllegalStateException إذا كانت الـ Queue ممتلئة (في حالة استخدام Array).
     */
    void enqueue(E e);

    /**
     * إزالة العنصر الموجود في مقدمة الـ Queue وإرجاعه.
     * @return العنصر الذي تمت إزالته.
     * @throws IllegalStateException إذا كانت الـ Queue فارغة.
     */
    E dequeue();
}