package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D17267 {
	static int N, M, L, R;
	static int[][] map, ans;
	static Queue<Point> q;
	static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		ans = new int[N][M];
		Point start = new Point(0, 0, L, R);

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char ch = str.charAt(j);
				if (ch == '2') {
					start.x = i;
					start.y = j;
				}
				map[i][j] = ch - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ans[i][j] = -1;
			}
		}

		ans[start.x][start.y] = L + R;
		q = new LinkedList<>();

		q.add(start);

		bfs();

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (ans[i][j] != -1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Point curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dy[i];
				int ny = curr.y + dx[i];
				int nl = curr.l;
				int nr = curr.r;

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (map[nx][ny] != 0)
					continue;
				if (i == 2)
					nl--;
				if (i == 3)
					nr--;
				if (nl < 0 || nr < 0)
					continue;
				if (ans[nx][ny] >= nl + nr)
					continue;
				ans[nx][ny] = nl + nr;
				q.add(new Point(nx, ny, nl, nr));
			}
		}

	}

	private static class Point {
		int x, y, l, r;

		Point(int x, int y, int l, int r) {
			this.x = x;
			this.y = y;
			this.l = l;
			this.r = r;
		}
	}
}
