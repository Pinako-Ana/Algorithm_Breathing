package Algorithm_Breathing.BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_11725_S2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List[] myList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            myList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] a = br.readLine().split(" ");
            int left = Integer.parseInt(a[0]);
            int right = Integer.parseInt(a[1]);
            myList[left].add(right);
            myList[right].add(left);
        }

        int[] arr = bfs(myList);
        for(int i = 2; i <= N ; i++){
            sb.append(arr[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] bfs(List[] myList) {
        Queue<Integer> myQ = new LinkedList<>();
        myQ.add(1);
        boolean[] visit = new boolean[myList.length];
        visit[1] = true;
        int[] arr = new int[myList.length];

        while (!myQ.isEmpty()) {
            int cur = myQ.poll();
            int size = myList[cur].size();
            for (int i = 0; i < size; i++) {
                int num = (int) myList[cur].get(i);
                if(visit[num]) continue;
                arr[num] = cur;
                myQ.add(num);
                visit[num] = true;
            }
        }

        return arr;
    }
}
