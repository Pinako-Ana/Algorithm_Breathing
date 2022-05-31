package prog;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class lv3_Edit_table_nice {

    private static void solution(int n, int k, String[] cmd) {
        Map<Integer, Node> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            hm.put(i, new Node(i - 1, i + 1));
        }
        for (String s : cmd) {
            char ch = s.charAt(0);

            switch (ch) {
                case 'U':
                    int cnt = Integer.parseInt(s.substring(2, s.length()));
                    while (cnt-- > 0) {
                        k = hm.get(k).up;
                    }
                    break;
                case 'D':
                    int cnt1 = Integer.parseInt(s.substring(2, s.length()));
                    while (cnt1-- > 0) {
                        k = hm.get(k).down;
                    }
                    break;
                case 'C':
                    st.push(k);
                    if(hm.get(k).down == n){
                        k = hm.get(k).up;
                        hm.get(k).down = n;
                    }else if(hm.get(k).up == -1){
                        hm.get(hm.get(k).down).up = -1;
                        k = hm.get(k).down;
                    }else{
                        hm.get(hm.get(k).up).down = hm.get(k).down;
                        hm.get(hm.get(k).down).up = hm.get(k).up;
                        k = hm.get(k).down;
                    }
                    break;
                case 'Z':
                    int pop = st.pop();
                    if(hm.get(pop).up == -1) {
                        hm.get(hm.get(pop).down).up = pop;
                    }else if(hm.get(pop).down == n){
                        hm.get(hm.get(pop).up).down = pop;
                    }else{
                        hm.get(hm.get(pop).down).up = pop;
                        hm.get(hm.get(pop).up).down = pop;
                    }
                    break;
            }
        }

        boolean[] str = new boolean[n];
        while(!st.isEmpty()){
            str[st.pop()] = true;
        }

        StringBuilder answer = new StringBuilder();

        for (boolean b : str) {
            answer.append(b ? "X" : "O");
        }

        System.out.println("answer = " + answer.toString());
    }
    public static void main(String[] args) {
        String[] arr = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

        solution(8, 2, arr);

        String[] arr2 = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};

        solution(8, 2, arr2);

    }

    static class Node {
        int up, down;

        public Node(int up, int down) {
            this.up = up;
            this.down = down;
        }
    }


}
