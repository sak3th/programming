package misc;

import java.util.Arrays;

public class DoorFlips {

    public static void main(String[] args) {
        int[] arr = new int[101];
        Arrays.fill(arr, -1);
        for (int i = 1; i <= 100; i++) {
            //System.out.print(i + ": ");
            for(int j = 1; j*i<=100; j++) {
                //System.out.print(j*i + " ");
                arr[j*i] *= -1;
            }
            //System.out.println();
        }
        int open = 0;
        for (int i = 1; i <= 100; i++) {
            //System.out.print("[" + i + " " +arr[i]+"] ");
            if (arr[i] == 1) open++;
        }
        //System.out.println();
        System.out.println(open);
    }
}
