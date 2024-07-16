package programmers;

import java.util.ArrayDeque;

public class pccp_2_3 {

    public static int solution(int[] menu, int[] order, int k) {
        int next = 0;
        int nextIdx = 0;

        ArrayDeque<Integer> exit = new ArrayDeque<>();
        int answer = Integer.MIN_VALUE;

        for (int i = 0; ; i++) {
            if (nextIdx == order.length) break;

            if (next == i) {
                if (exit.isEmpty()) {
                    int exitTime = next + menu[order[nextIdx]];
                    exit.addLast(exitTime);
                } else {
                    int exitTime = exit.peekFirst() + menu[order[nextIdx]];
                    exit.addLast(exitTime);
                }
                next += k;
                nextIdx++;

                // 빠질 사람?
                if (exit.isEmpty() == false && exit.peekFirst() == i) {
                    exit.pollFirst();
                    answer = Math.max(answer, exit.size());
                } else {
                    answer = Math.max(answer, exit.size());
                }
            }
            if (exit.isEmpty() == false && exit.peekFirst() == i) {
                exit.pollFirst();
                answer = Math.max(answer, exit.size());
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] menu1 = {5, 12, 30};
        int[] order1 = {1, 2, 0, 1};
        int k1 = 10;
    }
}
