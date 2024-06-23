import java.util.*;
import java.util.stream.*;

public class inf_big_23 {
    public static int[] solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Arrays.sort(nums);
        ArrayList<Integer> answerArr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int numDouble = num * 2;

            int numCount = map.getOrDefault(num, 0);
            int numDoubleCount = map.getOrDefault(numDouble, 0);

            if (numCount >= 1 && numDoubleCount >= 1) {
                answerArr.add(num);
                map.put(num, numCount - 1);
                map.put(numDouble, numDoubleCount - 1);
            }
        }

        int[] answer = new int[nums.length / 2];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerArr.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 10, 2, 3, 5, 6};
        int[] nums2 = {1, 1, 6, 2, 2, 7, 3, 14};
        int[] nums3 = {14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14};

        System.out.println(Arrays.toString(solution(nums1)));
        System.out.println(Arrays.toString(solution(nums2)));
        System.out.println(Arrays.toString(solution(nums3)));
    }
}
