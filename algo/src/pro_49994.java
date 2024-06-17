import java.util.*;

public class pro_49994 {
    static Map<String, int[]> map = new HashMap<>();

    public static int solution(String dirs) {
        map.put("U", new int[]{-1, 0});
        map.put("R", new int[]{0, 1});
        map.put("D", new int[]{1, 0});
        map.put("L", new int[]{0, -1});

        String[] splits = dirs.split("");
        int answerCount = 0;

        int currentY = 5;
        int currentX = 5;

        Set<String> visited = new HashSet<>();

        for (int i = 0; i < splits.length; i++) {
            int[] dydx = map.get(splits[i]);
            int nextY = currentY + dydx[0];
            int nextX = currentX + dydx[1];
            if (nextY < 0 || nextY > 10 || nextX < 0 || nextX > 10) {
                continue;
            }
            // y:1,x:2->y:3,x:3
            // y:3,x:3->y:1,x:2
            String check1 = "y:" + currentY + ",x:" + currentX + "->y:" + nextY + ",x:" + nextX;
            String check2 = "y:" + nextY + ",x:" + nextX + "->y:" + currentY + ",x:" + currentX;
            if (visited.contains(check1) == false) {
                answerCount++;
            }
            visited.add(check1);
            visited.add(check2);
            currentY = nextY;
            currentX = nextX;
        }

        return answerCount;
    }

    public static void main(String[] args) {
        System.out.println(solution("UDU"));
    }
}
