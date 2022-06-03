import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        int len = x.length();
        if (x.charAt(0) == ')' || x.charAt(0) == ']' ||
                x.charAt(len - 1) == '[' || x.charAt(len - 1) == '(') {
            System.out.println(0);
        }
        else {
            Stack<Node1> st1 = new Stack<>();
            Stack<Node2> st2 = new Stack<>();

            for (int i = 0; i < len; i++) {
                char ch = x.charAt(i);
                if (st1.isEmpty()) st1.push(new Node1(ch, 1));
                else if ((ch == ')' && st1.peek().x == '(') ||
                        (ch == ']' && st1.peek().x == '[')) {
                    Node2 node2 = new Node2(st1.pop().level, (ch == ')') ? 2 : 3);
                    if (st2.isEmpty() || (st2.peek().level < node2.level)) st2.push(node2);
                    else if (st2.peek().level > node2.level) {
                        node2.val *= st2.pop().val;
                        if (st2.isEmpty()) st2.push(node2);
                        else {
                            if(st2.peek().level == node2.level) {
                                node2.val += st2.pop().val;
                            }
                            st2.push(node2);
                        }
                    } else {
                        node2.val += st2.pop().val;
                        st2.push(node2);
                    }
                } else {
                    st1.push(new Node1(ch, st1.peek().level + 1));
                }
            }
            if (st1.isEmpty())
                System.out.println(st2.peek().val);
            else System.out.println(0);
        }
        br.close();
    }

    static class Node1 {
        char x;
        int level;

        public Node1(char x, int level) {
            this.x = x;
            this.level = level;
        }

        @Override
        public String toString() {
            return "Node1{" +
                    "x=" + x +
                    ", level=" + level +
                    '}';
        }
    }

    static class Node2 {
        int level, val;

        public Node2(int level, int val) {
            this.level = level;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node2{" +
                    "level=" + level +
                    ", val=" + val +
                    '}';
        }
    }

}