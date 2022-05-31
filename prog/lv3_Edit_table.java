package prog;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class lv3_Edit_table {

    static Map<Integer, Node> hm = new HashMap<>();
    static Stack<Integer> st = new Stack<>();
    static int position, max;

    private static void solution(int n, int k, String[] cmd) {

        for (int i = 0; i < n; i++) {
            hm.put(i, new Node(i - 1, i + 1));
        }

        position = k;
        max = n;

        for (String s : cmd) {
            char ch = s.charAt(0);

            switch (ch) {
                case 'U':
                    upFunc(s.substring(2, s.length()));
                    break;
                case 'D':
                    downFunc(s.substring(2, s.length()));
                    break;
                case 'C':
                    cancelFunc();
                    break;
                case 'Z':
                    zFunc();
                    break;
            }
        }

        boolean[] str = new boolean[max];
        while(!st.isEmpty()){
            str[st.pop()] = true;
        }

        StringBuilder answer = new StringBuilder();

        for (boolean b : str) {
            answer.append(b ? "X" : "O");
        }

        System.out.println("answer = " + answer.toString());
    }

    private static void upFunc(String substring) {
        int cnt = Integer.parseInt(substring);
        while (cnt-- > 0) {
            position = hm.get(position).up;
        }
    }
    private static void downFunc(String substring) {
        int cnt = Integer.parseInt(substring);
        while (cnt-- > 0) {
            position = hm.get(position).down;
        }
    }
    private static void cancelFunc() {
        st.push(position);
        if(hm.get(position).down == max){
            position = hm.get(position).up;
            hm.get(position).down = max;
        }else if(hm.get(position).up == -1){
            hm.get(hm.get(position).down).up = -1;
            position = hm.get(position).down;
        }else{
            hm.get(hm.get(position).up).down = hm.get(position).down;
            hm.get(hm.get(position).down).up = hm.get(position).up;
            position = hm.get(position).down;
        }
    }

    private static void zFunc() {
        int pop = st.pop();

        if(hm.get(pop).up == -1) {
            hm.get(hm.get(pop).down).up = pop;
        }else if(hm.get(pop).down == max){
            hm.get(hm.get(pop).up).down = pop;
        }else{
            hm.get(hm.get(pop).down).up = pop;
            hm.get(hm.get(pop).up).down = pop;
        }
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
