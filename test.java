public class test {
    public static void main(String[] args) {
        // اختبار Stack باستخدام Array
        Stack<Integer> arrayStack = new ArrayStack<>();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println("ArrayStack - Top: " + arrayStack.top()); // 3
        System.out.println("ArrayStack - Pop: " + arrayStack.pop()); // 3
        System.out.println("ArrayStack - Size: " + arrayStack.size()); // 2

        // اختبار Stack باستخدام Linked List
        Stack<String> linkedStack = new LinkedStack<>();
        linkedStack.push("أ");
        linkedStack.push("ب");
        linkedStack.push("ج");
        System.out.println("LinkedStack - Top: " + linkedStack.top()); // ج
        System.out.println("LinkedStack - Pop: " + linkedStack.pop()); // ج
        System.out.println("LinkedStack - Size: " + linkedStack.size()); // 2
    }
}