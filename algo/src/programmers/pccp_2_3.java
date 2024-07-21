package programmers;

import java.util.ArrayDeque;

public class pccp_2_3 {

    public static int solution(int[] menu, int[] order, int k) {
        int nextEnterSec = 0;
        int nextEnterIdx = 0;

        ArrayDeque<Integer> waitingQueue = new ArrayDeque<>();
        int answer = Integer.MIN_VALUE;

        for (int i = 0; ; i++) {
            if (nextEnterIdx == order.length) break;

            if (waitingQueue.isEmpty() == false && waitingQueue.peekFirst() == i) {
                waitingQueue.pollFirst();
            }

            if (nextEnterSec == i) {
                if (waitingQueue.isEmpty()) {
                    int exitTime = nextEnterSec + menu[order[nextEnterIdx]];
                    waitingQueue.addLast(exitTime);
                } else {
                    int exitTime = waitingQueue.peekLast() + menu[order[nextEnterIdx]];
                    waitingQueue.addLast(exitTime);
                }
                nextEnterSec = nextEnterSec + k;
                nextEnterIdx = nextEnterIdx + 1;
                answer = Math.max(answer, waitingQueue.size());
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] menu1 = {5, 12, 30};
        int[] order1 = {2, 1, 0, 0, 0, 1, 0};
        int k1 = 10;

        solution(menu1, order1, k1);
    }
}
