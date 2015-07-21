package datastructures;

public class Stack<E> {
    private Link<E> head;
    private int size;

    void push(E e) {
        Link<E> l = new Link(e, head);
        head = l;
        size++;
    }

    E pop() {
        E e = null;
        if (head != null) {
            e = head.data;
            head = head.next;
            size--;
        }
        return e;
    }

}