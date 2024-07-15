import java.util.*;
import java.io.*;

public class dfs_중복순열 {
    
    public static void dfs(int currLvl, int N, int M, List<Integer> list) {
        if (currLvl == M) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                list.add(i);
                dfs(currLvl + 1, N, M, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().trim().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		
		dfs(0, N, M, new ArrayList<>());
	}
}
