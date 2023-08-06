package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D2533 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[][] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int n) {
        visited[n] = true;
        dp[n][0] = 0;
        dp[n][1] = 1;
        
        for(int child : graph[n]) {
            if(!visited[child]) {
                dfs(child);
                dp[n][0] += dp[child][1];
                dp[n][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
