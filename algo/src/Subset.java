import java.util.*;

public class Subset {
    static int[] result;

    static void dfs(int[] original, int currIdx) {
        if (currIdx == 3) {
            int allThreeMax = 0;
            for (int temp : result) {
                if (temp != Integer.MAX_VALUE) {
                    System.out.print(temp + " ");
                } else {
                    allThreeMax++;
                }
            }

            System.out.println();
            if (allThreeMax == 3) {
                System.out.println("NULL");
            }
            return;
        } else {
            result[currIdx] = original[currIdx];
            dfs(original, currIdx + 1);
            result[currIdx] = Integer.MAX_VALUE;
            dfs(original, currIdx + 1);
        }
    }

    public static void main(String[] args) {
        result = new int[3];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        dfs(new int[]{1, 2, 3}, 0);
    }
}
