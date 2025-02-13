import java.util.Scanner;

public class ArrayBounds14 {
    public static void main(String[] args) {
        int arry[] = {11, 12, 13, 14, 15};
        System.out.println("input index to print negative number to exit");
        Scanner input = new Scanner(System.in);
        int y = input.nextInt();

            try {
                System.out.println("arry[y]");
            } catch (Exception e) {
                System.out.println("dont try buffer overflow attacks in java!");
            }
        }
    }

