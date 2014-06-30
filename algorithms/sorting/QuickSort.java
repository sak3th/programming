package sorting;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            //array[i] = i+1;
            //array[i] = 20-i;
            //array[i] = random.nextInt(100);
            array[i] = 2;
        }
        for (int i = 0; i < 20; i++) System.out.print(array[i] + " ");
        System.out.println();
        sort(array, 0, array.length-1);
        for (int i = 0; i < 20; i++) System.out.print(array[i] + " ");
    }

    public static void sort(int[] array, int l, int h) {
        if (h - l > 0) {
            int p = partition(array, l, h);
            sort(array, l, p-1);
            sort(array, p+1, h);
        }
    }

    private static int partition(int[] array, int l, int h) {
        int p = h;
        int firstHigh = l;
        for(int i = l; i < h; i++) {
            if (array[i] < array[p]) {
                swap(array, i, firstHigh);
                firstHigh++;
            }
        }
        swap(array, firstHigh, p);
        return p;
    }

    private static void swap(int[] array, int a, int b) {
        if (a != b) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }
}
