package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chocolate_B {
	static Queue<Pair> q;
	static int cnt, ans;
	static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
	static boolean[][] visited;
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		while(T-- > 0) {
			map = new char[3][3];
			for (int i = 0; i < 3; i++) {
				String str = br.readLine();
				for (int j = 0; j < 3; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'O') {
						q.add(new Pair(i, j));
					}
				}
			}
			visited = new boolean[3][3];
			cnt = 0;
			ArrayList<Integer> list = new ArrayList<>();
			while(!q.isEmpty()) {
				ans = 1;
				Pair curr = q.poll();
				if(bfs(curr.x, curr.y)) {
					cnt++;
					list.add(ans);
				}
			}
			
			Collections.sort(list);
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			if(N == 0 && list.size() == 0) {
				sb.append(1).append("\n");
			} else {
				boolean check = false;
				for (int i = 0; i < N; i++) {
					if(list.size() < N || list.get(i) != Integer.parseInt(st.nextToken())) {
						check = false;
						break;
					} else check = true;
				}
				if(check == true) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	private static boolean bfs(int x, int y) {
		if(visited[x][y]) return false;
		
		Queue<Pair> bfsq = new LinkedList<>();
		visited[x][y] = true;
		
		bfsq.add(new Pair(x, y));
		
		while(!bfsq.isEmpty()) {
			Pair curr = bfsq.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = curr.x + dx[i];
				int nextY = curr.y + dy[i];
				
				if(nextX >= 0 && nextX < 3 && nextY >= 0 && nextY < 3 && !visited[nextX][nextY] && map[nextX][nextY] == 'O') {
					visited[nextX][nextY] = true;
					ans++;
					bfsq.add(new Pair(nextX, nextY));
				}
			}
		}
		return true;
	}

	private static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
