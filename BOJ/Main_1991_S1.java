package BOJ;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_1991_S1 {
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

        preOrder("A", sb);
        sb.append("\n");
        inOrder("A", sb);
        sb.append("\n");
        postOrder("A", sb);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    private static void preOrder(String a, StringBuilder sb) {
        if (a.equals(".")) return;
        sb.append(a);
        preOrder(hm.get(a).get(0), sb);
        preOrder(hm.get(a).get(1), sb);
    }

    private static void inOrder(String a, StringBuilder sb) {
        if (a.equals(".")) return;
        inOrder(hm.get(a).get(0), sb);
        sb.append(a);
        inOrder(hm.get(a).get(1), sb);
    }

    private static void postOrder(String a, StringBuilder sb) {
        if (a.equals(".")) return;
        postOrder(hm.get(a).get(0), sb);
        postOrder(hm.get(a).get(1), sb);
        sb.append(a);
    }

}
