public class FibonacciProgression6 {
    private long prev;
    private long current;

    public FibonacciProgression6(long first,long second){
        prev = first;
        current = second;

    }
    public long nextValue(){
        long next = prev + current;
        prev = current;
        current = next;
        return prev;
    }
    public  long getNthValue(int n){
        for (int i = 2; i < n ; i++) {
            nextValue();
        }
            return current;

    }

    public static void main(String[] args) {
        FibonacciProgression6 fib = new FibonacciProgression6(2,2);
        long result = fib.getNthValue(8);
        System.out.println("القيمة الثامنة هي:" + result);
    }
}
