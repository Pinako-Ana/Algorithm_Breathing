package Algorithm_Breathing.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main_1758_S4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> ml = new ArrayList<>();

        while (N-- > 0) {
            ml.add(Integer.parseInt(br.readLine()));
        }

        ml.sort(Comparator.reverseOrder());

        N = ml.size();

        long sum = 0L;
        for (int i = 0; i < N; i++) {
            int k = ml.get(i) - (i + 1 - 1);
            sum += Math.max(k, 0);
        }

        System.out.println(sum);

    }
}
