import java.util.*;

class inf_big_01 {
    static Map<Integer, List<int[]>> map = new HashMap<>();
    static String[] result;
    
    static void dfs(String alpha, int currLvl, int currPos, int maxLvl) {
        if (currLvl > maxLvl) {
            result[currPos] = alpha;
            return;
        }
        
        boolean nextLvl = false;
        int nextPos = -1;
        int plus = 0;
        outerFor: for (int i = currLvl; i <= maxLvl; i++) {
            plus++;
            List<int[]> list = map.get(i);
            
            for (int[] temp : list) {
                if (currPos == temp[0]) {
                    nextLvl = true;
                    nextPos = temp[1];
                    break outerFor;
                }
            }
        }
        
        
        if (nextLvl) {
            dfs(alpha, currLvl + plus, nextPos, maxLvl);
        } else {
            result[currPos] = alpha;
        }
    }
    
    public static void main(String[] args) {
        int n = 5;
        int[][] ladder = {{1, 3}, {2, 4}, {1, 4}};
        
        for (int i = 0; i < ladder.length; i++) {
            int[] temp = ladder[i];
            int currLvl = i + 1;
            List<int[]> tempList = map.getOrDefault(currLvl, new ArrayList<>());
            
            for (int j = 0; j < temp.length; j++) {
                int from = temp[j];
                int to = from + 1;
                
                tempList.add(new int[]{from, to});
                tempList.add(new int[]{to, from});
            }
            
            map.put(currLvl, tempList);
        }
        
        result = new String[n + 1];
        char lastC = (char) ('A' + (n - 1));
        int currPos = 1;
        for (char c = 'A'; c <= lastC; c++) {
            dfs(c + "", 1, currPos, ladder.length);
            currPos++;
        }
        
        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}
