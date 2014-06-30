package y2010.africa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class StoreCredit {

    public static void main(String[] args) {
        String ioFile = "codejam/" + StoreCredit.class.getCanonicalName().replace(".", "/");
        storeCredit(new File(ioFile + ".in"), new File(ioFile + ".out"));
    }

    public static void storeCredit(File inFile, File outFile) {
        Scanner sc;
        try {
            sc = new Scanner(inFile);
            FileWriter fw = new FileWriter(outFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            int numCases = sc.nextInt();

            for(int i=0; i<numCases; i++) {
                int credit = sc.nextInt();
                int numItems = sc.nextInt();
                int[] items = new int[numItems];
                for(int j=0; j<numItems; j++) items[j] = sc.nextInt();

                // solve the input
                int[] sortedItems = new int[numItems];
                System.arraycopy(items, 0, sortedItems, 0, items.length);

                Arrays.sort(sortedItems);
                for(int j=0; j<numItems; j++) {
                    int find = credit - sortedItems[j];
                    if(Arrays.binarySearch(sortedItems, find) >= 0) {
                        int xPos=0, yPos=0;
                        for(int k=0; k<numItems; k++) {
                            if(xPos == 0 && items[k] == find) xPos = k+1;
                            else if (yPos == 0 && items[k] == sortedItems[j]) yPos = k+1;
                            if(xPos>0 && yPos>0) {
                                if (xPos < yPos) {
                                    //System.out.print("Case #" + (i+1) + ": " + xPos + " " + yPos + "\n");
                                    bw.write("Case #" + (i+1) + ": " + xPos + " " + yPos + "\n");
                                } else {
                                    //System.out.print("Case #" + (i+1) + ": " + yPos + " " + xPos + "\n");
                                    bw.write("Case #" + (i+1) + ": " + yPos + " " + xPos + "\n");
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            sc.close(); bw.close(); fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}