package y2008.round1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveTheUniverse {

    public static void main(String[] args) {
        String ioFile = "codejam/" + SaveTheUniverse.class.getCanonicalName().replace(".", "/");
        saveTheUniverse(new File(ioFile + ".in"), new File(ioFile + ".out"));
    }

    public static void saveTheUniverse(File in, File out) {
        Scanner sc;
        FileWriter fw;
        BufferedWriter bw;
        try {
            sc = new Scanner(in);
            fw = new FileWriter(out);
            bw = new BufferedWriter(fw);
            int numCases = sc.nextInt();

            for (int i = 0; i < numCases; i++) {
                int numServers = sc.nextInt();
                String[] servers = new String[numServers];
                sc.nextLine();
                for (int j = 0; j < numServers; j++) servers[j] = sc.nextLine();
                int numQueries = sc.nextInt();
                String[] queries = new String[numQueries];
                sc.nextLine();
                for (int j = 0; j < numQueries; j++) queries[j] = sc.nextLine();
                for (int j = 0; j < numServers; j++) out(bw, servers[j] + " ");
                out(bw, "\n");
                for (int j = 0; j < numQueries; j++) out(bw, queries[j] + " ");
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
