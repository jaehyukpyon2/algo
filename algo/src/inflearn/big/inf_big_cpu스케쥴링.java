package inflearn.big;

import java.util.Arrays;
import java.util.PriorityQueue;

public class inf_big_cpu스케쥴링 {

    static class Task {
        int index;
        int calledAt;
        int runTime;

        Task(int index, int calledAt, int runTime) {
            this.index = index;
            this.calledAt = calledAt;
            this.runTime = runTime;
        }
    }

    public static int[] solution(int[][] tasks) {
        PriorityQueue<Task> tasksQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t1.calledAt, t2.calledAt));
        PriorityQueue<Task> waitingQueue = new PriorityQueue<>((t1, t2) -> {
            if (Integer.compare(t1.runTime, t2.runTime) == 0) {
                return Integer.compare(t1.index, t2.index);
            } else {
                return Integer.compare(t1.runTime, t2.runTime);
            }
        });

        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            tasksQueue.offer(new Task(i, task[0], task[1]));
        }

        int currTime = 0;
        int callIdx = 0;

        int[] answer = new int[tasks.length];

        while (true) {
            if (tasksQueue.isEmpty() && waitingQueue.isEmpty()) {
                break;
            }

            while (tasksQueue.isEmpty() == false && tasksQueue.peek().calledAt <= currTime) {
                waitingQueue.offer(tasksQueue.poll());
            }

            if (waitingQueue.isEmpty()) {
                currTime = tasksQueue.peek().calledAt;
                continue;
            }

            if (waitingQueue.isEmpty() == false) {
                Task task = waitingQueue.poll();
                int taskIdx = task.index;
                int runTime = task.runTime;

                answer[callIdx] = taskIdx;
                callIdx++;
                currTime += runTime;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] tasks1 = {{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}};
        int[][] tasks2 = {{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}};
        int[][] tasks3 = {{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}};
        int[][] tasks4 = {{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}};

        System.out.println(Arrays.toString(solution(tasks1)));
        System.out.println(Arrays.toString(solution(tasks2)));
        System.out.println(Arrays.toString(solution(tasks3)));
        System.out.println(Arrays.toString(solution(tasks4)));
    }
}
