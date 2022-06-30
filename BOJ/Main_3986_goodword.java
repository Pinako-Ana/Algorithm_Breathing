package Algorithm_Breathing.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_3986_goodword {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N ; i++){
            String x = br.readLine();
            if(check(x)) cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
    private static boolean check(String x){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < x.length(); i++){
            char ch = x.charAt(i);
            if(!st.isEmpty() && st.peek() == ch){
                st.pop();
            }else st.push(ch);
        }
        return st.isEmpty() ? true : false;
    }


}