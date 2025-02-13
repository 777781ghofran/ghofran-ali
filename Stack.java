// السؤال: Create Stack Interface
// الترجمة: إنشاء واجهة Stack

public interface Stack<E> {
    boolean isEmpty(); // التحقق مما إذا كانت الـ Stack فارغة
    int size(); // الحصول على عدد العناصر في الـ Stack
    E top(); // الحصول على العنصر الموجود في أعلى الـ Stack
    void push(E e); // إضافة عنصر جديد إلى أعلى الـ Stack
    E pop(); // إزالة العنصر الموجود في أعلى الـ Stack
}