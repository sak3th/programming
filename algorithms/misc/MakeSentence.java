package misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MakeSentence {
    public static void main(String[] args) {
        make("emvzezrzmydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremoreeverydaymoremoreverydaymoremore");
    }

    public static boolean make(String line) {
        Set<String> dictionary = new HashSet<String>();
        Scanner in = null;
        try {
            in = new Scanner(new File("/usr/share/dict/web2"));
            while (in.hasNext()) {
                String word = in.next();
                if (word.length() > 2) {
                    dictionary.add(word);
                }
            }
            dictionary.add("a");
            dictionary.add("i");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int length = line.length();
        char[][] matrix = new char[line.length()][line.length()];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                String sub = line.substring(i, j+1);
                if(dictionary.contains(sub)) {
                    matrix[i][j] = 't';
                    //System.out.println(sub + "-"+i + " "+ j);
                }
            }
        }
        /*for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] == 't')
                    System.out.print(matrix[i][j] + " ");
                else
                    System.out.print("- ");
            }
            System.out.println();
        }*/
        if (find(length-1, length-1, matrix)) {
            for (int i = 0; i < length; i++) {
                System.out.print(line.charAt(i));
                if (matrix[i][0] == 's') {
                    System.out.print(" ");
                }
            }
        } else {
            System.out.print("Sentence not found");
        }
        return false;
    }

    private static boolean find(int i, int j, char[][] matrix) {
        while (i >= 0 && j >= 0) {
            if (matrix[i][j] == 't') {
                if (i == 0) {
                    // make flag true that all
                    matrix[0][0] = 'z';
                    return true;
                } else if (find(i-1, i-1, matrix)) {
                    if (matrix[0][0] == 'z') {
                        //System.out.print((i-1) + " ");
                        matrix[i-1][0] = 's';
                    }
                    return true;
                }
            }
            i--;
        }
        return false;
    }
}
