import java.util.*;

public class pro_76502 {

    static Map<String, String> map = new HashMap<>();
    static Set<String> set = new HashSet<>();

    static boolean check(String s) {
        String[] splits = s.split("");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < splits.length; i++) {
            String temp = splits[i];
            if (set.contains(temp)) {
                stack.addFirst(temp);
            } else {
                if (stack.isEmpty()) return false;
                String leftMatch = map.get(temp);
                if (stack.pollFirst().equals(leftMatch) == false) {
                    return false;
                }
            }
        }

        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    static String getStr(ArrayDeque<String> stack) {
        StringBuilder sb = new StringBuilder();
        while (stack.isEmpty() == false) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }

    public static int solution(String s) {
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        set.add("(");
        set.add("[");
        set.add("{");

        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] split = s.split("");
        int answerCount = 0;

        for (int i = 0; i < s.length(); i++) {
            stack.addLast(split[i]);
        }

        if (check(getStr(stack.clone()))) {
            answerCount++;
        }

        for (int i = 1; i < s.length(); i++) {
            String temp = stack.pollFirst();
            stack.addLast(temp);
            if (check(getStr(stack.clone()))) {
                answerCount++;
            }
        }

        return answerCount;
    }

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
    }
}
