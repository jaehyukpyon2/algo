import java.util.*;
import java.util.stream.*;

class inf_big_25 {
    
    public static int calculate(int[] score, int startIdx, int k) {
        int result = 0;
        for (int i = startIdx; i < startIdx + k; i++) {
            result += score[i];
        }
        return result / k;
    }
    
    public static int solution(int[] score, int k) {
        Arrays.sort(score);
        for (int i = 0; i < score.length - k; i++) {
            int min = score[i];
            int max = score[i + k - 1];
            if (max - min <= 10) {
                return calculate(score, i, k);
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] score1 = {99, 97, 80, 91, 85, 95, 92};
        int k1 = 3;
        System.out.println(solution(score1, k1));
        
        int[] score2 = {92, 90, 77, 91, 70, 83, 89, 76, 95, 92};
        int k2 = 4;
        System.out.println(solution(score2, k2));
        
        int[] score3 = {77, 88, 78, 80, 78, 99, 98, 92, 93, 89};
        int k3 = 5;
        System.out.println(solution(score3, k3));
        
        int[] score4 = {88, 99, 91, 89, 90, 72, 75, 94, 95, 100};
        int k4 = 5;
        System.out.println(solution(score4, k4));
    }
}
