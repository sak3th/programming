package misc;

import java.util.Random;

public class CellsAndStrips {

    public static void main(String[] args) {
        int[] arr = new int[20];
        //int[] dpCurr = new int[20];
        Random rand = new Random();
        for (int i = 0; i < 20; i++) arr[i] = 1+rand.nextInt(3);

        int prev = -1, dpPrev = 0, dpCurr = -1; boolean insideStrip = false;
        int hStrips = 0, hStripTot = 0, cell = 0;
        for (int i = 0; i < 20; i++) {
            if (arr[i] != prev) {
                dpCurr = 1;
            } else {
                dpCurr = dpPrev + 1;
                if (dpCurr == 2) hStrips++;
                hStripTot++;
            }
            prev = arr[i];
            dpPrev = dpCurr;
        }
        for (int i = 0; i < 20; i++) System.out.print(arr[i] + " "); System.out.println();
        //for (int i = 0; i < 20; i++) System.out.print(dpCurr[i] + " "); System.out.println();
        System.out.println("H Strips : " + hStrips);
        System.out.println("Cells : " + (arr.length-(hStrips+hStripTot)));
    }
}
