import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_2805_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken()); // numbers of trees
        int M = Integer.parseInt(st.nextToken()); // need m meters
        int[] trees = new int[N]; // height of trees

        line = br.readLine();
        st = new StringTokenizer(line);
        int MAX = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > MAX) {
                MAX = trees[i];
            }
        }

        int lt = 0;
        int rt = MAX;
        int result = 0; //answer

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            long count = 0;

            for (int tree : trees) {
                if (tree > mid)
                    count += (tree - mid);
            }

            if (M <= count) {
                lt = mid + 1;
                if (mid >= result) //higher the better
                    result = mid;
            } else {// m > count
                rt = mid - 1;
            }
        }

        System.out.println(result);
    }
}
