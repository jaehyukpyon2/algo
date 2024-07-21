package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class pccp_1_3 {
    public static String dfs(int n, int p, ArrayList<Integer> list) {
        if (n == 0) {
            for (int i = 1; i < list.size(); i++) {
                int num = list.get(i);
                if (num == 1) {
                    return "RR";
                }
                if (num == 0) {
                    return "rr";
                }
            }
            return "Rr";
        } else {
            int currPos = p % 4;
            int parentP = (p % 4 == 0) ? (p / 4) : (p / 4 + 1);
            list.add(currPos);
            return dfs(n - 1, parentP, list);
        }
    }

    public static String[] solution(int[][] queries) {
        ArrayList<String> ansList = new ArrayList<>();

        for (int[] query : queries) {
            int n = query[0] - 1;
            int p = query[1];
            if (n == 0) {
                ansList.add("Rr");
            } else {
                String ans = dfs(n, p, new ArrayList<>());
                ansList.add(ans);
            }
        }

        String[] ansArr = new String[ansList.size()];
        for (int i = 0; i < ansArr.length; i++) {
            ansArr[i] = ansList.get(i);
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[][] queries1 = {{3, 13}, {3, 14}, {3, 15}, {3, 16}};
        String[] solution1 = solution(queries1);
        System.out.println(Arrays.toString(solution1));
    }
}
