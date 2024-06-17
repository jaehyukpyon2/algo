import java.util.*;

public class pro_42889 {
    static Map<Integer, Integer> countMap = new HashMap<>();
    static Map<Integer, Double> answerMap = new HashMap<>();

    public static int[] solution(int N, int[] stages) {
        for (int i = 0; i < stages.length; i++) {
            countMap.put(stages[i], countMap.getOrDefault(stages[i], 0) + 1);
        }
        int minusCount = 0;
        int totalCount = stages.length;

        for (int i = 1; i < N + 1; i++) {
            int count = countMap.getOrDefault(i, 0);
            answerMap.put(i, count / (double) (totalCount - minusCount));
            minusCount += count;
        }

        Set<Map.Entry<Integer, Double>> entrySet = answerMap.entrySet();
        ArrayList<Map.Entry<Integer, Double>> arrayList = new ArrayList<>(entrySet);

        Collections.sort(arrayList, new Comparator<Map.Entry<Integer, Double>>() {
            public int compare(Map.Entry<Integer, Double> a, Map.Entry<Integer, Double> b) {
                Double a1 = a.getValue();
                Double b1 = b.getValue();

                if (a1 < b1) {
                    return 1;
                } else if (a1 > b1) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });


        int[] answer = new int[N];
        int index = 0;
        for (Map.Entry<Integer, Double> temp : arrayList) {
            answer[index++] = temp.getKey();
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
    }
}
