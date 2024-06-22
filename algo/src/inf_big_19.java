import java.util.*;
import java.util.stream.*;

public class inf_big_19 {
    public static int solution(int[] laser, String[] enter) {
        if (enter.length == 1) return 0;

        ArrayDeque<int[]> waiting = new ArrayDeque<>();
        ArrayDeque<int[]> notArrived = new ArrayDeque<>();

        for (String str : enter) {
            String[] split = str.split(" ");// 10:23, 0
            String[] arrivedSplit = split[0].split(":");// 10, 23
            int arrived = Integer.parseInt(arrivedSplit[0]) * 60 + Integer.parseInt(arrivedSplit[1]);
            int idx = Integer.parseInt(split[1]);
            notArrived.addLast(new int[]{arrived, idx});
        }

        int endTime = -1;
        int answer = -1;

        int[] temp = notArrived.pollFirst();
        endTime = temp[0] + (laser[temp[1]]);

        for (int currentTime = temp[0]; ; currentTime++) {
            if (notArrived.isEmpty()) {
                answer = Math.max(answer, waiting.size());
                break;
            }

            int[] nextCheck = notArrived.peekFirst();
            if (currentTime == nextCheck[0] && currentTime < endTime) {
                waiting.addLast(new int[]{nextCheck[0], nextCheck[1]});
                notArrived.pollFirst();
                answer = Math.max(answer, waiting.size());
                continue;
            }

            if (currentTime == endTime) {
                if (currentTime == nextCheck[0]) {
                    waiting.addLast(new int[]{nextCheck[0], nextCheck[1]});
                    notArrived.pollFirst();
                }

                if (waiting.isEmpty() == false) {
                    endTime = currentTime + laser[waiting.pollFirst()[1]];
                } else {
                    int[] not = notArrived.pollFirst();
                    currentTime = not[0];
                    endTime = currentTime + laser[not[1]];
                }
            }
            answer = Math.max(answer, waiting.size());
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
