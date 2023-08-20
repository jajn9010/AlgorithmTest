package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class D19585_copy {
    static int C, N;
    static final Trie colorCursor = new Trie('S', false);
    static final HashSet<String> nickNameSet = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < C; i++) {
            String str = br.readLine();
            insertTrie(str, colorCursor);
        }

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            nickNameSet.add(str);
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < Q; i++) {
            String str = br.readLine();
            ArrayList<Integer> points = new ArrayList<>();
            markPoint(str, colorCursor, points);
            sb.append(find(str, points)).append("\n");
        }
        System.out.println(sb);
    }

    private static String find(String str, ArrayList<Integer> points) {
        for(int point : points) {
            if(nickNameSet.contains(str.substring(point + 1))) return "Yes";
        }
        return "No";
    }

    private static void markPoint(String str, Trie cursor, ArrayList<Integer> points) {
        for(int i = 0; i < str.length(); i++) {
            cursor = cursor.nextTrie(str.charAt(i));
            if(cursor == null) return;
            if(cursor.isLastChild && str.length() - (i + 1) <= 1000) {
                points.add(i);
            }
        }
    }

    private static void insertTrie(String str, Trie cursor) {
        for(int i = 0; i < str.length(); i++) {
            Trie trie = new Trie(str.charAt(i), (i == str.length() - 1));
            cursor.insert(trie);
            cursor = cursor.nextTrie(str.charAt(i));
        }
    }

    public static class Trie {
        char name;
        Trie[] childs = new Trie[26];
        boolean isLastChild;

        Trie(char name, boolean isLastChild) {
            this.name = name;
            this.isLastChild = isLastChild;
        }

        public void insert(Trie trie) {
            int nextIdx = trie.name - 'a';
            if(childs[nextIdx] == null) {
                childs[nextIdx] = trie;
            }
            childs[nextIdx].isLastChild = childs[nextIdx].isLastChild == true ? true : trie.isLastChild;
        }

        public Trie nextTrie(char nextName) {
            int nextIdx = nextName - 'a';
            return childs[nextIdx];
        }
    }
}
