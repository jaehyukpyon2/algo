package boj;

import java.util.*;
import java.io.*;

public class boj_2805 {

    public static int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];

        line = br.readLine();

        st = new StringTokenizer(line);

        int index = 0;
        while (st.hasMoreTokens()) {
            trees[index++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int start = 0;
        int end = trees[trees.length - 1];
        int mid = 0;
        int result = 0;

        while (end >= start) {
            mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < trees.length; i++) {
                int rest = trees[i] - mid;
                sum += (rest >= 0 ? rest : 0);
            }
//            System.out.println("s=" + start + ", e=" + end + ", m=" + mid + ", sum=" + sum);

            if (sum < m) {
                end = mid - 1;
            } else {
                // sum >= m
                result = Math.max(mid, result);
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(solution());
    }
}
