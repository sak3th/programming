package y2010.africa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ReverseWords {

    public static void main(String[] args) {
        String ioFile = "CodeJam/" + ReverseWords.class.getCanonicalName().replace(".", "/");
        reverseWords(new File(ioFile + ".in"), new File(ioFile + ".out"));
    }

    public static void reverseWords(File in, File out) {
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
                String line = sc.nextLine();
                String[] words = line.split(" ");
                Stack<String> stack = new Stack<String>();
                for (String word : words) {
                    stack.push(word);
                }
                out(bw, "Case #" + (i + 1) + ":");
                while (!stack.isEmpty()) {
                    out(bw, " " + stack.pop());
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

    static void out(BufferedWriter bw, String str) throws IOException {
        bw.write(str);
        System.out.print(str);
    }
}
