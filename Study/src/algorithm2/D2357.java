package algorithm2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2357 {
	static Point tree[];
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		tree = new Point[N * 4];
		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		init(1, N, 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			Point ans = Find(1, N, left, right, 1);
			sb.append(ans.y).append(" ").append(ans.x).append("\n");
		}
		System.out.println(sb);
	}

	private static Point Find(int start, int end, int left, int right, int idx) {
		if (start > right || end < left) {
			return new Point(Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		if (left <= start && end <= right) {
			return tree[idx];
		}

		int mid = (start + end) / 2;

		Point l = Find(start, mid, left, right, idx * 2);
		Point r = Find(mid + 1, end, left, right, idx * 2 + 1);
		return new Point(Math.max(l.x, r.x), Math.min(l.y, r.y));
	}

	private static Point init(int start, int end, int idx) {
		if (start == end)
			return tree[idx] = new Point(arr[start], arr[end]);

		int mid = (start + end) / 2;
		Point left = init(start, mid, idx * 2);
		Point right = init(mid + 1, end, idx * 2 + 1);

		return tree[idx] = new Point(Math.max(left.x, right.x), Math.min(left.y, right.y));
	}
}
