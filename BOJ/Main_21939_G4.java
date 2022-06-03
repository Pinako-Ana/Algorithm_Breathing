import java.io.*;
import java.util.*;

public class Main_21939_G4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        TreeMap<Integer, TreeSet<Integer>> tm = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            String[] x = br.readLine().split(" ");
            int P = Integer.parseInt(x[0]);
            int L = Integer.parseInt(x[1]);

            if(tm.containsKey(L)){
                tm.get(L).add(P);
            }else{
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(P);
                tm.put(L,ts);
            }
        }

        int M = Integer.parseInt(br.readLine());
        while(M-- > 0){
            String[] x = br.readLine().split(" ");
            int a = Integer.parseInt(x[1]);
            if(x[0].equals("add")){
                int b = Integer.parseInt(x[2]);
                if(tm.containsKey(b)){
                    tm.get(b).add(a);
                }else{
                    TreeSet<Integer> ts = new TreeSet<>();
                    ts.add(a);
                    tm.put(b,ts);
                }
            }else if(x[0].equals("recommend")){
                if(a == 1){
                    sb.append(tm.lastEntry().getValue().last());
                }else{
                    sb.append(tm.firstEntry().getValue().first());
                }
                sb.append("\n");
            }else if(x[0].equals("solved")){
                List<Integer> rmList = new ArrayList<>();
                for(Map.Entry<Integer,TreeSet<Integer>> entry : tm.entrySet()){
                    entry.getValue().remove(a);
                    if(entry.getValue().isEmpty()){
                        rmList.add(entry.getKey());
                    }
                }
                for(int n : rmList){
                    tm.remove(n);
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
