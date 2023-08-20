package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class D19585 {
    public static class Trie {
        boolean isLastChild; 
        Trie[] childs;

        public Trie() {
            this.isLastChild = false;
            this.childs = new Trie[26];
        }

        public Trie insertAndGet(char ch) {
            if(childs[ch - 'a'] == null) childs[ch - 'a'] = new Trie();
            return childs[ch - 'a'];
        }

        public Trie getTrie(char ch) {
            return childs[ch - 'a'];
        }

        public void setIsLastChild() {
            this.isLastChild = true;
        }
    }

    static Trie trie = new Trie();
    static HashSet<String> nickNameSet = new HashSet<>();
    static int cMin, cMax, nMin, nMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        cMin = nMin = 1001;
        cMax = nMax = 0;

        for(int i = 0; i < C; i++) {
            String str = br.readLine();
            int len = str.length();
            if(len < cMin) cMin = len;
            if(len > cMax) cMax = len;

            Trie cTrie = trie;
            for(int j = 0; j < len; j++) {
                cTrie = cTrie.insertAndGet(str.charAt(j));
            }
            cTrie.setIsLastChild();
        }

        for(int i = 0; i < N; i++) {
            String str  = br.readLine();
            int len = str.length();
            if(len < nMin) nMin = len;
            if(len > nMax) nMax = len;
            nickNameSet.add(str);
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < Q; i++) {
            String str = br.readLine();
            boolean chk = str.length() > cMax + nMax ? false : searchTeam(str);
            if(chk) sb.append("Yes").append("\n");
            else sb.append("No").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean searchTeam(String str) {
        int len = str.length();

        Trie cTrie = trie;

        for (int i = 0; i < len; i++) {
            if (len - i < nMin)
                break;
            cTrie = cTrie.getTrie(str.charAt(i));
            if (cTrie == null) break;
            if (cTrie.isLastChild) {
                if (nickNameSet.contains(str.substring(i+1)))
                    return true;
            }
        }
        return false;
    }
}
