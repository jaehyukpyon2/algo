package inflearn.basic;

import java.util.*;
import java.io.*;

public class basic_horse {
    public static int check(int[] arr, int gap) {
        int count = 1;
        int lastIdx = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastIdx >= gap) {
                count++;
                lastIdx = arr[i];
            }
        }

        return count;
    }

    public static int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String line = br.readLine();
        st = new StringTokenizer(line);

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[arr.length - 1];
        int result = -1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int check = check(arr, mid);
            if (check >= C) {
                result = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(solution());
    }
}
