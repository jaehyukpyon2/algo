import java.util.*;
import java.util.stream.*;

public class inf_big_24 {
    public static int solution(int[] nums, int k) {
        List<Integer> arr = Arrays.stream(nums)
                .boxed().collect(Collectors.toList());
        Collections.sort(arr, Collections.reverseOrder());

        List<int[]> forSort = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {
            int num1 = arr.get(i);
            int num2 = arr.get(i + 1);
            int sub = num1 - num2;
            forSort.add(new int[]{num1, num2, sub});
        }

        Collections.sort(forSort, (a1, b1) -> {
            return Integer.compare(a1[2], b1[2]) * -1;
        });

        int currK = 0;
        int answer = 0;

        for (int i = 0; i < forSort.size(); i++) {
            int num1 = forSort.get(i)[0];
            int num2 = forSort.get(i)[1];
            if (currK < k) {
                answer += num1;
                currK++;
            } else {
                answer += num2;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {7, 8, 5, 12, 3, 1, 3, 1, 1, 12};
        int k1 = 2;
        System.out.println(solution(nums1, k1));

        int[] nums2 = {8, 2, 12, 12, 12, 12, 2, 2};
        int k2 = 2;
        System.out.println(solution(nums2, k2));

        int[] nums3 = {3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7};
        int k3 = 3;
        System.out.println(solution(nums3, k3));

        int[] nums4 = {12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12};
        int k4 = 3;
        System.out.println(solution(nums4, k4));

        int[] nums5 = {14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19};
        int k5 = 3;
        System.out.println(solution(nums5, k5));
    }
}
