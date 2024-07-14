package boj;

import java.util.*;
import java.io.*;

public class boj_2073 {

    static class Pipe {
        int len;
        int cap;
        Pipe(int len, int cap) {
            this.len = len;
            this.cap = cap;
        }
    }

    public static int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().trim().split(" ");
        int D = Integer.parseInt(split[0]);
        int P = Integer.parseInt(split[1]);

        int[] memo = new int[(D + 1)];
        List<Pipe> pipes = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            split = br.readLine().trim().split(" ");
            pipes.add(new Pipe(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }

        for (int i = 0; i < P; i++) {
            Pipe pipe = pipes.get(i);
            for (int j = D; j >= pipe.len; j--) {
                if (j == pipe.len && memo[j - pipe.len] == 0) {
                    memo[j] = Math.max(memo[j], pipe.cap);
                }
                if (memo[j - pipe.len] == 0) {
                    ;
                }
                if (memo[j - pipe.len] != 0) {
                    int cand1 = Math.min(memo[j - pipe.len], pipe.cap);
                    memo[j] = Math.max(memo[j], cand1);
                }
            }
        }

        return memo[D];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(solution());
    }
}
