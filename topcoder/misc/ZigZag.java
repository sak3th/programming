package misc;

import java.io.*;
import java.util.Arrays;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493
 *
 * A sequence of numbers is called a zig-zag sequence if the differences between successive numbers
 * strictly alternate between positive and negative. The first difference (if one exists) may be
 * either positive or negative. A sequence with fewer than two elements is trivially a zig-zag
 * sequence.
 *
 * For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) are
 * alternately positive and negative. In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag
 * sequences, the first because its first two differences are positive and the second because
 * its last difference is zero.

 * Given a sequence of integers, sequence, return the length of the longest subsequence of sequence
 * that is a zig-zag sequence. A subsequence is obtained by deleting some number of
 * elements (possibly zero) from the original sequence, leaving the remaining elements in their
 * original order.
 */
public class ZigZag {

    public static void main(String[] args) {
        String ioFile = "topcoder/" + ZigZag.class.getCanonicalName().replace(".", "/");
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
                int result = longestZigZag(sequence);
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

    static int longestZigZag(int[] sequence) {
        if (sequence.length < 2) return sequence.length;
        int[] lzz = new int[sequence.length];
        Arrays.fill(lzz, 1);
        for (int i = 1; i < sequence.length; i++) {
            Difference iDiff = diff(i - 1, i, sequence);
            for (int j = 0; j < i; j++) {
                Difference jDiff = diff(j - 1, j, sequence);
                if (alternates(jDiff, iDiff) && lzz[i] < lzz[j] + 1) {
                    lzz[i] = lzz[j] + 1;
                }
            }
        }

        int longest = 1;
        for (int i = 0; i < sequence.length; i++) {
            if (longest < lzz[i]) longest = lzz[i];
        }
        return longest;
    }

    enum Difference { DOES_NOT_EXIST, POSITIVE, NEGATIVE, ZERO };

    static Difference diff(int a, int b, int[] arr) {
        if (a < 0 || a > arr.length || b < 0 || b > arr.length) return Difference.DOES_NOT_EXIST;
        if ((arr[b] - arr[a]) > 0) return Difference.POSITIVE;
        else if ((arr[b] - arr[a]) < 0) return Difference.NEGATIVE;
        else return Difference.ZERO;
    }

    static boolean alternates(Difference a, Difference b) {
        if (a == Difference.ZERO || b == Difference.ZERO) return false;
        if (a == Difference.POSITIVE && b != Difference.POSITIVE) return true;
        if (a == Difference.NEGATIVE && b != Difference.NEGATIVE) return true;
        if (a == Difference.DOES_NOT_EXIST && b != Difference.DOES_NOT_EXIST) return true;
        return false;
    }
}
