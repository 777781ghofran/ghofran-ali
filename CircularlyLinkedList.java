public class CircularlyLinkedList<E> {
    private static  class Node<E>{
        private E element;
        private Node<E>next;

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
    private Node<E>tail=null;
    private int size=0;
    public CircularlyLinkedList(){}

    public int size(){return size;}
    public boolean isEmpty()
    {
        return size==0;
    }
    public E first(){
        if (isEmpty())return null;
        return tail.getNext().getElement();
    }
    public E last(){
        if (isEmpty())return null;
        return tail.getElement();
    }
    public void rotate(){
        if (tail!=null)
            tail=tail.next;
    }
    public void addfirst(E e){
        if (size==0)
        {
            tail = new Node<>(e,null);
            tail.setNext(tail);
        }
        else {
            Node<E>n = new Node<>(e,tail.next);
            tail.setNext(n);
        }
        size++;
    }
    public void addlast(E e){
        addfirst(e);
        tail=tail.next;
    }
    public E removeFirst(){
        if (isEmpty())return null;
        Node<E>x=tail.next;
        if (x==tail)
            tail=null;
        else
        tail.setNext(x.getNext());
        size--;
        return x.element;
    }
    public String getAll(){
        if (isEmpty())return "" ;

        String all="";
        Node<E>x=tail.next;
        for (int i = 0; i < size; i++) {
            all=all+x.element+"";
            x=x.next;

        }
        return all;
    }

}


