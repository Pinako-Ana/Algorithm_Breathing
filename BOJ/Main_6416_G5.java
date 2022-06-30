package Algorithm_Breathing.BOJ;

import java.io.*;
import java.util.*;

public class Main_6416_G5 {
    static Map<String, List<String>> hm = new HashMap<>();
    static Map<String, Boolean> visited = new HashMap<>();

    static int k = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<String> u = new HashSet<>();

        Set<String> v = new HashSet<>();

        while (true) {
            String x = br.readLine();

            if (x.equals("")) continue;
            if (x.equals("-1 -1")) break;

            String[] arr = x.split(" {2}");
            System.out.println("arr.si = " + arr.length);

            for (String a : arr) {
                if (a.equals("0 0")) {
                    int count = 0;
                    for (String root : u) {
                        if(v.contains(root)){

                        }
                    }

                    u.clear();
                    v.clear();
                    hm.clear();
                    visited.clear();
                } else {
                    String[] w = a.split(" ");
                    u.add(w[0]);
                    v.add(w[1]);
                    visited.putIfAbsent(w[0],false);
                    visited.putIfAbsent(w[1], false);
                    if (!hm.containsKey(w[0])) {
                        List<String> ml = new ArrayList<>();
                        ml.add(w[1]);
                        hm.put(w[0], ml);
                    } else {
                        hm.get(w[0]).add(w[1]);
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static String bfs(String root) {
        Queue<String> mq = new LinkedList<>();
        mq.add(root);
        visited.put(root,true);

        StringBuilder result = new StringBuilder();
        result.append("Case ").append(k++).append(" ");

        while (!mq.isEmpty()) {
            String cur = mq.poll();

            List<String> vList = hm.get(cur);

            if (vList == null) continue;

            for (String vNode : vList) {
                if (visited.get(vNode)) {
                    return result.append("is not a tree.").toString();
                }
                mq.offer(vNode);
                visited.put(vNode, true);
            }
        }
        return result.append("is a tree.").toString();
    }


}
