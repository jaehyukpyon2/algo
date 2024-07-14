package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1823 {
    public static int dfs(int left, int right, int[] arr, int depth, int N, int[][] memo) {
        if (depth > N) return 0;
        if (memo[left][right] != 0) return memo[left][right];

        int candidate1 = dfs(left + 1, right, arr, depth + 1, N, memo) + (arr[left] * depth);
        int candidate2 = dfs(left, right - 1, arr, depth + 1, N, memo) + (arr[right] * depth);
        memo[left][right] = Math.max(candidate1, candidate2);
        return memo[left][right];
    }

    public static int solution(int N, int[] arr) {
        int[][] memo = new int[N][N];

        return dfs(0, N - 1, arr, 1, N, memo);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        System.out.println(solution(N, arr));
    }
}
