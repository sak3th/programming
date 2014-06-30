package datastructures;

public class Heap<E extends Comparable<E>> extends PriorityQueue<E> {
    public enum Order { ASCENDING, DESCENDING; };

    E[] data;
    int order;

    Heap(E[] data, int length) {
        this(data, length, Order.ASCENDING);
    }

    @SuppressWarnings("unchecked")
    public Heap(E[] e, int length, Order o) {
        data = (E[])new Comparable[length];
        order = (o == Order.ASCENDING) ? 1 : -1;
        /* O(nlogn) */
        for (int i = 0; i < length; i++) insert(e[i]);
        /* O(2n) optimization using only bubble down */
        /*
        size = length;
        for (int i = 0; i < length; i++) data[i] = e[i];
        for (int i = (size/2-1); i >= 0; i--) bubbleDown(i);
        */
    }

    /* log(n) operation */
    @Override
    public void insert(E e) {
        if (size >= data.length) {
            // TODO add error handling
        } else {
            data[size] = e;
            bubbleUp(size);
            size++;
        }
    }

    /* log(n) operation */
    private void bubbleUp(int index) {
        int pIndex = parent(index);
        if (pIndex == -1) return;
        if ((data[pIndex].compareTo(data[index]) * order) > 0) { /* read as p > data[index] */
            swap(index, pIndex);
            bubbleUp(pIndex);
        }
    }

    /* log(n) operation */
    private void bubbleDown(int index) {
        int cIndex = firstChild(index);
        if (cIndex == -1) return;
        int minIndex = index;
        minIndex = ((data[index].compareTo(data[cIndex]) * order) < 0) ? index : cIndex;
        if(cIndex + 1 < size) {
            minIndex = ((data[minIndex].compareTo(data[cIndex + 1]) * order) < 0) ? 
                            minIndex : cIndex+1;
        }
        
         if (minIndex != index) {
             swap(index, minIndex);
             bubbleDown(minIndex);
         }
    }
    
    private int parent(int n) {
        return ((n+1)/2 - 1);
    }

    private int firstChild(int n) {
        if ((2*n + 1) < size) return (2*n + 1);
        else return -1;
    }
    
    private void swap(int a, int b) {
        E t = data[a];
        data[a] = data[b];
        data[b] = t;
    }

    @Override
    public E top() {
        E e = null;
        if(size > 0) e = data[0];
        return e;
    }

    @Override
    public E remove() {
        E e = null;
        if(size > 0) {
            e = data[0];
            data[0] = data[size - 1];
            size--;
            bubbleDown(0);
        }
        return e;
    }
}
