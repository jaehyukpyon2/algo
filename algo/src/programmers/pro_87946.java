package programmers;

import java.util.ArrayList;

public class pro_87946 {

    public static ArrayList<ArrayList<Integer>> permuList = new ArrayList<>();
    public static int[] visited = null;
    public static ArrayList<Integer> permu = new ArrayList<>();
    public static int answer = -1;

    public static void makePermu(int curDepth, int maxDepth) {
        if (curDepth == maxDepth) {
            permuList.add((ArrayList<Integer>) permu.clone());
        } else {
            for (int i = 0; i < maxDepth; i++) {
                if (visited[i] == 1) {
                    continue;
                } else {
                    visited[i] = 1;
                    permu.add(i);
                    makePermu(curDepth + 1, maxDepth);
                    visited[i] = 0;
                    permu.remove(permu.size() - 1);
                }
            }
        }
    }

    public static void check(ArrayList<Integer> list, int[][] arr, int k) {
        int count = 0;

        for (int i : list) {
            int[] temp = arr[i];
            if (k >= temp[0]) {
                k = k - temp[1];
                count++;
            } else {
                answer = Math.max(answer, count);
                return;
            }
        }

        answer = Math.max(answer, count);
    }

    public static int solution(int k, int[][] dungeons) {
        visited = new int[dungeons.length];
        makePermu(0, dungeons.length);

        for (ArrayList<Integer> temp : permuList) {
            check(temp, dungeons, k);
        }

        return answer;
    }
}
