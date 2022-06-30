package Algorithm_Breathing.BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main_14675_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        while (N-- > 1) {
            String[] x = br.readLine().split(" ");
            int a = Integer.parseInt(x[0]);
            int b = Integer.parseInt(x[1]);
            arr[a].add(b);
            arr[b].add(a);
        }

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            String[] x = br.readLine().split(" ");
            if (x[0].equals("2")) {
                sb.append("yes");
            } else {
                int k = Integer.parseInt(x[1]);
                if (arr[k].size() == 1) {
                    sb.append("no");
                } else {
                    sb.append("yes");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
