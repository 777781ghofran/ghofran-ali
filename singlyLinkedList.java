  public class singlyLinkedList<E> {
      public int size;

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

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public singlyLinkedList() {
    }

    public int size() {
        return size;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }


    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    public void addLast(E e)
    {
        Node<E>newest= new Node<>(e,null);
        if (size==0)
            head=newest;
        else
            tail.setNext(newest);
        tail= tail.next;
        size++;
}
public E removeFirst()
{
    if (isEmpty())return null;
    E deleted = head.element;
    head=head.next;
    size--;
    
    
    
    
    if (size==0)
        tail=null;
    return deleted;
}
public String getAll()
{
    String all="";
    Node<E>p=head;
    while (p!=null)
    {
        all=all+p.element+"   ";
        p=p.next;
    }
    return all;
}



}
