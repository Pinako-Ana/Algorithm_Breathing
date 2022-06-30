package Algorithm_Breathing.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17626_S3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 5);
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) dp[i] = 1;
                else {
                    dp[i] = Math.min(dp[i - 1] + 1, Math.min(dp[i], dp[i - (j * j)] + 1));
                }
            }
        }

        System.out.println(dp[N]);

    }
}
