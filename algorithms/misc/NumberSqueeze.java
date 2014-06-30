package misc;

import java.util.Random;
import java.util.Stack;

public class NumberSqueeze {

    public static void main(String[] args) {
        int[] input = new int[100];
        Random random = new Random();
        for (int i = 0; i < input.length; i++) {
            input[i] = random.nextInt(9) + 1;
        }
        for (int number : input) System.out.print(number + " "); System.out.println();
        for (int number : squeezeStack(input)) System.out.print(number + " "); System.out.println();
        for (int i = 0; i < squeeze(input); i++) System.out.print(input[i] + " "); System.out.println();
    }

    /**
     * Shrinks {@code a} such that no two adjacent elements are equal.
     * @param a The array to be squeezed.
     * @return The length of the squeezed array<br/>-1 if input is invalid.
     */
    public static int squeeze(int[] a) {
        if (a == null) return -1;
        if (a.length <= 1) return a.length;
        int[] stack = new int[a.length];
        int length = -1;
        int top = -1;

        for (int num : a) {
            if (num == top) {
                length--;
                if (length <= -1) {
                    top = length = -1;
                } else {
                    top = stack[length];
                }
            } else {
                length++;
                stack[length] = num;
                top = num;
            }
        }

        for (int i = 0; i < a.length; i++) a[i] = (i <= length)? stack[i] : 0;

        return length+1;
    }

    static int[] squeezeStack(int[] a) {
        if (a == null) return null;
        Stack<Integer> stack = new Stack<Integer>();
        for (int n : a) {
            if (stack.size() > 0 && n == stack.peek()) stack.pop();
            else stack.push(n);
        }
        int[] out = new int[stack.size()];
        for (int i = out.length-1; i >= 0; i--) out[i] = stack.pop();
        return out;
    }

    static void toBinary() {

    }
}
