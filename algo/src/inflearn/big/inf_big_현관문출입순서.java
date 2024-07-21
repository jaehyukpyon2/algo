package inflearn.big;

import java.util.Arrays;
import java.util.PriorityQueue;

public class inf_big_현관문출입순서 {

    static class Person {
        int index;
        int arrivedAt;
        int state;
        Person(int index, int arrivedAt, int state) {
            this.index = index;
            this.arrivedAt = arrivedAt;
            this.state = state;
        }
    }

    public static long[] solution(int[] arrivals, int[] states) {
        // 1초 전에 사용 X -> 나가는 사원 (1)
        // 1초 전에 나가는 사용 -> 나가는 사원 (1)
        // 1초 전에 들어오는 사용 -> 들어오는 (0)
        long[] answer = new long[arrivals.length];

        PriorityQueue<Person> persons = new PriorityQueue<>((p1, p2) -> {
            return Integer.compare(p1.index, p2.index);
        });

        PriorityQueue<Person> enterQueue = new PriorityQueue<>((p1, p2) -> {
            return Integer.compare(p1.index, p2.index);
        });

        PriorityQueue<Person> exitQueue = new PriorityQueue<>((p1, p2) -> {
            return Integer.compare(p1.index, p2.index);
        });

        for (int i = 0; i < arrivals.length; i++) {
            persons.offer(new Person(i, arrivals[i], states[i]));
        }

        long currTime = 0;
        int type = 1;

        while (true) {
            if (persons.isEmpty() && enterQueue.isEmpty() && exitQueue.isEmpty()) {
                break;
            }

            while (persons.isEmpty() == false && persons.peek().arrivedAt <= currTime) {
                Person person = persons.poll();
                int state = person.state;
                if (state == 0) {
                    enterQueue.offer(person);
                } else {
                    exitQueue.offer(person);
                }
            }

            if (enterQueue.isEmpty() && exitQueue.isEmpty()) {
                currTime = persons.peek().arrivedAt;
                type = 1;
                continue;
            }

            if ((exitQueue.isEmpty() == false && type == 1) || enterQueue.isEmpty()) {
                Person person = exitQueue.poll();
                answer[person.index] = currTime;
                type = 1;
                currTime++;
                continue;
            }

            if ((enterQueue.isEmpty() == false && type == 0) || exitQueue.isEmpty()) {
                Person person = enterQueue.poll();
                answer[person.index] = currTime;
                type = 0;
                currTime++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arrival1 = {0, 1, 1, 1, 2, 3, 8, 8};
        int[] state1 = {1, 0, 0, 1, 0, 0, 1, 0};
        System.out.println(Arrays.toString(solution(arrival1, state1)));

        int[] arrival2 = {3, 3, 4, 5, 5, 5};
        int[] state2 = {1, 0, 1, 0, 1, 0};
        System.out.println(Arrays.toString(solution(arrival2, state2)));

        int[] arrival3 = {2, 2, 2, 3, 4, 8, 8, 9, 10, 10};
        int[] state3 = {1, 0, 0, 0, 1, 1, 0, 1, 1, 0};
        System.out.println(Arrays.toString(solution(arrival3, state3)));
    }
}
