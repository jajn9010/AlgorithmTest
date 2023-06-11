package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1149 {
	static int r = 0, g = 1, b = 2;
	static int[][] cost, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			cost[i][r] = Integer.parseInt(st.nextToken());
			cost[i][g] = Integer.parseInt(st.nextToken());
			cost[i][b] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][r] = cost[0][r];
		dp[0][g] = cost[0][g];
		dp[0][b] = cost[0][b];
		
		System.out.println(Math.min(paint(N-1, r), Math.min(paint(N-1, g), paint(N-1, b))));
	}
	private static int paint(int n, int color) {
		if(dp[n][color] == 0) {
			if(color == r) {
				dp[n][r] = Math.min(paint(n - 1, g), paint(n - 1, b)) + cost[n][r];
			}
			else if(color == g) {
				dp[n][g] = Math.min(paint(n - 1, r), paint(n - 1, b)) + cost[n][g];
			}
			else {
				dp[n][b] = Math.min(paint(n - 1, r), paint(n - 1, g)) + cost[n][b];
			}
		}
		return dp[n][color];
	}
}
