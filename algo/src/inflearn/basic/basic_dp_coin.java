package inflearn.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class basic_dp_coin {
    public static int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] coins = new int[N];

        String[] split = br.readLine().trim().split(" ");
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(split[i]);
        }

        int target = Integer.parseInt(br.readLine().trim());
        int[] memo = new int[target + 1];

        for (int i = 0; i < coins.length; i++) {

        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Try programiz.pro");
    }
}
