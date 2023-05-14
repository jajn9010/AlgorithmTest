package busanUniCodeRace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class C {
	static int w, h, dx = -1;
	static int[] dy = { -1, 1 };
	static int[][] map;
	static Queue<Pair> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		map = new int[h][w];
		q = new LinkedList<>();

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 2)
					q.add(new Pair(i, j));
				map[i][j] = a;
			}
		}
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			System.out.println(bfs(curr.x, curr.y));
		}
		
	}

	public static int bfs(int x, int y) {
		Queue<Pair> bfsq = new LinkedList<>();
		
		bfsq.add(new Pair(x, y));
		while(!bfsq.isEmpty()) {
			Pair curr = bfsq.poll();
			for(int i = 0; i < 2; i++) {
				int nextX = curr.x + dx;
				int nextY = curr.y + dy[i];
				
				if(nextX < 0 || nextX > w || nextY < 0) {
					continue;
				}
				if(map[nextX][nextY] == 0) {
					continue;
				}
				if(map[nextX][curr.y] == 1 && map[nextX][nextY] != 1) {
					
				}
			}
		}
		return -1;
	}
}
