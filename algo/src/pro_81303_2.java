import java.util.Stack;

public class pro_81303_2 {
    public String solution(int n, int k, String[] cmd) {
        Stack<Node> stack = new Stack<>();
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
            char c = command.charAt(0);
            switch (c) {
                case 'U': {
                    int steps = Integer.valueOf(command.substring(2));
                    while (steps > 0) {
                        current = current.prev;
                        steps--;
                    }
                    break;
                }
                case 'D': {
                    int steps = Integer.valueOf(command.substring(2));
                    while (steps > 0) {
                        current = current.next;
                        steps--;
                    }
                    break;
                }
                case 'C': {
                    stack.push(current);
                    current = current.remove();
                    break;
                }
                case 'Z': {
                    stack.pop().undo();
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append('O');
        }

        while (stack.isEmpty() == false) {
            Node node = stack.pop();
            sb.setCharAt(node.value, 'X');
        }

        return sb.toString();
    }

    class Node {
        int value;
        Node prev = null;
        Node next = null;

        Node(int index) {
            this.value = index;
        }

        void undo() {
            if (this.prev != null) {
                this.prev.next = this;
            }
            if (this.next != null) {
                this.next.prev = this;
            }
        }

        Node remove() {
            if (this.prev != null) {
                prev.next = this.next;
            }
            if (this.next != null) {
                next.prev = this.prev;
                return this.next;
            }
            return this.prev;
        }
    }
}
