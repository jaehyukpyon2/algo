package programmers;

import java.util.PriorityQueue;

public class pccp_1_4 {
    static class Node {
        int priority;
        int calledAt;
        int runTime;

        Node(int priority, int calledAt, int runTime) {
            this.priority = priority;
            this.calledAt = calledAt;
            this.runTime = runTime;
        }
    }

    public static long[] solution(int[][] program) {
        long[] answer = new long[11];

        PriorityQueue<Node> programQueue = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1.calledAt, n2.calledAt);
        });

        PriorityQueue<Node> waitingQueue = new PriorityQueue<>((n1, n2) -> {
            if (Integer.compare(n1.priority, n2.priority) == 0) {
                return Integer.compare(n1.calledAt, n2.calledAt);
            } else {
                return Integer.compare(n1.priority, n2.priority);
            }
        });

        for (int[] p : program) {
            programQueue.offer(new Node(p[0], p[1], p[2]));
        }

        long currTime = 0;

        while (true) {
            if (programQueue.isEmpty() && waitingQueue.isEmpty()) {
                break;
            }

            while (programQueue.isEmpty() == false && programQueue.peek().calledAt <= currTime) {
                waitingQueue.offer(programQueue.poll());
            }

            if (waitingQueue.isEmpty()) {
                currTime = programQueue.peek().calledAt;
                continue;
            }

            if (waitingQueue.isEmpty() == false) {
                Node n = waitingQueue.poll();
                long waitTime = currTime - n.calledAt;
                int priority = n.priority;
                int runTime = n.runTime;

                answer[priority] += waitTime;
                currTime += runTime;
            }
        }
        answer[0] = currTime;
        return answer;
    }

    public static void main(String[] args) {
        int[][] case2 = {{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {5, 0, 5}};
        solution(case2);
    }
}
