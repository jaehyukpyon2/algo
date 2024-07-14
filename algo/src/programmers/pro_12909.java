package programmers;

import java.util.*;

public class pro_12909 {

    boolean solution(String s) {
        String[] splits = s.split("");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < splits.length; i++) {
            String temp = splits[i];
            if (temp.equals("(")) {
                stack.addFirst(temp);
            } else {
                if (stack.size() == 0) return false;
                String check = stack.peekFirst();
                if (check.equals("(") == false) {
                    return false;
                } else {
                    stack.pollFirst();
                }
            }
        }

        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
