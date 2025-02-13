public class Circuarlylinkedlist1<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public Circuarlylinkedlist1() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }


    public void addfirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> tmp = new Node<>(e, tail.next);
            tail.setNext(tmp);
        }
        size++;
    }

    public void addlast(E e) {
        addfirst(e);
        tail = tail.next;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> head = tail.next;
        if (head== tail)
            tail = null;
        else
            tail.setNext(head.getNext());
        size--;
        return head.element;
    }
}
