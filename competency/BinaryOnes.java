/**
 * Given a number N, find the number of ones up to N in the array of concatenated
 * natural numbers (1,2,3,4...) converted to their binary representations (1,10,11,100...)
 *
 * Example 1
 *   N = 5
 *   concatenated array [1,10,11] till length 5
 *   num of ones is 4
 *
 * Example 2
 *   N = 7
 *   concatenated array [1,10,11,10] till length 7
 *   natural number 3(100) truncated after length 7
 *   num of ones is 5
 */
public class BinaryOnes {
    public static void main(String[] args) {
        int cases = 100;
        for (int c = 1; c <= cases; c++) outln("Case "+ c + ": " + solve(c));
    }

    static int solve(int pos) {
        int num = 1, numOnes = 0;
        char[] binaryNum = null;
        while (pos > 0) {
            binaryNum = toBinary(num++);
            for (char c : binaryNum) {
                if (c == '1') numOnes++;
                pos--;
            }
        }
        return numOnes;
    }

    static char[] toBinary(int num) {
        int charPos = (int) (Math.log(num) / log2 + 1);
        char[] binary = new char[charPos];
        do {
            binary[--charPos] = digits[(num & 1)];
            num >>>= 1;
        } while (num != 0);
        return binary;
    }

    final static double log2 = Math.log(2);
    final static char[] digits = { '0' , '1' };

    private static void out(String str) { System.out.print(str);}
    private static void outln(String str) { System.out.println(str);}
}
