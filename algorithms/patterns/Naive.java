package patterns;

//Problem : Substring pattern matching
//Input   : A text string t and a pattern string p
//Output  : Does t contain the pattern p as a substring, and if so where?

public class Naive {

    public static void main(String[] args) {
        int i = findMatch("namehjfkjhgjglg".toCharArray(),
                "name".toCharArray());
        System.out.println(i>-1?"Match found at " + (i+1) : "Match not found");
    }

    static int findMatch(char[] p, char[] t) {
        if(p.length < 1) return -1;
        if(p.length >= t.length) return -1;

        for(int i=0; i<=t.length-p.length; i++) {
            int j=0;
            while(j<p.length && t[i+j]==p[j]) j++;
            if(j==p.length) return i;
        }
        return -1;
    }

}

