import java.util.*;
import java.io.*;

public class lower_bound {
    
    public static int solution(int[] arr, int k) {
        Arrays.sort(arr);
        int lt = 0;
        int rt = arr.length - 1;
        int result = -1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] < k) {
                lt = mid + 1;
            }
            if (arr[mid] >= k) {
                result = mid;
                rt = mid - 1;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 5, 6, 7, 7, 9, 9, 10};
        System.out.println("solution(arr1, 13) = " + solution(arr1, 13));
        
        int[] arr2 = {2, 2, 2, 2, 2};
        System.out.println("solution(arr2, 2) = " + solution(arr2, 2));
    }
}
