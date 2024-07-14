package boj;

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class boj_12865_knapsack {

    static class Item {
        int kilo;
        int value;
        Item(int kilo, int value) {
            this.kilo = kilo;
            this.value = value;
        }
    }

    public static int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().trim().split(" ");
        int totalItemCount = Integer.parseInt(split[0]);
        int maxKilo = Integer.parseInt(split[1]);

        int[][] memo = new int[totalItemCount + 1][maxKilo + 1];
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < totalItemCount; i++) {
            split = br.readLine().trim().split(" ");
            int kilo = Integer.parseInt(split[0]);
            int value = Integer.parseInt(split[1]);
            items.add(new Item(kilo, value));
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 1; i < totalItemCount + 1; i++) {
            Item currItem = items.get(i - 1);

            for (int j = 1; j < maxKilo + 1; j++) {
                if (j < currItem.kilo) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    int cand1 = memo[i - 1][j];
                    int cand2 = memo[i - 1][j - currItem.kilo] + currItem.value;
                    memo[i][j] = Math.max(cand1, cand2);
                }
                answer = Math.max(answer, memo[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(solution());
    }
}
