package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D15824 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int mod = 1000000007;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N + 1];
		long[] pows = new long[N + 1];
		pows[0] = 1L;
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			pows[i] = pows[i - 1] * 2 % mod;  
		}
		
		Arrays.sort(arr);
		
		long ans = 0L;
		for (int i = 1; i <= N; i++) {
			ans += (pows[i - 1] - pows[N - i]) * arr[i];
			ans %= mod;
		}
		System.out.println(ans);
	}
}
