package inflearn.basic;

import java.util.*;
import java.io.*;

public class basic_musicvid {

    public static int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] minutes = new int[N];

        line = br.readLine();
        st = new StringTokenizer(line);
        int index = 0;
        while (st.hasMoreTokens()) {
            minutes[index++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(minutes);

        int totalMinutes = 0;
        for (int i = 0; i < minutes.length; i++) {
            totalMinutes += minutes[i];
        }
        int lt = minutes[minutes.length - 1];
        int rt = totalMinutes;
        int result = Integer.MAX_VALUE;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            boolean check = check(minutes, mid, M);
            if (check) {
                // 다 담을 수 있어
                result = Math.min(mid, result);
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return result;
    }

    public static boolean check(int[] minutes, int capacity, int limit) {
        int used = 0;
        int startIdx = 0;
        int i = 0;

        while (used < limit) {
            used++;
            int tempSum = 0;
            for (i = startIdx; i < minutes.length; i++) {
                if (tempSum + minutes[i] > capacity) {
                    startIdx = i;
                    break;
                } else {
                    tempSum += minutes[i];
                }
            }
            if (i == minutes.length) return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(solution());
    }
}
