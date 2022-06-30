package Algorithm_Breathing.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main_1068_G5 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] nodesParents = br.readLine().split(" ");
        int rmNode = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            hm.put(i, new LinkedList<>());
        }
        int root = 0;
        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(nodesParents[i]);
            if (node == -1) root = i;
            else if (i != rmNode) {
                hm.get(node).add(i);
            }
        }
        hm.remove(rmNode);
        dfs(root, hm);
        System.out.println(count);
    }
    private static void dfs(int i, Map<Integer, List<Integer>> hm) {
        if (!hm.containsKey(i)) {
            return;
        }
        if (hm.get(i).isEmpty()) {
            count++;
            return;
        }
        List<Integer> cur = hm.get(i);
        for (int node : cur) {
            dfs(node, hm);
        }
    }
}
