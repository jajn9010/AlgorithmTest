package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D1504 {
	static int N, E;
	static ArrayList<ArrayList<int[]>> nodes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		nodes = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			nodes.add(new ArrayList<>());
			nodes.get(i).add(new int[] {i, i});
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodes.get(from).add(new int[] {to, weight});
			nodes.get(to).add(new int[] {from, weight});
		}
		
		st = new StringTokenizer(br.readLine());
		int U = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int W1 = dijk(1, U);
		int W2 = dijk(1, V);
		int W3 = dijk(U, V);
		int W4 = dijk(U, N);
		int W5 = dijk(V, N);
		
		System.out.println(Math.min(W1 + W3 + W5, W2 + W3 + W4));
	}
	private static int dijk(int from, int to) {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
		
		int[] dis = new int [N + 1];
		int max = 200000001;
		Arrays.fill(dis, max);
		dis[from] = 0;
		q.add(new int[] {from, 0});
		
		while(!q.isEmpty()) {
			int[] minNode = q.poll();
			for(int[] node : nodes.get(minNode[0])) {
				 if(dis[node[0]]>minNode[1]+node[1]) q.offer(new int[]{node[0], dis[node[0]] = minNode[1]+node[1]});
			}
		}
		if(dis[to] == max) {
			System.out.println(-1);
			System.exit(0);
		}
		return dis[to];
	}
}
