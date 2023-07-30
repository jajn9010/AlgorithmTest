package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D12920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		LinkedList<int[]> items = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			for (int j = k; j > 0; j /= 2) {
				int pack = j - (j / 2);
				items.add(new int[] { v * pack, c * pack });
			}
		}

		int[][] ans = new int[items.size()][m + 1];
		for (int i = 0; i < items.size(); i++) {
			int[] item = items.get(i);
			for (int j = 0; j < m + 1; j++) {
				if (j >= item[0]) ans[i][j] = Math.max(i == 0 ? item[1] : item[1] + ans[i - 1][j - item[0]], i == 0 ? 0 : ans[i - 1][j]);
				else if (i != 0) ans[i][j] = ans[i - 1][j];
			}
		}
		System.out.println(ans[items.size() - 1][m]);
	}
}
