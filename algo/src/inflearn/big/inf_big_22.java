package inflearn.big;

import java.util.*;

public class inf_big_22 {
    public static void calculate(ArrayList<int[]> arr, int num) {
        int original = num;
        int count = 0;
        while (num != 0) {
            if (num % 2 == 1) count++;
            num = num / 2;
        }
        arr.add(new int[]{original, count});
    }

    public static int[] solution(int[] nums) {
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            calculate(arr, nums[i]);
        }

        Collections.sort(arr, (a1, b1) -> {
            if (Integer.compare(a1[1], b1[1]) == 0) {
                return Integer.compare(a1[0], b1[0]);
            }
            return Integer.compare(a1[1], b1[1]);
        });

        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            answer[i] = arr.get(i)[0];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 6, 7, 8, 9};
        int[] nums2 = {5, 4, 3, 2, 1};
        int[] nums3 = {12, 5, 7, 23, 45, 21, 17};

        System.out.println(Arrays.toString(solution(nums1)));
        System.out.println(Arrays.toString(solution(nums2)));
        System.out.println(Arrays.toString(solution(nums3)));
    }
}
