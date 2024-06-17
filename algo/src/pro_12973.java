import java.util.*;

public class pro_12973 {

    public int solution(String s) {
        ArrayDeque<String> stack = new ArrayDeque<String>();
        String[] splits = s.split("");

        for (int i = 0; i < splits.length; i++) {
            String temp = splits[i];
            if (stack.isEmpty() == false) {
                if (stack.peekFirst().equals(temp)) {
                    stack.pollFirst();
                } else {
                    stack.addFirst(temp);
                }
            } else {
                stack.addFirst(temp);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
