package Algorithm_Breathing.BOJ;

import java.io.*;
import java.util.ArrayDeque;


public class Main_1874_S2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> aD = new ArrayDeque<>();

        int k = 1;
        while (N-- > 0) {
            int d = Integer.parseInt(br.readLine());
            if (aD.isEmpty() || aD.peek() < d) {
                while (k <= d) {
                    aD.push(k++);
                    sb.append("+\n");
                }
            }else if(aD.peek() > d){
                System.out.println("NO");
                return;
            }
            aD.pop();
            sb.append("-\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
