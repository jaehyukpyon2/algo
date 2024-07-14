package inflearn.big;

import java.util.*;

public class inf_big_12 {
    public static int solution(int[] nums, int m) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //map.put(sum, map.getOrDefault(sum, 0) + 1);
            int minus = sum - m;
            if (minus == 0) {
                answer++;
            } else {
                int check = map.getOrDefault(minus, -1);
                if (check != -1) {
                    answer += check;
                }
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] nums1 = {2, 2, 3, -1, -1, -1, 3, 1, 1};
        int m1 = 5;
        System.out.println(solution(nums1, m1));


        int[] nums2 = {1, 2, 3, -3, 1, 2, 2, -3};
        int m2 = 5;
        System.out.println(solution(nums2, m2));

        int[] nums3 = {1, 2, 3, -3, 1, 2};
        int m3 = 3;
        System.out.println(solution(nums3, m3));

        int[] nums4 = {-1, 0, 1};
        int m4 = 0;
        System.out.println(solution(nums4, m4)); // expected 2

        int[] nums5 = {-1, -1, -1, 1};
        int m5 = 0;
        System.out.println(solution(nums5, m5)); // expected 1
    }
}
