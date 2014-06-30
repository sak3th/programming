package y2010.qualifier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SnapperChain {

    public static void main(String[] args)  {
        String ioFile = "codejam/" + SnapperChain.class.getCanonicalName().replace(".", "/");
        solution(new File(ioFile + ".in"), new File(ioFile + ".out"));
        //System.out.println("" + (-2%2));
    }

    public static void solution(File in, File out) {
        Scanner sc; FileWriter fw; BufferedWriter bw;
        try {
            sc = new Scanner(in); fw = new FileWriter(out); bw = new BufferedWriter(fw);
            int cases = sc.nextInt();
            
            for (int cas = 0; cas < cases; cas++) {
                int N = sc.nextInt();
                long K = sc.nextLong();
                
                long twoPowerN = (long) Math.pow(2, N);
                long nOnAt =  twoPowerN - 1;
                
                State s = State.OFF;
                if (K >= nOnAt && (K - nOnAt) % twoPowerN == 0) s = State.ON;
                
                out(bw, "Case #" + (cas+1) + ": " + s);
            }

            bw.close(); fw.close(); sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static enum State { OFF, ON }

    static void out(BufferedWriter bw, String str) throws IOException {
        str = str + "\n";
        bw.write(str);
        System.out.print(str);
    }
}