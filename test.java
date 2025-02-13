public class test {
    public static void main(String[] args) {
        // اختبار Queue باستخدام Array
        Queue<Integer> arrayQueue = new ArrayQueue1<>();
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        System.out.println("ArrayQueue - العنصر الموجود في المقدمة: " + arrayQueue.first()); // 1
        System.out.println("ArrayQueue - العنصر الذي تمت إزالته: " + arrayQueue.dequeue()); // 1
        System.out.println("ArrayQueue - الحجم: " + arrayQueue.size()); // 2

        // اختبار Queue باستخدام Linked List
        Queue<String> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue("أ");
        linkedQueue.enqueue("ب");
        linkedQueue.enqueue("ج");
        System.out.println("LinkedQueue - العنصر الموجود في المقدمة: " + linkedQueue.first()); // أ
        System.out.println("LinkedQueue - العنصر الذي تمت إزالته: " + linkedQueue.dequeue()); // أ
        System.out.println("LinkedQueue - الحجم: " + linkedQueue.size()); // 2
    }
}