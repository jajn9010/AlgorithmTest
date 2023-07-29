package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2243 {
	
	static int size = 1000001;
	static int[] tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		tree = new int [size * 4];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				int candy = query(1, size, 1, b);
				sb.append(candy).append("\n");
			} else {
				int c = Integer.parseInt(st.nextToken());
				update(1, size, 1, b, c);
			}
		}
		System.out.println(sb);
	}

	private static void update(int start, int end, int idx, int target, int dif) {
		if(target < start || end < target) return;
		
		tree[idx] += dif;
		if(start == end) return;
		
		int mid = (start + end) / 2;
		update(start, mid, idx * 2, target, dif);
		update(mid + 1, end, idx * 2 + 1, target, dif);
	}

	private static int query(int start, int end, int idx, int target) {
		if(start == end) {
			update(1, size, 1, start, -1);
			return start;
		}
		
		int mid = (start + end) / 2;
		if(target <= tree[idx * 2]) return query(start, mid, idx * 2, target);
		else return query(mid + 1, end, idx * 2 + 1, target - tree[idx * 2]);
	}
}
