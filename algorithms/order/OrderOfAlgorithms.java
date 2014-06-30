package order;

public class OrderOfAlgorithms {

    public static void main(String[] args) {
        long records = 100000;

        /*long nBefore = System.currentTimeMillis();
        testNLogN(records);
        long nAfter = System.currentTimeMillis();
        log("testN - " + (nAfter - nBefore));

        long n2Before = System.currentTimeMillis();
        testN2(records);
        long n2After = System.currentTimeMillis();
        log("testN2 - " + (n2After - n2Before));
        long n2AfterAfter = System.currentTimeMillis();
        log("testN2 - " + (n2AfterAfter - n2After));*/
        
        smallestArea();
    }

    static void testN(long records) {
        for (long l = 0; l < records; l++)
            operation();
    }

    static void testN2(long records) {
        for (long l = 0; l < records; l++)
            for (long m = 0; m < records; m++)
                operation();
    }

    static void testNLogN(long records) {
        for (long l = 0; l < records; l++)
            for (long m = 1; m <= records; m *= 2)
                operation();
    }

    static void operation() {
        float f = 12345 * 22354;
        return;
    }

    static void log(String str) {
        System.out.println(str);
    }
    
    
    static void smallestArea() {
        int[][] docMap = new int[10][2];
        int[] wordMap = new int[3];
        
        int[] minWordMap = new int[wordMap.length];
        int[] position = new int[wordMap.length];
        int minWords = 0, area = Integer.MAX_VALUE;

        for (int i = 0; i < docMap.length; i++) {
            minWordMap[docMap[i][0]]++;
            if(minWordMap[docMap[i][0]] == wordMap[docMap[i][0]]) minWords++;
            
        }

    }
    

}
