import java.util.*;
import java.util.stream.*;

class retry {
  public static int solution(int[] tasks, int k) {
        int[] copy = new int[tasks.length];
        
        for (int i = 0; i < tasks.length; i++) {
            copy[i] = tasks[i];
        }
        
        Arrays.sort(tasks);
        int currentCycle = 0;
        int passedSec = 0;
        
        int lengthMinusOne = tasks.length;
        for (int i = 0; i < tasks.length; i++) {
            int remainCycle = -1;
            if (i == 0) {
                remainCycle = tasks[0];;
            } else {
                remainCycle = tasks[i] - tasks[i - 1];
            }
            if (remainCycle == 0) continue;
            if (passedSec + (lengthMinusOne - i + 1) * remainCycle >= k) {
                currentCycle++;
                break;
            } else {
                currentCycle += remainCycle;
                passedSec += ((lengthMinusOne - i + 1) * remainCycle);
            }
        }
        
        int startIdx = 0;
        while (true) {
            for (int i = 0; i < copy.length; i++) {
                if (copy[i] < currentCycle) continue;
                else {
                    passedSec++;
                    if (passedSec == k) return i + 1;
                }
            }
            currentCycle++;
        }
    }
    
    public static void main(String[] args) {
        int[] tasks1 = {1, 2, 3};
        int k1 = 5;
        System.out.println(solution(tasks1, k1));
        
        int[] tasks2 = {8, 5, 2, 9, 10, 7};
        int k2 = 30;
        System.out.println(solution(tasks2, k2));
        
        
        int[] tasks3 = {8, 9, 12, 23, 45, 16, 25, 50};
        int k3 = 100;
        System.out.println(solution(tasks3, k3));
    }
}
