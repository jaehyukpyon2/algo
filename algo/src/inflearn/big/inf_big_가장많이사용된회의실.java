package inflearn.big;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class inf_big_가장많이사용된회의실 {

    static class Room {
        int roomNo;
        int finishTime;

        Room(int roomNo, int finishTime) {
            this.roomNo = roomNo;
            this.finishTime = finishTime;
        }
    }

    static class Meet {
        int startTime;
        int endTime;
        int runTime;

        Meet(int startTime, int endTime, int runTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.runTime = runTime;
        }
    }

    public static int solution(int n, int[][] meetings) {
        PriorityQueue<Room> roomQueue = new PriorityQueue<>((r1, r2) -> {
            if (Integer.compare(r1.finishTime, r2.finishTime) == 0) {
                return Integer.compare(r1.roomNo, r2.roomNo);
            } else {
                return Integer.compare(r1.finishTime, r2.finishTime);
            }
        });

        PriorityQueue<Meet> meetQueue = new PriorityQueue<>((m1, m2) -> {
            if (Integer.compare(m1.startTime, m2.startTime) == 0) {
                return Integer.compare(m1.endTime, m2.endTime);
            } else {
                return Integer.compare(m1.startTime, m2.startTime);
            }
        });

        for (int i = 0; i < n; i++) {
            roomQueue.offer(new Room(i, 0));
        }

        for (int[] meeting : meetings) {
            meetQueue.offer(new Meet(meeting[0], meeting[1], meeting[1] - meeting[0]));
        }

        int[] answer = new int[n];

        while (meetQueue.isEmpty() == false) {
            Room room = roomQueue.poll();
            Meet meet = meetQueue.poll();

            answer[room.roomNo]++;

            if (room.finishTime <= meet.startTime) {
                roomQueue.offer(new Room(room.roomNo, meet.endTime));
                continue;
            }

            if (room.finishTime > meet.startTime) {
                roomQueue.offer(new Room(room.roomNo, room.finishTime + meet.runTime));
                continue;
            }
        }

        int[] answerArr = Arrays.stream(answer)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(i -> i)
                .toArray();

        int max = answerArr[0];

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == max) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n1 = 2;
        int[][] meetings1 = {{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}};

        int n2 = 3;
        int[][] meetings2 = {{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}};

        int n3 = 3;
        int[][] meetings3 = {{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}};

        int n4 = 4;
        int[][] meetings4 = {{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}};

        System.out.println(solution(n1, meetings1));
        System.out.println(solution(n2, meetings2));
        System.out.println(solution(n3, meetings3));
        System.out.println(solution(n4, meetings4));
    }
}
