package datastructures;

public class Queue<E> {
    Link<E> head;
    Link<E> tail;
    int size;

    void add(E e) {
        Link<E> l = new Link<E>(e, null);
        if (head == null) head = l;
        else tail.next = l;
        tail = l;
        size++;
    }

    E remove() {
        E e = null;
        if (head != null) {
            e = head.data;
            head = head.next;
            size--;
            if (size == 0) tail = null;
        }
        return e;
    }
}
