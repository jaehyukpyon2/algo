import java.util.*;

public class inf_big_02 {

    public static int[][] dydxArr = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0},
    };

    public static int[] dfs(int[][] board, int maxSec, int currSec, int currY, int currX, int direction) {
        if (currSec == maxSec) {
            return new int[]{currY, currX};
        }

        outerWhile: while (true) {
            int[] dydx = dydxArr[direction];
            int nextY = currY + dydx[0];
            int nextX = currX + dydx[1];

            if (nextY < 0 || nextY >= board.length || nextX < 0 || nextX >= board.length || board[nextY][nextX] == 1) {
                direction = (direction + 1) % 4;
                currSec++;
                if (currSec == maxSec) {
                    return new int[] {currY, currX};
                }
            } else {
                return dfs(board, maxSec, currSec + 1, nextY, nextX, direction);
            }
        }
    }

    public static int[] solution(int[][] board, int k) {
        return dfs(board, k, 0, 0, 0, 0);
    }

    public static void main(String[] args) {
        int[][] case1 = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}
        };
        int k = 10;
        System.out.println(Arrays.toString(solution(case1, k)));
    }
}
