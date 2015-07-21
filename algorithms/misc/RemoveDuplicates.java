package misc;


import java.util.Arrays;

/* Given an array of sorted numbers remove duplicates and fill empty slots with -1*/
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr =  {1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 7, 7};
        arr = solve(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] solve(int[] arr) {
        int last = arr[0],  dups = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == last) {
                dups++;
            }
            last = arr[i];
            if (dups > 0) {
                arr[i - dups] = arr[i];
                arr[i] = -1;
            }
        }
        return arr;
    }
}

