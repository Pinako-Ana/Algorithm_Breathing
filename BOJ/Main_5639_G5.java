package Algorithm_Breathing.BOJ;

import java.io.*;

public class Main_5639_G5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String x = "";
        BST myBST = new BST();

        while ((x = br.readLine()) != null && !x.isEmpty()) {
            myBST.add(Integer.parseInt(x));
        }

        bw.write(myBST.postOrder().trim());
        bw.flush();
        bw.close();
        br.close();

    }

    static class BST {
        Integer node;
        BST leftBST;
        BST rightBST;

        public void add(int num) {
            if (node == null) {
                node = num;
            } else {
                if (node > num) {
                    if (leftBST == null) {
                        leftBST = new BST();
                    }
                    leftBST.add(num);
                } else {
                    if (rightBST == null) {
                        rightBST = new BST();
                    }
                    rightBST.add(num);
                }
            }
        }

        public int size() {
            if (node == null) {
                return 0;
            } else {
                int lSize = (leftBST == null ? 0 : leftBST.size());
                int rSize = (rightBST == null ? 0 : rightBST.size());
                return 1 + lSize + rSize;
            }
        }

        public String postOrder() {
            return (leftBST == null ? "" : leftBST.postOrder()) +
                    (rightBST == null ? "" : rightBST.postOrder()) +
                    node + "\n";
        }
    }
}
//https://girawhale.tistory.com/59