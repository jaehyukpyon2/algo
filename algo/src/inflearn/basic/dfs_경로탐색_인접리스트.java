package inflearn.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class dfs_경로탐색_인접리스트 {

    private static void dfs(List<List<Integer>> list, int[] visited, List<Integer> print, int currPos, int N) {
        if (currPos == N) {
            for (int i : print) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            List<Integer> currPosList = list.get(currPos);
            for (int nextPos : currPosList) {
                if (visited[nextPos] == 1) {
                    continue;
                }
                print.add(nextPos);
                visited[nextPos] = 1;
                dfs(list, visited, print, nextPos, N);
                print.remove(print.size() - 1);
                visited[nextPos] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().trim().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().trim().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            list.get(from).add(to);
        }

        int[] visited = new int[N + 1];
        visited[1] = 1;

        List<Integer> print = new ArrayList<>();
        print.add(1);

        dfs(list, visited, print, 1, N);
    }
}
