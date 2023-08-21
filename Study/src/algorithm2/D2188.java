package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D2188 {
	static boolean[] visit;
	static int[] link;
	static ArrayList<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		list = new ArrayList<>();
		list.add(null);
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			list.add(new ArrayList<>(s));
			for (int j = 0; j < s; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		link = new int[M + 1];
		for (int i = 1; i <= N; i++) {
			visit = new boolean[N + 1];
			if(dfs(i)) ans++;
		}
		System.out.println(ans);
	}

	private static boolean dfs(int start) {
		visit[start] = true;
		for(int n : list.get(start)) {
			if(link[n] == 0 || (!visit[link[n]] && dfs(link[n]))) {
				link[n] = start;
				return true;
			}
		}
		return false;
	}
}
