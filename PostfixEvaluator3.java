import java.util.Stack;

public class PostfixEvaluator3 {

    /**
     * طريقة لتقييم تعبير مكتوب بتدوين Postfix.
     * @param expression التعبير المكتوب بتدوين Postfix.
     * @return الناتج النهائي للتعبير.
     */
    public static int evaluatePostfix(String expression) {
        // ننشئ مكدسًا لتخزين الأرقام
        Stack<Integer> stack = new Stack<>();

        // ننشئ مصفوفة من العناصر بتقسيم التعبير باستخدام المسافات
        String[] tokens = expression.split(" ");

        // نمر على كل عنصر في التعبير
        for (String token : tokens) {
            // إذا كان العنصر رقمًا، نضعه في المكدس
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            }
            // إذا كان العنصر عملية حسابية، ننفذ العملية
            else {
                int operand2 = stack.pop(); // نخرج الرقم الثاني
                int operand1 = stack.pop(); // نخرج الرقم الأول
                int result = applyOperation(token, operand1, operand2); // ننفذ العملية
                stack.push(result); // نضع النتيجة في المكدس
            }
        }

        // الناتج النهائي هو العنصر الوحيد المتبقي في المكدس
        return stack.pop();
    }

    /**
     * طريقة للتحقق مما إذا كان العنصر رقمًا.
     * @param token العنصر المراد التحقق منه.
     * @return true إذا كان العنصر رقمًا، وإلا false.
     */
    private static boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * طريقة لتطبيق العملية الحسابية.
     * @param operator العملية الحسابية (مثل +، -، *، /).
     * @param operand1 الرقم الأول.
     * @param operand2 الرقم الثاني.
     * @return نتيجة العملية الحسابية.
     */
    private static int applyOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("عملية غير صالحة: " + operator);
        }
    }

    public static void main(String[] args) {
        // مثال لتعبير مكتوب بتدوين Postfix
        String expression = "5 2 + 8 3 - * 4 /";

        // تقييم التعبير وطباعة الناتج
        int result = evaluatePostfix(expression);
        System.out.println("نتيجة التعبير: " + result);
    }
}