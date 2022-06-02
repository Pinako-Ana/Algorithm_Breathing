package BOJ;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_1991_S1_2 {
    static Map<String, List<String>> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        hm = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] line = br.readLine().split(" ");
            List<String> ml = new ArrayList<>();
            ml.add(line[1]);
            ml.add(line[2]);
            hm.put(line[0], ml);
        }

        myOrder("A", sb, 1);
        sb.append("\n");
        myOrder("A", sb, 2);
        sb.append("\n");
        myOrder("A", sb, 3);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    private static void myOrder(String a, StringBuilder sb, int mode) {
        if (a.equals(".")) return;
        if (mode == 1) sb.append(a);
        myOrder(hm.get(a).get(0), sb, mode);
        if (mode == 2) sb.append(a);
        myOrder(hm.get(a).get(1), sb, mode);
        if (mode == 3) sb.append(a);
    }
}
