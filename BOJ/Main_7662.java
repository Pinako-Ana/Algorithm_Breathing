import java.io.*;
import java.util.*;

public class Main_7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            //트리맵 선언
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                String[] x = br.readLine().split(" ");
                int v = Integer.parseInt(x[1]);
                if (x[0].equals("I")) {
                    //트리맵에 v가 key로 있다면 해당 key의 value값과 1을 sum하고
                    //트리맵에 v가 없다면 1을 value로 넣어준다
                    tm.merge(v, 1, Integer::sum);
                } else {
                    //트리맵이 비었다면 그냥 무시
                    if (tm.isEmpty()) continue;

                    int key = (v == 1) ? tm.lastKey() : tm.firstKey();
                    //value가 1보다 크면 -1을 해주고 1이라면 key를 트리맵에서 없애둔다
                    if(tm.get(key) > 1) tm.put(key,tm.get(key) - 1);
                    else tm.remove(key);
                }
            }
            if (tm.isEmpty()) sb.append("EMPTY");
            else sb.append(tm.lastKey()).append(" ").append(tm.firstKey());
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}