package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class D11724 {
    static int n, m, cnt = 0;
    static int[][] node;
    static boolean[] visited;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        node = new int[n+1][n+1];
        visited = new boolean[n + 1];

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            node[a][b] = node[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == false) {
                bfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void bfs(int index) {
        if (visited[index] == true) {
            return;
        } else {
            visited[index] = true;

            for (int i = 1; i <= n; i++) {
                if (node[index][i] == 1) {
                    bfs(i);
                }
            }
        }
    }
}
