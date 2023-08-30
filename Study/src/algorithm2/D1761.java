package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class D1761 {
    public static class Node {
        public int num, dist;

        public Node (int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static int[] p_len, depth, parents;
    static List<Node>[] tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        tree = new List[n + 1];

        for(int i = 0; i <= n; i++) {
            tree[i] = new LinkedList<Node>();
        }

        StringTokenizer st;
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            tree[a].add(new Node(b, dist));
            tree[b].add(new Node(a, dist));
        }

        depth = new int[n + 1];
        p_len = new int[n + 1];
        parents = new int[n + 1];

        init(1, 1, 1, 0);

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(find(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static Object find(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int ans = 0;

        while(depth[a] > depth[b]) {
            ans += p_len[a];
            a = parents[a];
        }

        while(a != b) {
            ans += p_len[a] + p_len[b];
            a = parents[a];
            b = parents[b];
        }
        
        return ans;
    }

    private static void init(int node, int p_node, int level, int len) {
        parents[node] = p_node;
        p_len[node] = len;
        depth[node] = level;

        for(Node n : tree[node]) {
            int childNode = n.num;
            int childLen = n.dist;

            if(childNode == p_node) continue;

            init(childNode, node, level + 1, childLen);
        }
    }
}
