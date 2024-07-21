package programmers;

import java.util.*;

public class pccp_2_4 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y;
        boolean used;

        Node(int x, int y, boolean used) {
            this.x = x;
            this.y = y;
            this.used = used;
        }
    }

    public static int solution(int n, int m, int[][] hole) {
        int[][] board = new int[n][m];
        for (int[] h : hole) {
            board[h[0] - 1][h[1] - 1] = 1;
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];
        visited[0][0][0] = true;
        queue.add(new Node(0, 0, false));
        int L = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                int x = current.x;
                int y = current.y;
                boolean used = current.used;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny][used ? 1 : 0] && board[nx][ny] == 0) {
                        if (nx == n - 1 && ny == m - 1) {
                            return L + 1;
                        }
                        visited[nx][ny][used ? 1 : 0] = true;
                        queue.add(new Node(nx, ny, used));
                    }

                    if (!used) {
                        nx += dx[j];
                        ny += dy[j];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny][1] && board[nx][ny] == 0) {
                            if (nx == n - 1 && ny == m - 1) {
                                return L + 1;
                            }
                            visited[nx][ny][1] = true;
                            queue.add(new Node(nx, ny, true));
                        }
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] hole = {
                {2, 3},
                {3, 3}
        };

        solution(n, m, hole);
    }
}
