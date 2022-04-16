package BOJ;

import java.io.*;
import java.util.HashSet;
import java.util.TreeSet;

public class Main_2776_S4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){
            int question = Integer.parseInt(br.readLine());
            HashSet<Integer> hs = new HashSet<>();
            String[] arr = br.readLine().split(" ");
            for(String a : arr){
                hs.add(Integer.parseInt(a));
            }
            int check = Integer.parseInt(br.readLine());
            String[] arr2 = br.readLine().split(" ");
            for(String a : arr2){
                if(hs.contains(Integer.parseInt(a)))
                    sb.append(1);
                else sb.append(0);
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
