import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        CircularlyLinkedList<String>l=new CircularlyLinkedList<>();
        Scanner in = new Scanner(System.in);
        int choice;
        while (true)
        {

            System.out.println("1 add first 2 add last 3 rotate 4 remove first 5 size 6 isEmpty -1 exit");
            System.out.println("input your choise:");
            in.nextInt();
            choice= in.nextInt();
            switch (choice)
            {
                case 1:
                  System.out.println("input your element");
                  l.addfirst(in.next());
                    System.out.println(l.first()+"was added sucessfully");
                    break;
                case 2:
                    System.out.println("input your element");
                    l.addlast(in.next());
                    System.out.println(l.last()+"was added sucessfully");
                    break;
                case 3:
                    l.rotate();
                    System.out.println("list elemnet were rotated");
                    break;
                case 4:
                    System.out.println(l.removeFirst()+"was removed ");
                    break;
                case 5:
                    System.out.println("list size is" +l.size());
                case 6:

                    System.out.println("is the list empty?"+l.isEmpty());
                    break;
                case -1:
                    System.out.println("Good bye");
                    System.exit(0);
            }
            System.out.println("list element are :"+l.getAll());

        }

    }
}
