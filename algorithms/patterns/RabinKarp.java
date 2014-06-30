package patterns;

// Problem : Substring pattern matching
// Input   : A text string t of length n and a pattern string p of length m
// Output  : Does t contain the pattern p as a substring, and if so where?

public class RabinKarp {
    // this runs in O(n*m)
    // it can be made into a O(n+m) algorithm by using a clever trick
    // hash value of next sub string from t can be calculated from previous
    // hash value, at the cost of few constant order operations
    static int findMatch(char[] p, char[] t) {
        if(p.length < 1) return -1;
        if(p.length >= t.length) return -1;

        int base=31; double basePower=Math.pow(base, (p.length-1));
        String tStr = new String(t);

        double pHash = hashCode(p,base);
        double tSubHash = hashCode(tStr.substring(0, p.length).toCharArray(), base);

        for(int i=0; i<=t.length-p.length; i++) {
            int j=0;
            while(j<p.length && pHash==tSubHash) j++;
            if(j==p.length) return i;
            //tSubHash = hashCode(tStr.substring(i+1, i+1+p.length).toCharArray(), base); // O(m)
            if(i+p.length >= t.length) return -1;
            tSubHash = ((tSubHash - ((double)t[i] * basePower)) * base) + (double)t[i+p.length]; // O(1)
        }

        return -1;
    }

    static long hashCode(char[] text, long base) {
        long hash = 0;
        for(int i=0; i<text.length; i++)
            hash += ((long)text[i] * (long)Math.pow(base, (text.length-1)-i));
        return hash;
    }

    // djb2 hash function
    static long hash(char[] text) {
        long hash = 5381;
        for (int j=0;j<text.length;j++)
            hash = ((hash << 5) + hash) + (long)text[j] ; // hash * 33 + c
        return hash;
    }

    public static void main(String[] args) {
        String text = "sdafkjahsdkfjhasdhfaksdjflkajsdlfkjasld;jfa;lskdjf;lajsdfl;kj"
                +"sdfasdfasdfasdfasdfasdfasdfasdfasdfkjhasdlkfas;ldj  asdfasd"
                +"asdfasdfasdfasdfasdfasdfasdfa asdfasdfa adfa sdfasdfqwe2asd"
                +"dfasdfasdfasdfkajsd;flkasd;lkfasldjfkashdfkljhas;fadsklfjsdf"
                +"sdfasdfasdfasdfasdfasdfasdfasdfasdfkjhasdlkfas;ldj  asdfasd"
                +"asdfasdfasdfasdfasdfasdfasdfa asdfasdfa adfa sdfasdfqwe2asd"
                +"dfasdfasdfasdfkajsd;flkasd;lkfasldjfkashdfkljhas;fadsklfjsdf"
                +"sdfasdfasdfasdfasdfasdfasdfasdfasdfkjhasdlkfas;ldj  asdfasd"
                +"asdfasdfasdfasdfasdfasdfasdfa asdfasdfa adfa sdfasdfqwe2asd"
                +"dfasdfasdfasdfkajsd;flkasd;lkfasldjfkashdfkljhas;fadsklfjsdf"
                +"sdfasdfasdfasdfasdfasdfasdfasdfasdfkjhasdlkfas;ldj  asdfasd"
                +"asdfasdfasdfasdfasdfasdfasdfa asdfasdfa adfa sdfasdfqwe2asd"
                +"dfasdfasdfasdfkajsd;flkasd;lkfasldjfkashdfkljhas;fadsklfjsdf"
                +"sdfasdfasdfasdfasdfasdfasdfasdfasdfkjhasdlkfas;ldj  asdfasd"
                +"asdfasdfasdfasdfasdfasdfasdfa asdfasdfa adfa sdfasdfqwe2asd"
                +"dfasdfasdfasdfkajsd;flkasd;lkfasldjfkashdfkljhas;fadsklfjsdf"
                +"sdfasdfasdfasdfasdfasdfasdfasdfasdfkjhasdlkfas;ldj  asdfasd"
                +"asdfasdfasdfasdfasdfasdfasdfa asdfasdfa adfa sdfasdfqwe2asd"
                +"dfasdfasdfasdfkajsd;flkasd;lkfasldjfkashdfkljhas;fadsklfjsdf"
                +"sdfasdfasdfasdfasdfasdfasdfasdfasdfkjhasdlkfas;ldj  asdfasd"
                +"asdfasdfasdfasdfasdfasdfasdfa asdfasdfa adfa sdfasdfqwe2asd"
                +"dfasdfasdfasdfkajsd;flkasd;lkfasldjfkashdfkljhas;fadsklfjsdf"
                +"asdfasdfasdfasdfasdfasdfasdfa asdfasdfa adfa sdfasdfqwe2asd"
                +"dfasdfasdfasdfkajsd;flkasd;lkfasldjfkashdfkljhas;fadsklfjsdf"
                +"sdfasdfasdfasdfasdfasdfasdfasdfasdfkjhasdlkfas;ldj  asdfasd"
                +"asdfasdfasdfasdfasdfasdfasdfa asdfasdfa adfa sdfasdfqwe2asd"
                +"dfasdfasdfasdfkajsd;flkasd;lkfasldjfkashdfkljhas;fadsklfjsdf"
                +"sdfasdfasdfasdfasdfasdfasdfasdfasdfkjhasdlkfas;ldj  asdfasd"
                +"asdfasdfasdfasdfasdfasdfasdfa asdfasdfa adfa sdfasdfqwe2asd"
                +"dfasdfasdfasdfkajsd;flkasd;lkfasldjfkashdfkljhas;fadsklfjsdf"
                +"sdfasdfasdfasdfasdfasdfasdfasdfasdfkjhasdlkfas;ldj  asdfasd"
                +"asdfasdfasdfasdfasdfasdfasdfa asdfasdfa adfa sdfasdfqwe2asd"
                +"dfasdfasdfasdfkajsd;flkasd;lkfasldjfkashdfkljhas;fadsklfjsdf"
                +"sdfasdfasdfasdfasdfasdfasdfasdfasdfkjhasdlkfas;ldj  asdfasd"
                +"asdfasdfasdfasdfasdfasdfasdfa asdfasdfa adfa sdfasdfqwe2asd"
                +"dfasdfasdfasdfkajsd;flkasd;lkfasldjfkashdfkljhas;fadsklfjsdf"
                +"sdfasdfasdfasdfasdfasdfasdfasdfasdfkjhasdlkfas;ldj  asdfasd"
                +"asdfasdfasdfasdfasdfasdfasdfa asdfasdfa adfa sdfasdfqwe2asd"
                +"dfasdfasdfasdfkajsd;flkasd;lkfasldjfkashdfkljhas;fadsklfjsdf" + " "
                +"azazazazaz"
                +"jhgjhkjlkj;lkj;j;lg gugg bi76r7t 6t o87t hgdsu4r g t o8tiu 7";
        long one = System.currentTimeMillis();
        int j = Naive.findMatch("azazazazaz".toCharArray(), text.toCharArray());
        long two = System.currentTimeMillis();
        int i = findMatch("azazazazaz".toCharArray(), text.toCharArray());
        long three = System.currentTimeMillis();
        System.out.println(i>-1?"Match found at " + (i+1) : "Match not found");
        System.out.println(j>-1?"Match found at " + (j+1) : "Match not found");
        System.out.println((two-one) + ", " + (three-two));
    }
}
