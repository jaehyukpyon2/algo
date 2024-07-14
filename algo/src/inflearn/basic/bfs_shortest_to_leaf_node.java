package inflearn.basic;

import java.util.ArrayDeque;

public class bfs_shortest_to_leaf_node {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static int bfs(Node root) {
        int currentLevel = 0;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (queue.isEmpty() == false) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.pollFirst();
                if (node.left == null && node.right == null) {
                    return currentLevel;
                } else {
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                }
            }
            currentLevel++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.left = node2;
        node1.right = node3;

        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node2.left = node4;
        node2.right = node5;
    }
}
