package sorting;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            //arr[i] = i+1;
            //arr[i] = 20-i;
            arr[i] = random.nextInt(100);
            //arr[i] = 2;
        }
        for (int i = 0; i < 20; i++) System.out.print(arr[i] + " ");
        System.out.println();
        sort(arr, 0, arr.length-1);
        for (int i = 0; i < 20; i++) System.out.print(arr[i] + " ");
    }

    public static void sort(int[] arr, int l, int h) {
        if (h - l > 0) {
            int p = partition(arr, l, h);
            sort(arr, l, p-1);
            sort(arr, p+1, h);
        }
    }

    private static int partition(int[] arr, int l, int h) {
        int p = h;
        int firstHigh = l;
        for(int i = l; i < h; i++) {
            if (arr[i] < arr[p]) {
                swap(arr, i, firstHigh);
                firstHigh++;
            }
        }
        swap(arr, firstHigh, p);
        return firstHigh;
    }

    private static void swap(int[] arr, int a, int b) {
        if (a != b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
