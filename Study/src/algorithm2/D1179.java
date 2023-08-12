package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1179 {
	static long N;
	static int K;
	static long[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new long[K];
		
		for (int i = 2; i < K; i++) {
			list[i] = (list[i - 1] + K) % i;
		}
		System.out.println(Long.toString(K == 1 ? N : joseph(N) + 1));
	}
	private static long joseph(long n) {
		if(n < K) {
			return list[(int) n];
		}
		long next = joseph(n - (n / K)) - n % K;
		return next < 0 ? next + n : next + next / (K - 1);
	}
}
