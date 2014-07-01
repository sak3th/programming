package misc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709
 */
public class AvoidRoads {

    public static void main(String[] args) {
        String ioFile = "topcoder/" + AvoidRoads.class.getCanonicalName().replace(".", "/");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ioFile + ".in"));
            String widthheight = reader.readLine();
            while (widthheight != null) {
                String[] numbers = widthheight.split(" ");
                int W = Integer.parseInt(numbers[0]);
                int H = Integer.parseInt(numbers[1]);
                String blocks = reader.readLine();
                blocks = blocks.substring(1, blocks.length()-1);
                String[] bad = null;
                if (blocks.length() > 2) {
                    bad = blocks.split(",");
                } else {
                    bad = new String[]{};
                }
                long expected = Long.parseLong(reader.readLine());
                long before = System.currentTimeMillis();
                long result = numWays(W, H, bad);
                if (result == expected) {
                    System.out.println("Passed " + (System.currentTimeMillis()-before) + " millis");
                } else {
                    System.out.println("Failed " + result + "(" + expected + ")");
                }
                widthheight = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static long numWays(int W, int H, String[] bad) {
        long[][] grid = new long[W+2][H+2];
        int[][] blocks = new int[bad.length][4];
        for (int i = 0; i < bad.length; i++) {
            String[] points = bad[i].split(" ");
            for (int p = 0; p < 4; p++) blocks[i][p] = Integer.parseInt(points[p]);
        }
        grid[W][H] = 1;
        for (int h = H; h >= 0; h--) {
            for (int w = W; w >= 0; w--) {
                // if grid[w][h] is NOT beginning of a right block add grid[w + 1][h]
                if (!isBlocked(w, h, w + 1, h, blocks)) grid[w][h] += grid[w + 1][h];
                // if grid[w][h] is NOT beginning of a down block add grid[w][h + 1]
                if (!isBlocked(w, h, w, h + 1, blocks)) grid[w][h] += grid[w][h + 1];
            }
        }
        return grid[0][0];
    }

    static boolean isBlocked(int x1, int y1, int x2, int y2, int[][] blocks) {
        for (int i = 0; i < blocks.length; i++) {
            if ((x1 == blocks[i][0] && y1 == blocks[i][1] &&
                    x2 == blocks[i][2] && y2 == blocks[i][3]) ||
                    (x2 == blocks[i][0] && y2 == blocks[i][1] &&
                            x1 == blocks[i][2] && y1 == blocks[i][3])) {
                return true;
            }
        }
        return false;
    }
}
