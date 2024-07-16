import java.util.*;
import java.io.*;

public class dfs_조합구하기 {
    public static void dfs(int startIdx, int currDepth, int N, int M, List<Integer> combList) {
        if (currDepth == M) {
            for (int i : combList) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = startIdx; i <= N; i++) {
                combList.add(i);
                dfs(i + 1, currDepth + 1, N, M, combList);
                combList.remove(combList.size() - 1);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().trim().split(" ");
        int N = Integer.parseInt(split[0].trim());
        int M = Integer.parseInt(split[1].trim());
        dfs(1, 0, N, M, new ArrayList<>());
    }
}
