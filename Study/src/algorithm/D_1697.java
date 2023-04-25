package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D_1697 {
	static int n, k;
	static int[] visited = new int[100001];
	static Queue<Integer> q;

	static int bfs(int x) {
		q = new LinkedList<>();
		int index = n;
		int num = 0;

		visited[index] = 1;
		q.add(x);
		while (!q.isEmpty()) {
			num = q.remove();
			if (num == k) {
				return visited[num] - 1;
			}
			if (num - 1 >= 0 && visited[num - 1] == 0) {
				visited[num - 1] = visited[num] + 1;
				q.add(num - 1);
			}
			if (num + 1 <= 100000 && visited[num + 1] == 0) {
				visited[num + 1] = visited[num] + 1;
				q.add(num + 1);
			}
			if (2 * num <= 100000 && visited[2 * num] == 0) {
				visited[2 * num] = visited[num] + 1;
				q.add(2 * num);
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int result = bfs(n);
		System.out.println(result);
	}
}
