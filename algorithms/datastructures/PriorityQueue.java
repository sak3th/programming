package datastructures;

public abstract class PriorityQueue<E> {
    int size = 0;

    abstract void insert(E e);

    abstract E top();

    abstract E remove();
}
