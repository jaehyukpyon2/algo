import java.util.*;

public class PermutationWithRepetition {

    public static ArrayList<int[]> arr = new ArrayList<>();

    public static int[] result;

    public static void dfs(int[] original, int startIdx, int currentCount, int maxCount) {

        if (currentCount == maxCount) {
            arr.add(new int[]{result[0], result[1]});
            return;
        } else {
            for (int i = 0; i < original.length; i++) {
                result[currentCount] = original[i];
                dfs(original, startIdx + 1, currentCount + 1, maxCount);
            }
        }
    }

    public static void main(String[] args) {
        int[] original1 = new int[]{1, 2, 3};
        result = new int[2];
        dfs(original1, 0, 0, 2);

        for (int[] temp : arr) {
            System.out.println(Arrays.toString(temp));
        }
    }
}
