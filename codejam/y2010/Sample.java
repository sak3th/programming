package y2010;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sample {

    public static void main(String[] args) {
        String ioFile = "codejam/" + Sample.class.getCanonicalName().replace(".", "/");
        solution(new File(ioFile + ".in"), new File(ioFile + ".out"));
    }

    public static void solution(File in, File out) {
        Scanner sc; FileWriter fw; BufferedWriter bw;
        try {
            sc = new Scanner(in); fw = new FileWriter(out); bw = new BufferedWriter(fw);
            int cases = sc.nextInt();

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
