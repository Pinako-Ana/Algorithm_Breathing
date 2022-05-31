package BOJ;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main_19583_S2 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        String[] SEQ = br.readLine().split(" ");
        String x = "";
        Map<String, Integer> hm = new HashMap<>();
        while ((x = br.readLine()) != null) {
            String[] log = x.split(" ");
            if (!hm.containsKey(log[1])) {
                if (log[0].compareTo(SEQ[0]) <= 0) {
                    hm.put(log[1], 1);
                }
            } else {
                if (log[0].compareTo(SEQ[1]) >= 0 && log[0].compareTo(SEQ[2]) <= 0) {
                    hm.put(log[1], 2);
                }
            }
        }
        for(String name: hm.keySet()){
            if(hm.get(name) == 2) count++;
        }
        System.out.println(count);

    }

    private static boolean checkExit(String s, String s1, String s2) {
        return s.compareTo(s1) >= 0 && s.compareTo(s2) <= 0;
    }

    private static boolean checkEnter(String s, String s1) {
        return s.compareTo(s1) <= 0;
    }

}