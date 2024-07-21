package inflearn.big;

import java.util.ArrayDeque;

public class inf_big_19_피부과 {

    static class Client {
        int enterTime;
        int exitTime;
        int laserType;

        Client(int enterTime, int exitTime, int laserType) {
            this.enterTime = enterTime;
            this.exitTime = exitTime;
            this.laserType = laserType;
        }
    }

    public static int solution(int[] lasers, String[] enters) {
        ArrayDeque<Client> notEnteredQueue = new ArrayDeque<>();
        ArrayDeque<Client> waitingQueue = new ArrayDeque<>();

        for (String s : enters) {
            String[] splits = s.trim().split(" ");
            String[] timeSplits = splits[0].trim().split(":");

            int laserType = Integer.parseInt(splits[1].trim());
            int enterTime = Integer.parseInt(timeSplits[0]) * 60 + Integer.parseInt(timeSplits[1]);

            notEnteredQueue.addLast(new Client(enterTime, 0, laserType));
        }

        int currTime = notEnteredQueue.peekFirst().enterTime;
        int nextExitTime = -1;
        int answer = 0;

        for (int i = currTime; ; i++) {
            if (notEnteredQueue.isEmpty()) {
                break;
            }

            if (waitingQueue.isEmpty() == false && (waitingQueue.peekFirst().exitTime <= i)) {
                waitingQueue.pollFirst();
            }

            if (notEnteredQueue.peekFirst().enterTime == i && waitingQueue.isEmpty()) {
                Client c = notEnteredQueue.pollFirst();
                if (nextExitTime <= i) {
                    int exitTime = i + lasers[c.laserType];
                    nextExitTime = exitTime;
                } else {
                    int exitTime = nextExitTime + lasers[c.laserType];
                    waitingQueue.addLast(new Client(c.enterTime, exitTime, c.laserType));
                }
                answer = Math.max(answer, waitingQueue.size());
                continue;
            }

            if (notEnteredQueue.peekFirst().enterTime == i && i < nextExitTime) {
                if (waitingQueue.isEmpty() == false) {
                    Client c = notEnteredQueue.pollFirst();
                    int exitTime = waitingQueue.peekLast().exitTime + lasers[c.laserType];
                    waitingQueue.addLast(new Client(c.enterTime, exitTime, c.laserType));
                }
                answer = Math.max(answer, waitingQueue.size());
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] laser1 = new int[]{30, 20, 25, 15};
        String[] enter1 = new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"};
        System.out.println(solution(laser1, enter1));

        int[] laser2 = new int[]{30, 20, 25, 15};
        String[] enter2 = new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"};
        System.out.println(solution(laser2, enter2));

        int[] laser3 = new int[]{30, 20, 25, 15};
        String[] enter3 = {"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"};
        System.out.println(solution(laser3, enter3));
    }
}
