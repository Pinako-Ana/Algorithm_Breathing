package Algorithm_Breathing.BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main_21942_G2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        HashMap<String, String> hm = new HashMap<>();
        List<Node> fine = new ArrayList<>();

        String[] arr = br.readLine().split(" ");

        int N = Integer.parseInt(arr[0]);
        int F = Integer.parseInt(arr[2]);

        while (N-- > 0) {
            String[] x = br.readLine().split(" ");
            String key = x[2] + x[3];
            if (hm.containsKey(key)) {



            } else {
                hm.put(key,x[0] + " " + x[1]);
            }
        }


    }
    static class Node{
        String name;
        int fine;
        public Node(String name, int fine){
            this.name = name;
            this.fine = fine;
        }
    }

}
