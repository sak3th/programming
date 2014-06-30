package sorting;

import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            arr[i] = i+1;
            //arr[i] = 20-i;
            //arr[i] = random.nextInt(100);
            //arr[i] = 2;
        }
        for (int i = 0; i < 20; i++) System.out.print(arr[i] + " ");
        System.out.println();
        sort(arr, 0, arr.length-1);
        for (int i = 0; i < 20; i++) System.out.print(arr[i] + " ");
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high)/2;
            sort(arr, low, mid);
            sort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] lArr = new int[mid-low+1];
        int[] rArr = new int[high-(mid+1)+1];
        for (int i = 0; i < lArr.length; i++) lArr[i] = arr[low+i];
        for (int i = 0; i < rArr.length; i++) rArr[i] = arr[mid+1+i];
        int lIndex = 0, rIndex = 0;
        for (int i = low; i <=high; i++) {
            if (lIndex < lArr.length && rIndex < rArr.length) {
                if (lArr[lIndex] < rArr[rIndex]) arr[i] = lArr[lIndex++];
                else arr[i] = rArr[rIndex++];
            } else {
                if (lIndex < lArr.length) arr[i] = lArr[lIndex++];
                else arr[i] = rArr[rIndex++];
            }
        }
    }
}
