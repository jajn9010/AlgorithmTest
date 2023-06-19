package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D9091 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] ans = new String[10000];

            q.add(a);
            visited[a] = true;
            Arrays.fill(ans,  "");

            while (!q.isEmpty() && !visited[b]) {
                int curr = q.poll();

                int D = (2 * curr) % 10000;
                int S = curr == 0 ? 9999 : curr - 1;
                int L = (curr % 1000) * 10 + curr / 1000;
                int R = (curr % 10) * 1000 + curr / 10;

                if (!visited[D]) {
                    q.add(D);
                    visited[D] = true;
                    ans[D] = ans[curr] + "D";
                }
                if (!visited[S]) {
                    q.add(S);
                    visited[S] = true;
                    ans[S] = ans[curr] + "S";
                }
                if (!visited[L]) {
                    q.add(L);
                    visited[L] = true;
                    ans[L] = ans[curr] + "L";
                }
                if (!visited[R]) {
                    q.add(R);
                    visited[R] = true;
                    ans[R] = ans[curr] + "R";
                }
            }
            System.out.println(ans[b]);
        }
    }
}
