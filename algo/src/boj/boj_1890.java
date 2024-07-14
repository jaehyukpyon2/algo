package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1890 {

    public static int solution(int[][] arr, int N) {
        if (arr[0][0] == 0) return 0;

        int[][] memo = new int[N][N];
        memo[0][0] = 1;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (memo[y][x] == 0 || arr[y][x] == 0) {
                    continue;
                }
                // move right -> x plus
                int nextX = x + arr[y][x];
                if (nextX < N) {
                    memo[y][nextX] += memo[y][x];
                }
                // move down -> y plus
                int nextY = y + arr[y][x];
                if (nextY < N) {
                    memo[nextY][x] += memo[y][x];
                }
            }
        }

        return memo[N - 1][N - 1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().trim().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(solution(arr, N));
    }
}
