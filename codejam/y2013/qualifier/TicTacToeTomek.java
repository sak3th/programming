package y2013.qualifier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TicTacToeTomek {

    public static void main(String[] args) {
        String ioFile = "codejam/" + TicTacToeTomek.class.getCanonicalName().replace(".", "/");
        solution(new File(ioFile + ".in"), new File(ioFile + ".out"));
    }

    public static void solution(File in, File out) {
        Scanner sc; FileWriter fw; BufferedWriter bw;
        try {
            sc = new Scanner(in); fw = new FileWriter(out); bw = new BufferedWriter(fw);

            int cases = Integer.parseInt(sc.nextLine());
            for (int cas = 0; cas < cases; cas++) {
                int[][] board = new int[4][4];
                State s = State.D;
                for (int i = 0; i < 4; i++) {
                    String line = sc.nextLine();
                    for (int j = 0; j < 4; j++) {
                        board[i][j] = parse(line.charAt(j));
                        if (board[i][j] == 0) s = State.P;
                    }
                }
                
                for (int i = 0; i < 4; i++) {
                    int sum = 0; int vsum = 0;
                    for (int j = 0; j < 4; j++) {
                        sum += board[i][j];
                        vsum += board[j][i];
                    }
                    s = parse(sum, s);
                    if (s == State.X || s == State.O ) break;
                    s = parse(vsum, s);
                    if (s == State.X || s == State.O ) break;
                }
                
                if (!(s == State.X || s == State.O)) {
                    int diag = board[0][0] + board[1][1] + board[2][2] + board[3][3];
                    s = parse(diag, s);
                    int adiag = board[3][0] + board[2][1] + board[1][2] + board[0][3];
                    s = parse(adiag, s);
                }

                out(bw, "Case #" + (cas + 1) + ": " + s);
                sc.nextLine();
            }
            bw.close(); fw.close(); sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static State parse(int sum, State s) {
        if (sum == 35 || sum == 40) return State.X; 
        if (sum == -4 || sum == 2) return State.O;
        return s;
    }
    
    static int parse(char c) {
        if (c == 'X') return 10;
        if (c == 'O') return -1;
        if (c == 'T') return 5;
        return 0;
    }
    
    static enum State {
        X ("X won"), O("O won"), D("Draw"), P("Game has not completed");
        String desc;
        private State(String s) { desc = s; }
        @Override
        public String toString() { return desc; }
    }

    static void out(BufferedWriter bw, String str) {
        str = str + "\n";
        try { bw.write(str); } catch (IOException e) { e.printStackTrace(); }
        System.out.print(str);
    }
}