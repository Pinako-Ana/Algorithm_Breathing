import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main_21944_G3 {
    static HashMap<Integer, TreeMap<Integer, TreeSet<Integer>>> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        hm = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] x = br.readLine().split(" ");
            int P = Integer.parseInt(x[0]);
            int L = Integer.parseInt(x[1]);
            int G = Integer.parseInt(x[2]);
            addF(P, L, G);
        }

//        System.out.println(hm.size());


        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            String[] x = br.readLine().split(" ");
            String inst = x[0];
            int f = Integer.parseInt(x[1]);
            if (inst.charAt(0) == 'a') {
                addF(f, Integer.parseInt(x[2]), Integer.parseInt(x[3]));
            } else if (inst.charAt(0) == 's') {
                solved(f);
            } else if (inst.equals("recommend")) {
                sb.append(recommend(f, Integer.parseInt(x[2]))).append("\n");
            } else if (inst.contains("2")) {
                sb.append(recommend2(f)).append("\n");
            } else if (inst.contains("3")) {
                sb.append(recommend3(f, Integer.parseInt(x[2]))).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int recommend(int G, int x) {

        return 100;
//        return (x == 1 ? hm.get(G).lastEntry().getValue().last(): hm.get(G).firstEntry().getValue().first());
    }

    private static int recommend2(int x) {
        PriorityQueue<Node> pq = null;
        if (x == 1) {
            pq = new PriorityQueue<>((o1, o2) -> {
                if (o1.x > o2.x) return -1;
                else if (o1.x == o2.x) return o2.y - o1.y;
                return 1;
            });
            for (int al : hm.keySet()) {
                pq.offer(new Node(hm.get(al).lastKey(), hm.get(al).lastEntry().getValue().last()));
            }
        }
        if (x == -1) {
            pq = new PriorityQueue<>((o1, o2) -> {
                if (o1.x > o2.x) return 1;
                else if (o1.x == o2.x) return o1.y - o2.y;
                return -1;
            });
            for (int al : hm.keySet()) {
                pq.offer(new Node(hm.get(al).firstKey(), hm.get(al).firstEntry().getValue().first()));
            }

        }
        return pq.peek().y;
    }

    private static int recommend3(int x, int L) {
        PriorityQueue<Node> pq = null;
        if(x == 1) {
            pq = new PriorityQueue<>((o1, o2) -> {
                if(o1.x > o2.x) return 1;
                else if(o1.x == o2.x) return o1.y - o2.y;
                return -1;
            });

            for(int al : hm.keySet()){
                for(int na : hm.get(al).keySet()){
                    if(na >= L){
                        pq.offer(new Node(na, hm.get(al).get(na).first()));
                    }
                }
            }
        }else{
            pq = new PriorityQueue<>((o1, o2) -> {
                if(o1.x > o2.x) return -1;
                else if(o1.x == o2.x) return o2.y - o1.y;
                return 1;
            });

            for(int al : hm.keySet()){
                for(int na : hm.get(al).keySet()){
                    if(na < L){
                        pq.offer(new Node(na, hm.get(al).get(na).last()));
                    }
                }
            }

        }
        return pq.isEmpty() ? -1 : pq.peek().y;
    }

    private static void solved(int P) {
        OUT:
        for (int k : hm.keySet()) {
            for (int k1 : hm.get(k).keySet()) {
                if (hm.get(k).get(k1).contains(P)) {
                    hm.get(k).get(k1).remove(P);
                    break OUT;
                }
            }
        }
    }

    private static void addF(int P, int L, int G) {
        if (hm.containsKey(G)) {
            TreeMap<Integer, TreeSet<Integer>> hm2 = hm.get(G);
            if (hm2.containsKey(L)) {
                hm2.get(L).add(P);
            } else {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(P);
                hm2.put(L, ts);
            }
        } else {
            TreeMap<Integer, TreeSet<Integer>> hm2 = new TreeMap<>();
            TreeSet<Integer> ts = new TreeSet<>();
            ts.add(P);
            hm2.put(L, ts);
            hm.put(G, hm2);
        }

    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
