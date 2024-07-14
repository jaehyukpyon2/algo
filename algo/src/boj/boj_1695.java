package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1695 {

    private static int solution(int N, int[] arr) {
        int[][] memo = new int[N + 1][N + 1];

        int step = 0;

        while (true) {
            step++;
            if (step == N) break;
            for (int i = 1; i + step <= N; i++) {
                int startIdx = i;
                int endIdx = i + step;
                if (arr[startIdx] != arr[endIdx]) {
                    int cand1 = memo[startIdx][endIdx - 1] + 1;
                    int cand2 = memo[startIdx + 1][endIdx] + 1;
                    memo[startIdx][endIdx] = Math.min(cand1, cand2);
                } else {
                    memo[startIdx][endIdx] = memo[startIdx + 1][endIdx - 1];
                }
            }
        }

        return memo[1][N];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arr));
    }
}
