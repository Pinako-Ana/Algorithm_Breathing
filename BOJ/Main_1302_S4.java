package BOJ;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main_1302_S4 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> hm = new HashMap<>();

        while(N-- > 0) {
            String str = br.readLine();
            if(hm.putIfAbsent(str,1) != null)
                hm.put(str,hm.get(str) + 1);
        }

        TreeMap<Integer, TreeSet<String>> tm = new TreeMap<>();

        for (Map.Entry<String,Integer> entry : hm.entrySet()){
            if(tm.containsKey(entry.getValue())){
                tm.get(entry.getValue()).add(entry.getKey());
            }else{
                TreeSet<String> ts = new TreeSet<>();
                ts.add(entry.getKey());
                tm.put(entry.getValue(),ts);
            }
        }

        bw.write(tm.lastEntry().getValue().first());
        bw.flush();
        bw.close();
        br.close();
    }
}
