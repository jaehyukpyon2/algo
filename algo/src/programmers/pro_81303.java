package programmers;

import java.util.*;

public class pro_81303 {

    public static Node up(Node current, int steps) {
        for (int i = 0; i < steps; i++) {
            current = current.prev;
        }
        return current;
    }

    public static Node down(Node current, int steps) {
        for (int i = 0; i < steps; i++) {
            current = current.next;
        }
        return current;
    }

    public static String solution(int n, int k, String[] cmd) {
        ArrayDeque<Node> arr = new ArrayDeque<>();
        Node node0 = new Node(0);
        Node prev = node0;
        Node current = node0;

        for (int i = 1; i < n; i++) {
            Node node = new Node(i);
            prev.next = node;
            node.prev = prev;
            prev = node;
            if (i == k) {
                current = node;
            }
        }

        for (String command : cmd) {
            String[] split = command.split("");
            switch (split[0]) {
                case "U":
                    current = up(current, Integer.parseInt(split[2]));
                    break;
                case "D":
                    current = down(current, Integer.parseInt(split[2]));
                    break;
                case "C":
                    arr.addFirst(current);
                    current = current.remove();
                    break;
                case "Z":
                    arr.pollFirst().undo();
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("O");
        }
        while (arr.isEmpty() == false) {
            Node node = arr.pollFirst();
            sb.setCharAt(node.value, 'X');
        }

        return sb.toString();
    }

    static class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
        }

        void undo() {
            if (this.prev != null) {
                prev.next = this;
            }
            if (this.next != null) {
                next.prev = this;
            }
        }

        Node remove() {
            if (this.prev != null) {
                prev.next = this.next;
            }
            if (this.next != null) {
                next.prev = this.prev;
            }
            if (this.next != null) {
                return this.next;
            } else {
                return this.prev;
            }
        }
    }

    public static void main(String[] args) {
        int n1 = 8;
        int k1 = 2;
        String[] cmd1 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};

        System.out.println("start");
        System.out.println(solution(n1, k1, cmd1));
        System.out.println("end");
    }
}
