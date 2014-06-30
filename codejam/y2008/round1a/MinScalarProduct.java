package y2008.round1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MinScalarProduct {

    public static void main(String[] args) {
        String ioFile = "codejam/" + MinScalarProduct.class.getCanonicalName().replace(".", "/");
        minScalarProduct(new File(ioFile + ".in"), new File(ioFile + ".out"));
    }

    public static void minScalarProduct(File in, File out) {
        Scanner sc;
        FileWriter fw;
        BufferedWriter bw;
        try {
            sc = new Scanner(in);
            fw = new FileWriter(out);
            bw = new BufferedWriter(fw);
            int numCases = sc.nextInt();

            for(int i = 0; i < numCases; i++) {
                int length = sc.nextInt();
                long[] vector1 = new long[length];
                Long[] vector2 = new Long[length];
                for(int j = 0; j < length; j++) vector1[j] = sc.nextLong();
                for(int j = 0; j < length; j++) vector2[j] = sc.nextLong();
                Arrays.sort(vector1);
                Arrays.sort(vector2, Collections.reverseOrder());
                long sum = 0;
                for(int j = 0; j < length; j++) sum += (vector1[j] * vector2[j]);
                out(bw, "Case #" + (i+1) + ": " + sum + "\n");
            }

            bw.close(); fw.close(); sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void out(BufferedWriter bw, String str) throws IOException {
        bw.write(str);
        System.out.print(str);
    }
}
