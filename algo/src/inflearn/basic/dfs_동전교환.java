package inflearn.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dfs_동전교환 {
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] coins = new int[N];
        String[] split = br.readLine().trim().split(" ");

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(split[i].trim());
        }

        int M = Integer.parseInt(br.readLine().trim());

        coins = Arrays.stream(coins)
                .boxed()
                .sorted((a, b) -> Integer.compare(a, b) * -1)
                .mapToInt(i -> i)
                .toArray();

        dfs(coins, 0, 0, M);

        System.out.println(answer);
    }

    private static void dfs(int[] coins, int currCount, int prevSum, int M) {
        if (prevSum > M || currCount > answer) {
            return;
        } else if (prevSum == M) {
            answer = Math.min(currCount, answer);
            return;
        } else {
            for (int i = 0; i < coins.length; i++) {
                dfs(coins, currCount + 1, prevSum + coins[i], M);
            }
        }
    }
}
