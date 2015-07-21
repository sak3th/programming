import java.io.FileInputStream;
import java.util.Scanner;

public class CommonAncestor {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("competency/CommonAncestor.in"));
        Scanner sc = new Scanner(System.in);

        int T;
        T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int numV = sc.nextInt(), numE = sc.nextInt();
            int childOne = sc.nextInt(), childTwo = sc.nextInt();

            int[] parent = new int[numV + 1];
            for (int i = 0; i <= numV; i++) parent[i] = -1;
            for (int i = 0, x, y; i < numE; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                parent[y] = x;
            }

            boolean found = false;
            boolean[] exists = new boolean[numV + 1];

            while (!found)
            System.out.println("#" + test_case + " "   );
        }
    }
}
