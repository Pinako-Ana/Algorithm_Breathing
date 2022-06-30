package Algorithm_Breathing.BOJ;

import java.io.*;

public class Main_1343_S5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String replaced = str.replace("XXXX", "AAAA").replace("XX", "BB");

        System.out.println(replaced.contains("X") ? -1 : replaced);

    }

}
