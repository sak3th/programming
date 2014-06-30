package sorting;

import java.util.Random;

import datastructures.Heap;

public class SortingTests {

    public static void main(String[] args) {
        //int[] input = {2,4,6,8,1,3,5,7};
        int[] input = new int[1000000]; 
        Random rand = new Random();
        for (int i = 0; i < input.length; i++) {
            //input[i] = rand.nextInt(1000000);
            input[i] = i;
            //input[i] = 1000000-i;
        }
        testHeapSort(input);
    }

    static void testHeapSort(int[] input) {
        outln("Testing Heap Sort");
        
        Integer[] arr = null;
        if (input == null) {
            arr = new Integer[10];
            Random rand = new Random(); int t = 20;
            for (int i = 0; i < arr.length; i++, t -= 2) {
                //arr[i] = new Integer(rand.nextInt(30));
                arr[i] = new Integer(t);
            }
        } else {
            arr = new Integer[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = new Integer(input[i]);
            }
        }

        for (int i = 0; i < arr.length; i++) ;//outln("  " + arr[i]);
        long t1 = System.currentTimeMillis();
        Heap<Integer> heap = new Heap<Integer>(arr, arr.length, Heap.Order.DESCENDING);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.remove();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("\nSuccessfully sorted " + arr.length + " elements in " + (t2-t1) + " millis.");
        for (int i = 0; i < arr.length; i++);// outln("  " + arr[i]);
    }
    
    static void out(String str) { System.out.println(str); }
    static void outln(String str) { System.out.println(str); }
}
