import java.util.HashMap;
import java.util.Map;

public class pro_131127 {
    public static boolean check(Map<String, Integer> want, int totalWantCount, int from, int to, String[] discount) {
        for (int i = from; i <= to; i++) {
            if (want.getOrDefault(discount[i], 0) > 0) {
                totalWantCount--;
                want.put(discount[i], want.get(discount[i]) - 1);
            } else {
                return false;
            }
        }
        return totalWantCount == 0 ? true : false;
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantMap = new HashMap<>();
        int totalWantCount = 0;
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
            totalWantCount += number[i];
        }

        int answer = 0;

        for (int i = 0; (i + 9) <= (discount.length - 1); i++) {
            if (check((HashMap) wantMap.clone(), totalWantCount, i, i + 9, discount)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want1 = {"banana", "apple", "rice", "pork", "pot"};
        int[] number1 = {3, 2, 2, 2, 1};
        String[] discount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println("solution(want1, number1, discount1) = " + solution(want1, number1, discount1));

        String[] want2 = {"apple"};
        int[] number2 = {10};
        String[] discount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        System.out.println("solution(want2, number2, discount2) = " + solution(want2, number2, discount2));
    }
}
