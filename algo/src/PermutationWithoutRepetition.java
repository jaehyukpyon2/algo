import java.util.ArrayList;
import java.util.Arrays;

public class PermutationWithoutRepetition {

    public static int[] checked;

    public static ArrayList<int[]> arr = new ArrayList<>();

    public static int[] result;

    public static void dfs(int[] original, int startIdx, int currentCount, int maxCount) {

        if (currentCount == maxCount) {
            arr.add(new int[]{result[0], result[1]});
            return;
        } else {
            for (int i = 0; i < original.length; i++) {
                if (checked[i] == 1) continue;
                result[currentCount] = original[i];
                checked[i] = 1;
                dfs(original, startIdx + 1, currentCount + 1, maxCount);
                checked[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] original1 = new int[]{1, 2, 3};
        checked = new int[original1.length];
        result = new int[2];
        dfs(original1, 0, 0, 2);

        for (int[] temp : arr) {
            System.out.println(Arrays.toString(temp));
        }
    }
}
