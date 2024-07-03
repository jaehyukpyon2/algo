import java.util.*;
public class array_pre_in_post_order {
    public static String preOrder(int[] nodes, int idx) {
          if (idx >= nodes.length) {
              return "";
          }
          return (nodes[idx] + " " +
                  preOrder(nodes, idx * 2 + 1) +
                  preOrder(nodes, idx * 2 + 2));
      }
      
      public static String inOrder(int[] nodes, int idx) {
          if (idx >= nodes.length) {
              return "";
          }
          return (inOrder(nodes, idx * 2 + 1) +
                 nodes[idx] + " " +
                 inOrder(nodes, idx * 2 + 2));
      }
      
      public static String postOrder(int[] nodes, int idx) {
          if (idx >= nodes.length) {
              return "";
          }
          return postOrder(nodes, idx * 2 + 1) + 
                 postOrder(nodes, idx * 2 + 2) +
                 nodes[idx] + " ";
      }
      
      public static String[] solution(int[] nodes) {
          String[] answer = new String[3];
          answer[0] = preOrder(nodes, 0).trim();
          answer[1] = inOrder(nodes, 0).trim();
          answer[2] = postOrder(nodes, 0).trim();
          return answer;
      }
      
      public static void main(String[] args) {
          int[] nodes = {1, 2, 3, 4, 5, 6, 7};
          System.out.println(Arrays.toString(solution(nodes)));
      }
}
