package misc;


public class Premutation {

    public static void main(String[] args) {
        long one = System.currentTimeMillis();
        PrintPermutation("aabb".toCharArray(), 0);
        long two = System.currentTimeMillis();
        printPermute("aabb".toCharArray(), 0);
        long three = System.currentTimeMillis();
        for(int i=0; i<3628800;) i++;
        long four = System.currentTimeMillis();
        System.out.println((two-one) + ", " + (three-two) + ", " + (four-three));
    }

    static void printPermute(char arr[], int start) {
        int end = arr.length-1;
        if(start == end) {
            System.out.println(new String(arr).hashCode());
            return;
        }

        printPermute(arr, start+1);

        for(int i=start+1; i<=end; i++) {
            swop(arr, start, i);
            printPermute(arr, start+1);
            swop(arr, start, i); // revert to original
        }
    }

    static void swop(char[] inputs, int a, int b) {
        char temp = inputs[a];
        inputs[a] = inputs[b];
        inputs[b] = temp;
    }

    static double factorial(int n) {
        double ret = 1;
        for (int i = 1; i <= n; ++i) ret *= (double)i;
        return ret;
    }

    //define method header
    //notice currentFocus is the key to keep track of the current status
    public static void PrintPermutation(char[] inputs, int currentFocus)
    {
        //before start, check if currentFocus comes to the last char
        if(currentFocus==inputs.length-1)
        {
            System.out.println(new String(inputs));
            return;
        }

        //now firstly keep the current char order in the array and proceed to next
        PrintPermutation(inputs, currentFocus+1);

        //now need swap each next char with currentFocus
        for(int i=currentFocus+1; i<inputs.length; i++)
        {
            //swap the char pair of position (currentFocus, i)
            //in order to remove the duplicates, the key is to check if the two char unequal before swapping!
            boolean ifAppear = false;
            for(int j=0; j<i;j++)
            {
                if(inputs[j]==inputs[i])
                {
                    ifAppear = true;
                    break;
                }
            }

            if(ifAppear)
                continue;
            Swap(inputs,currentFocus, i);
            PrintPermutation(inputs, currentFocus+1);
            Swap(inputs,currentFocus, i);
        }
    }

    private static void Swap(char[] inputs, int a, int b)
    {
        char temp = inputs[a];
        inputs[a] = inputs[b];
        inputs[b] = temp;
    }
}
