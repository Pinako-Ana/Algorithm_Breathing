package BOJ;

import java.io.*;
import java.util.TreeSet;

public class Main_5618_B3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int gcdNumber = (n == 2 ? gcd(a, b) : gcd(a, gcd(b, Integer.parseInt(arr[2]))));
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 1; i <= Math.sqrt(gcdNumber); i++) {
            if (gcdNumber % i == 0) {
                ts.add(i);
                ts.add(gcdNumber / i);
            }
        }
        while (!ts.isEmpty()) {
            sb.append(ts.pollFirst()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
