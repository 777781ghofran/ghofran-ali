public class Main {
    public static void main(String[] args) {
        PositionalLinkedList<String> list = new PositionalLinkedList<>();

        // Add elements
        Position<String> p1 = list.addFirst("A");
        Position<String> p2 = list.addLast("C");
        Position<String> p3 = list.addBefore(p2, "B");

        // Iterate over elements
        System.out.println("Elements:");
        for (String element : list) {
            System.out.println(element);
        }

        // Remove an element
        list.remove(p3);

        // Iterate over positions
        System.out.println("Positions:");
        for (Position<String> p : list.positions()) {
            System.out.println(p.getElement());
        }
    }
}