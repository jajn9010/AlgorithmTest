package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1027 {
	static int N;
	static int[] buildings;
	static int[] ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		buildings = new int[N];
		ans = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N - 1; i++) {
			ans[i]++;
			ans[i+1]++;
			
			double s = buildings[i+1] - buildings[i];
			
			for (int j = i + 2; j < N; j++) {
				double nS = calc(i, j);
				if(nS > s) {
					s = nS;
					ans[i]++;
					ans[j]++;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			max = Math.max(max, ans[i]);
		}
		
		System.out.println(max);
	}
	private static double calc(int i, int j) {
		return (double) (buildings[j] - buildings[i]) / (j - i);
	}
}
