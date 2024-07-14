package boj;

import java.util.*;
import java.io.*;

public class boj_2579 {
    public static int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] stair = new int[N + 1];
        int[] memo = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine().trim());
        }

        if (N == 1) {
            return stair[1];
        } else if (N == 2) {
            return stair[1] + stair[2];
        } else {
            memo[1] = stair[1];
            memo[2] = stair[1] + stair[2];
        }

        for (int i = 3; i <= N; i++) {
            int cand1 = memo[i - 2] + stair[i];
            int cand2 = memo[i - 3] + stair[i - 1] + stair[i];
            memo[i] = Math.max(cand1, cand2);
        }

        return memo[N];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(solution());
    }
}
