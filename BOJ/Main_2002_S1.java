package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2002_S1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> start = new HashMap<>();
        Map<String, Integer> end = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        int k = N;
        while (k-- > 0) {
            start.put(br.readLine(), k);
            System.out.println("k = " + k);
        }
        k = N;
        while (k-- > 0) {
            end.put(br.readLine(), k);
        }
        int count = 0;
//        for (String car : start.keySet()) {
//            if (start.get(car) > end.get(car)) {
//                count++;
//            }
//        }
//        System.out.println(count);
    }
}
