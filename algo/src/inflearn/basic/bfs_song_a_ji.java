package inflearn.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bfs_song_a_ji {
    
    public static int solution(int s, int e) {
        // s -> hyunsoo
        // e -> song-a-ji
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.addLast(s);
        visited.add(s);

        int move = 0;

        while (queue.isEmpty() == false) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currPos = queue.pollFirst();
                if (currPos == e) {
                    return move;
                }
                if (visited.contains(currPos + 1) == false) {
                    queue.addLast(currPos + 1);
                    visited.add(currPos + 1);
                }
                if (visited.contains(currPos - 1) == false) {
                    queue.addLast(currPos - 1);
                    visited.add(currPos - 1);
                }
                if (visited.contains(currPos + 5) == false) {
                    queue.addLast(currPos + 5);
                    visited.add(currPos + 5);
                }
            }
            move++;
        }
        return -1;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        System.out.println(solution(S, E));
    }
}
