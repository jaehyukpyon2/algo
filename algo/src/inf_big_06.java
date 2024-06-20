import java.util.*;
public class inf_big_06 {
    
    public static int[] checked;
    
    public static Map<Integer, Integer> map = new HashMap<>();
    
    public static int solution(int[][] fruit) {
        for (int i = 0; i < fruit.length; i++) {
            int[] cloned = fruit[i].clone();
            Arrays.sort(cloned);
            int min = cloned[0];
            
            int idx = -1;
            int countCheck = 0;
            
            innerFor: for (int j = 0; j < fruit[i].length; j++) {
                if (fruit[i][j] == min) {
                    idx = j;
                }
                if (fruit[i][j] > min + 1) {
                    countCheck++;
                }
            }
            
            if (countCheck + 1 == fruit[i].length) {
                map.put(i, idx);
            } else {
                map.put(i, idx);
                checked[i] = 1;
            }
        }
            
        for (int i = 0; i < fruit.length; i++) {
            if (checked[i] == 0) {
                candidate1IdxWithOther(i, fruit);
                checked[i] = 1;
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < fruit.length; i++) {
            answer = answer + fruit[i][map.get(i)];
        }
        
        return answer;
    }
    
    public static void candidate1IdxWithOther(int candidate1Idx, int[][] fruit) {
        int candidate2Idx = -1;
        for (int i = candidate1Idx + 1; i < fruit.length; i++) {
            if (checked[i] == 0) { 
                candidate2Idx = i;
                if (candidate1Idx == candidate2Idx) {
                    continue;
                } else {
                    fruit[candidate1Idx][map.get(candidate1Idx)]++;
                    fruit[candidate2Idx][map.get(candidate2Idx)]++;
                    checked[i] = 1;
                    return;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] fruit1 = {
            {10, 20, 30}, 
            {12, 15, 20}, 
            {20, 12, 15}, 
            {15, 20, 10},
            {10, 15, 10}};
        checked = new int[fruit1.length];
        int answer1 = solution(fruit1);
        System.out.println("answer1: " + answer1); // 58 -> 58
        
        
        int[][] fruit2 = {
            {3, 7, 20}, 
            {10, 15, 5}, 
            {19, 5, 6}, 
            {10, 10, 10}, 
            {15, 10, 5}, 
            {3, 7, 20}, 
            {12, 12, 6}, 
            {10, 20, 0}, 
            {5, 10, 15}};
        checked = new int[fruit2.length];
        map = new HashMap<>();
        int answer2 = solution(fruit2);
        System.out.println("answer2: " + answer2); // 48 
        
        
        int[][] fruit3 = {
            {0, 3, 27}, 
            {20, 5, 5}, 
            {19, 5, 6}, 
            {10, 10, 10}, 
            {15, 10, 5}, 
            {3, 7, 20}};
        checked = new int[fruit3.length];
        map = new HashMap<>();
        int answer3 = solution(fruit3);
        System.out.println("answer3: " + answer3); // 32 -> 30 (-2)
        
        
        int[][] fruit4 = {{10, 9, 11}, {15, 20, 25}};
        checked = new int[fruit4.length];
        map = new HashMap<>();
        int answer4 = solution(fruit4);
        System.out.println("answer4: " + answer4); // 24
    }
}
