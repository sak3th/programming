package misc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
 *
 * The old song declares "Go ahead and hate your neighbor", and the residents of Onetinville have
 * taken those words to heart. Every resident hates his next-door neighbors on both sides. Nobody is
 * willing to live farther away from the town's well than his neighbors, so the town has been
 * arranged in a big circle around the well. Unfortunately, the town's well is in disrepair and
 * needs to be restored. You have been hired to collect donations for the Save Our Well fund.

 * Each of the town's residents is willing to donate a certain amount, as specified in the
 * int[] donations, which is listed in clockwise order around the well. However, nobody is willing
 * to contribute to a fund to which his neighbor has also contributed. Next-door neighbors are
 * always listed consecutively in donations, except that the first and last entries in donations are
 * also for next-door neighbors. You must calculate and return the maximum amount of donations that
 * can be collected.
 */
public class BadNeighbors {

    public static void main(String[] args) {
        String ioFile = "topcoder/" + BadNeighbors.class.getCanonicalName().replace(".", "/");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ioFile + ".in"));
            String testCase = reader.readLine();
            while (testCase != null) {
                String[] numbers = testCase.split(" ");
                int[] sequence = new int[numbers.length];
                for (int i = 0; i < sequence.length; i++) {
                    sequence[i] = Integer.parseInt(numbers[i]);
                }
                int expected = Integer.parseInt(reader.readLine());
                long before = System.currentTimeMillis();
                int result = maxDonations(sequence);
                if (result == expected) {
                    System.out.println("Passed " + (System.currentTimeMillis()-before) + " millis");
                } else {
                    System.out.println("Failed " + result + "(" + expected + ")");
                }
                testCase = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int maxDonations(int[] donations) {
        int[][] maxCache = new int[2][donations.length];
        for (int i = 0; i < donations.length; i++) {
            maxCache[0][i] = maxCache[1][i] = donations[i];
        }
        for (int i = 1; i < donations.length; i++) {
            for (int j = 1; j < i - 1; j++) {
                maxCache[0][i] = Math.max(maxCache[0][i], maxCache[0][j] + donations[i]);
            }
        }
        for (int i = 1; i < donations.length-1; i++) {
            for (int j = 0; j < i - 1; j++) {
                maxCache[1][i] = Math.max(maxCache[1][i], maxCache[1][j] + donations[i]);
            }
        }
        int max = maxCache[0][0];
        for (int i = 0; i < donations.length; i++) {
            max = Math.max(max, maxCache[0][i]);
            max = Math.max(max, maxCache[1][i]);
        }
        return max;
    }
}
