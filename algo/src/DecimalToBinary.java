import java.util.*;

public class DecimalToBinary {

    static String solution(int decimal) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (true) {
            if ((decimal / 2) > 1) {
                stack.addFirst(decimal % 2);
                decimal = decimal / 2;
            } else {
                stack.addFirst(decimal % 2);
                stack.addFirst(decimal / 2);
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12345));
    }
}
