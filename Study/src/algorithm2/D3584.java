package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3584 {
	static int[] parent;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			parent = new int[N + 1];
			visited = new boolean[N + 1];
			
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				parent[b] = a;
			}
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			while(a > 0) {
				visited[a] = true;
				a = parent[a];
			}
			
			while(b > 0) {
				if(visited[b]) {
					sb.append(b).append("\n");
					break;
				}
				b = parent[b];
			}
		}
		
		System.out.println(sb);
	}
}
