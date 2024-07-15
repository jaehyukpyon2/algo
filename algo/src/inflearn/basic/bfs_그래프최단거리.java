import java.util.*;
import java.io.*;

public class bfs_그래프최단거리 {
    public static void solution(int N, List<List<Integer>> list) {
        int[] visited = new int[N + 1];
        int[] dis = new int[N + 1];
        visited[1] = 1;
        dis[1] = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);

        while (queue.isEmpty() == false) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.pollFirst();
                List<Integer> tempList = list.get(temp);

                for (int sub : tempList) {
                    if (visited[sub] == 1) continue;
                    visited[sub] = 1;
                    dis[sub] = dis[temp] + 1;
                    queue.addLast(sub);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().trim().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().trim().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            list.get(from).add(to);
        }

        solution(N, list);
    }
}
