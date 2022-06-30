package Algorithm_Breathing.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main_11508_S4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> ml = new ArrayList<>();

        while (N-- > 0) {
            ml.add(Integer.parseInt(br.readLine()));
        }

        ml.sort(Comparator.reverseOrder());

        int sum = 0;

        for (int i = 0; i < ml.size(); i++) {
            if (i % 3 != 2) {
                sum += ml.get(i);
            }
        }
        System.out.println(sum);

    }

}
