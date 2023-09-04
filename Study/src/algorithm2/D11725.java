package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D11725 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			tree.add(new ArrayList<>());
		}
		
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		boolean[] visited = new boolean[n];
		int[] parentNode = new int[n];
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(0);
		visited[0] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int node : tree.get(curr)) {
				if(!visited[node]) {
					visited[node] = true;
					q.add(node);
					parentNode[node] = curr;
				}
			}
		}
		
		for (int i = 1; i < n; i++) {
			System.out.println(parentNode[i] + 1);
		}
	}
}
