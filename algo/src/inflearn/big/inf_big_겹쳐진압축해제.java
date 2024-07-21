package inflearn.big;

import java.util.ArrayDeque;

public class inf_big_겹쳐진압축해제 {

    public static String solution(String str) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (c == ')') {
                String tempStr = "";
                while (stack.isEmpty() == false) {
                    String s = stack.pollFirst();
                    if (s.equals("(")) {
                        String num = "";
                        int intNum = -1;
                        while (stack.isEmpty() == false && Character.isDigit(stack.peekFirst().charAt(0))) {
                            num = stack.pollFirst() + num;
                        }
                        if (num.equals("")) {
                            intNum = 1;
                        } else {
                            intNum = Integer.parseInt(num);
                        }
                        String pushStr = "";
                        for (int i = 0; i < intNum; i++) {
                            pushStr += tempStr;
                        }
                        stack.push(pushStr);
                        break;
                    } else {
                        tempStr = s + tempStr;
                    }
                }
            } else {
                stack.addFirst(c + "");
            }
        }

        int size = stack.size();
        String answerStr = "";
        for (int i = 0; i < size; i++) {
            answerStr = answerStr + stack.pollFirst();
        }

        return answerStr;
    }

    public static void main(String[] args) {
        String str1 = "10(ef)";
        System.out.println(solution(str1));
    }
}
