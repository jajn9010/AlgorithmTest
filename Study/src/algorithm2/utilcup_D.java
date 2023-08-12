package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class utilcup_D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] list = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int Q = Integer.parseInt(br.readLine());
		int[][] rotate = new int[N][N];
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(num == 1) {
				int n = Integer.parseInt(st.nextToken());
				int temp = list[n - 1][N - 1];
				for (int j = N - 1; j > 0; j--) {
					list[n - 1][j] = list[n - 1][j - 1];
				}
				list[n - 1][0] = temp;
			} else {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						rotate[k][N - j - 1] = list[j][k];
					}
				}
				list = rotate;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(list[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
