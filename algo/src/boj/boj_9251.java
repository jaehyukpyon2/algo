package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_9251 {
    public static int solution(String str1, String str2) {
        int[][] memo = new int[str1.length() + 1][str2.length() + 1];
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                char c1 = chars1[i - 1];
                char c2 = chars2[j - 1];

                if (c1 == c2) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    int cand1 = memo[i - 1][j];
                    int cand2 = memo[i][j - 1];
                    memo[i][j] = Math.max(cand1, cand2);
                }
            }
        }

        return memo[str1.length()][str2.length()];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine().trim();
        String str2 = br.readLine().trim();

        System.out.println(solution(str1, str2));
    }
}
