package Algorithm_Breathing.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_15829_B2 {
    static long P = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> hm = new HashMap<>();

        String[] arr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int k = 1;
        for (String a : arr) {
            hm.put(a, k++);
        }

        int N = Integer.parseInt(br.readLine());
        String[] alpha = br.readLine().split("");

        long sum = 0L;
        long pow = 1L;
        for (int i = 0; i < N; i++) {
            sum += ((hm.get(alpha[i]) * pow) % P);
            pow = (pow * 31) % P;
        }

        System.out.println(sum % P);

    }
}
