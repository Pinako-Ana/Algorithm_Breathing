package Algorithm_Breathing.BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Main_4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Double> hm = new HashMap<>();
        String x = "";
        double cnt = 0.0;
        while ((x = br.readLine()) != null && !x.isEmpty()) {
            cnt += 1.0;
            if (hm.containsKey(x))
                hm.put(x, hm.get(x) + 1.0);
            else
                hm.put(x, 1.0);
        }
        String[] arr = hm.keySet().toArray(new String[0]);
        Arrays.sort(arr);

        for(String elim : arr){
            sb.append(elim).append(" ");
            sb.append(String.format("%.4f",(hm.get(elim)/cnt)*100)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}