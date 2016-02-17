package datastructures;

import java.util.Arrays;
import java.util.Random;

public class DataStructuresTests {


    public static void main(String[] args) {
        //testStack();
        //testQueue();
        //testHeapSort();
        int[] a = new int[10];
        for (int i = 0; i < 10; a[i] = i++);
        System.out.println(Arrays.toString(a));
        new PQ().swap(2, 3, a);
        System.out.println(Arrays.toString(a));
    }

    static void testStack() {
        outln("Testing stack");
        Stack<Integer> s = new Stack<Integer>();
        for (int i= 1; i < 15; i++) s.push(new Integer(i));
        for (int i= 1; i < 20; i++) outln("  " + s.pop());
        //for (int i= 1; i < 15; i++) s.push(new Integer(i));
        //for (int i= 1; i < 20; i++) outln("  " + s.pop());
    }

    static void testQueue() {
        outln("Testing queue");
        Queue<Integer> q = new Queue<Integer>();
        for (int i= 1; i < 15; i++) q.add(new Integer(i));
        for (int i= 1; i < 20; i++) outln("  " + q.remove());
        //for (int i= 1; i < 15; i++) q.add(new Integer(i));
        //for (int i= 1; i < 20; i++) outln("  " + q.remove());
    }
    
    static void testHeapSort() {
        outln("Testing Heap Sort");
        Integer[] arr = new Integer[10];
        Random rand = new Random(); int t = 20;
        for (int i = 0; i < arr.length; i++, t -= 2) {
            //arr[i] = new Integer(rand.nextInt(30));
            arr[i] = new Integer(t);
        }
        for (int i = 0; i < arr.length; i++) outln("  " + arr[i]);
        Heap<Integer> heap = new Heap<Integer>(arr, arr.length, Heap.Order.DESCENDING);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.remove();
        }
        outln("Sorted");
        for (int i = 0; i < arr.length; i++) outln("  " + arr[i]);
    }
    
    static void out(String str) { System.out.println(str); }
    static void outln(String str) { System.out.println(str); }
}

class PQ {
    //int[] a = new int[10];
    //PQ() { for (int i = 0; i < 10; a[i] = i++); }
    int[] swap(int p, int q, int[] a) { int tmp = a[p]; a[p] = a[q]; a[q] = tmp; return a; }
    //@Override public String toString() { return Arrays.toString(a); }
}