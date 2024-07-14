package inflearn.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class dfs_경로탐색_인접행렬 {

    public static void dfs(int[][] arr, List<Integer> list, int currPos, int N, int[] visited) {
        if (currPos == N) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (arr[currPos][i] == 1 && visited[i] == 0) {
                list.add(i);
                visited[i] = 1;

                dfs(arr, list, i, N, visited);

                list.remove(list.size() - 1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().trim().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[][] arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            split = br.readLine().trim().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            arr[from][to] = 1;
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);

        int[] visited = new int[N + 1];
        visited[1] = 1;

        dfs(arr, list, 1, N, visited);
    }
}
