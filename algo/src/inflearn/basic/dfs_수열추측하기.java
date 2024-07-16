import java.util.*;
import java.io.*;

public class dfs_수열추측하기 {

// time limit error

    public static ArrayList<ArrayList<Integer>> permuList = new ArrayList<>();
    public static int[] visited = null;

    public static void makePermu(int currDepth, int N, ArrayList<Integer> permu) {
        if (currDepth == N) {
            permuList.add((ArrayList<Integer>) permu.clone());
        } else {
            for (int i = 1; i <= N; i++) {
                if (visited[i] == 1) {
                    continue;
                } else {
                    visited[i] = 1;
                    permu.add(i);
                    makePermu(currDepth + 1, N, permu);
                    visited[i] = 0;
                    permu.remove(permu.size() - 1);
                }
            }
        }
    }

    public static boolean check(ArrayList<Integer> list, int K) {
        ArrayList<Integer> cloned = (ArrayList<Integer>) list.clone();

        while (cloned.size() != 1) {
            int size = cloned.size();
            for (int i = 0; i < size - 1; i++) {
                int num1 = cloned.get(i);
                int num2 = cloned.get(i + 1);
                cloned.set(i, num1 + num2);
            }
            cloned.remove(cloned.size() - 1);
        }
        if (cloned.get(0) == K) return true;
        else return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().trim().split(" ");
        int N = Integer.parseInt(split[0].trim());
        int K = Integer.parseInt(split[1].trim());
        visited = new int[N + 1];

        makePermu(0, N, new ArrayList<>());

        for (ArrayList<Integer> list : permuList) {
            boolean stop = check(list, K);
            if (stop) {
                StringBuilder sb = new StringBuilder();
                for (int i : list) {
                    sb.append(i + " ");
                }
                System.out.println(sb.toString().trim());
                return;
            }
        }
    }
}
