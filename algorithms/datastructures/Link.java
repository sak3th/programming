package datastructures;

public class Link<E> {
    public Link(E data, Link<E> next) {
        this.data = data;
        this.next = next;
    }

    E data;
    Link<E> next, prev;
}
