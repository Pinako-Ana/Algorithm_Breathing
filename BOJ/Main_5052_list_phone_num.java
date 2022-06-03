import java.io.*;
import java.util.HashMap;

public class Main_5052_list_phone_num {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        LABEL:
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int j = 0; j < n; j++)
                arr[j] = br.readLine();

            Trie myTrie = new Trie(new TrieNode());

            for (int j = 0; j < n; j++) {
                if (!myTrie.insert(arr[j])) {
                    sb.append("NO").append("\n");
                    continue LABEL;
                }
            }
            sb.append("YES").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        TrieNode trieNode;

        public Trie(TrieNode trieNode) {
            this.trieNode = trieNode;
        }

        public boolean insert(String str) {
            TrieNode thisNode = this.trieNode;
            for (int i = 0; i < str.length(); i++) {
                TrieNode curNode = thisNode.getChildeNodes().get(str.charAt(i));
                if (curNode == null) {
                    TrieNode newTrieNode = new TrieNode();
                    thisNode.getChildeNodes().put(str.charAt(i), newTrieNode);
                    thisNode = newTrieNode;
                } else {
                    if (curNode.isLastChar())
                        return false;

                    if(i == str.length()-1)
                        return false;
                    thisNode = curNode;
                }
            }
            thisNode.setIsLastChar(true);
            return true;
        }

    }

    static class TrieNode {
        HashMap<Character, TrieNode> childeNodes = new HashMap<>();
        boolean isLastChar;

        public HashMap<Character, TrieNode> getChildeNodes() {
            return this.childeNodes;
        }

        public boolean isLastChar() {
            return this.isLastChar;
        }

        public void setIsLastChar(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }

    }
}