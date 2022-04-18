package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_1269_S3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int numA = Integer.parseInt(arr[0]);
        int numB = Integer.parseInt(arr[1]);

        String[] arrA = br.readLine().split(" ");
        String[] arrB = br.readLine().split(" ");

        Set<String> hsA = new HashSet<>(Arrays.asList(arrA));
        Set<String> hsB = new HashSet<>(Arrays.asList(arrB));

        int cnt = 0;
        for (String a : hsA) {
            if(hsB.contains(a))
                cnt++;
        }
        System.out.println(numA + numB - 2 * cnt);
    }
}
