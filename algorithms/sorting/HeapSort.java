package sorting;

import java.util.Random;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            array[i] = i+1;
            //array[i] = 20-i;
            //array[i] = random.nextInt(100);
            //array[i] = 2;
        }
        for (int i = 0; i < 20; i++) System.out.print(array[i] + " ");
        System.out.println();
        HeapSort h = new HeapSort(array);
        for (int i = 0; i < 20; i++) array[i] = h.extractMin();
        for (int i = 0; i < 20; i++) System.out.print(array[i] + " ");
    }

    private int size;
    private int arr[];
    HeapSort(int[] array) {
        makeHeap(array);
    }

    private void makeHeap(int[] array) {
        arr = new int[array.length+1];
        size = 0;
        for(int i : array) {
            insert(i);
        }
        /*for (int i = 0; i < array.length; i++) arr[i+1] = array[i];
        size = array.length;
        for (int i = size; i > 0; i--) bubbleDown(i);*/
    }

    private int extractMin() {
        int min = -1;
        if (size > 0) {
            min = arr[1];
            arr[1] = arr[size];
            size--;
            bubbleDown(1);
        }
        return min;
    }

    private void insert(int x) {
        if (size < arr.length) {
            size++;
            arr[size] = x;
            bubbleUp(size);
        }
    }

    private void bubbleUp(int n) {
        if (parent(n) == -1) return;
        if (arr[parent(n)] > arr[n]) {
            swap(arr, n, parent(n));
            bubbleUp(parent(n));
        }
    }

    public void bubbleDown(int n) {
        int c = leftChild(n);
        int minChild = n;
        for (int i = 0; i < 2; i++) {
            if (c + i <= size) {
               if(arr[minChild] > arr[c + i]) minChild = c + i;
            }
        }
        if (minChild != n) {
            swap(arr, n, minChild);
            bubbleDown(minChild);
        }
    }

    public static final int parent(int n) {
        if (n == 1) return -1;
        else return n/2;
    }

    public static final int leftChild(int n) {
        return n*2;
    }

    private static void swap(int[] array, int a, int b) {
        if (a != b) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }
}
