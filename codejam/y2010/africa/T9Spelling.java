package y2010.africa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class T9Spelling {

    public static void main(String[] args) {
        String ioFile = "CodeJam/" + T9Spelling.class.getCanonicalName().replace(".", "/");
        t9Spelling(new File(ioFile + ".in"), new File(ioFile + ".out"));
    }

    public static void t9Spelling(File in, File out) {
        Scanner sc;
        FileWriter fw;
        BufferedWriter bw;
        try {
            sc = new Scanner(in);
            fw = new FileWriter(out);
            bw = new BufferedWriter(fw);
            int numCases = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < numCases; i++) {
                char[] line = sc.nextLine().toCharArray();
                out(bw,"Case #" + (i + 1) + ": " + t9(line[0]));
                for (int j = 1; j < line.length; j++) {
                    if (t9(line[j]).charAt(0) == t9(line[j - 1]).charAt(0)) {
                        out(bw, " ");
                    }
                    out(bw, t9(line[j]));
                }
                out(bw, "\n");
            }

            bw.close();
            fw.close();
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String t9(char c) {
        switch (c) {
            case (int) 'a':
                return "2";
            case (int) 'b':
                return "22";
            case (int) 'c':
                return "222";

            case (int) 'd':
                return "3";
            case (int) 'e':
                return "33";
            case (int) 'f':
                return "333";

            case (int) 'g':
                return "4";
            case (int) 'h':
                return "44";
            case (int) 'i':
                return "444";

            case (int) 'j':
                return "5";
            case (int) 'k':
                return "55";
            case (int) 'l':
                return "555";

            case (int) 'm':
                return "6";
            case (int) 'n':
                return "66";
            case (int) 'o':
                return "666";

            case (int) 'p':
                return "7";
            case (int) 'q':
                return "77";
            case (int) 'r':
                return "777";
            case (int) 's':
                return "7777";

            case (int) 't':
                return "8";
            case (int) 'u':
                return "88";
            case (int) 'v':
                return "888";

            case (int) 'w':
                return "9";
            case (int) 'x':
                return "99";
            case (int) 'y':
                return "999";
            case (int) 'z':
                return "9999";

            case (int) ' ':
                return "0";
        }
        return null;
    }

    static void out(BufferedWriter bw, String str) throws IOException {
        bw.write(str);
        System.out.print(str);
    }
}
