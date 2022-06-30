import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_24498_blobnom {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Arrays.toString(arr));


//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//        br.close();
    }


}