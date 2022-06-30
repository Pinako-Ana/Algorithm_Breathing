package Algorithm_Breathing.BOJ;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main_17219_S4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);

        Map<String, String> hm = new HashMap<>();

        while (N-- > 0) {
            String[] x = br.readLine().split(" ");
            hm.put(x[0], x[1]);
        }
        while (M-- > 0) {
            sb.append(hm.get(br.readLine())).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
