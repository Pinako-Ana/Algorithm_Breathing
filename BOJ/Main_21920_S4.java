package Algorithm_Breathing.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_21920_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int X = Integer.parseInt(br.readLine());
        double count = 0;
        double sum = 0;
        for(String a : arr){
            int num = Integer.parseInt(a);
            if(gcd(num, X) == 1){
                count++;
                sum += num;
            }
        }
        System.out.printf("%.6f%n", sum / count);

    }
    private static int gcd(int a, int b){
        return (b == 0) ? a : gcd(b, a % b);
    }
}
