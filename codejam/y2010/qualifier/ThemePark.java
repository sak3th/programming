package y2010.qualifier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ThemePark {

    public static void main(String[] args) {
        String ioFile = "CodeJam/" + ThemePark.class.getCanonicalName().replace(".", "/");
        maxRevenue(new File(ioFile + ".in"), new File(ioFile + ".out"));
    }

    public static void maxRevenue(File in, File out) {
        Scanner sc; FileWriter fw; BufferedWriter bw;
        try {
            sc = new Scanner(in); fw = new FileWriter(out); bw = new BufferedWriter(fw);

            int cases = sc.nextInt();
            for (int cas = 0; cas < cases; cas++) {
                long R = sc.nextLong(), K = sc.nextLong();
                short N = sc.nextShort();
                long[] groups = new long[N];
                for (short n = 0; n < N; n++) {
                    groups[n] = sc.nextLong();
                }

                long revenue = 0; int head = 0;
                long[] groupRevCache = new long[N];
                long[] revCache = new long[N];
                long[] rCache = new long[N];
                int[] headCache = new int[N];
                for (long r = 0; r < R; r++) {
                    long k = 0; short groupCount = 0;
                    if (groupRevCache[head] == 0) {
                        int headCopy = head;
                        while ((groups[head] + k <= K) && (groupCount + 1 <= N)) {
                            k = k + groups[head++];
                            if (head == N) head = 0;
                            groupCount++;
                        }
                        revenue += k;
                        groupRevCache[headCopy] = k;
                        revCache[headCopy] = revenue;
                        headCache[headCopy] = head;
                        rCache[headCopy] = r;
                    } else {
                        if (false) {
                            // calculate based on groupRevCache
                            revenue += groupRevCache[head];
                            head = headCache[head];
                        } else {
                            // calculate based on cycles and groupRevCache
                            long rRemaining = R - r;
                            long cycle = r - rCache[head];
                            long quo = rRemaining / cycle, rem = rRemaining % cycle;

                            long remRevenue = 0;
                            int rr = 0;
                            if (rem > 0) {
                                while (rr++ < rem) {
                                    remRevenue += groupRevCache[head];
                                    head = headCache[head];
                                }
                                revenue += remRevenue;
                                rr--;
                            }

                            if (quo > 0) {
                                long cycleRevenue = remRevenue;
                                while (rr++ < cycle) {
                                    cycleRevenue += groupRevCache[head];
                                    head = headCache[head];
                                }
                                revenue += (cycleRevenue * quo);
                            }
                            break;
                        }
                    }
                }

                out(bw, "Case #" + (cas + 1) + ": " + revenue + "\n");
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