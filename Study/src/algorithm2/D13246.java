package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D13246 {

	static final long MOD = 1000L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		long[][] arr = new long[N][N];
		long[][] pow;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Long.parseLong(st.nextToken());
			}
		}

		pow = customPow(arr, B);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(pow[i][j] % MOD).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static long[][] customPow(long[][] arr, long num) {
		if (num == 1)
			return arr;
		if (num % 2 == 1)
			return sum(customPow(arr, num - 1), pow(arr, num));

		long[][] a = new long[arr.length][arr[0].length];
		long[][] p = pow(arr, num >> 1);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				a[i][j] = p[i][j] + (i == j ? 1 : 0);
			}
		}
		return mul(customPow(arr, num >> 1), a);
	}

	private static long[][] mul(long[][] a, long[][] b) {
		long[][] c = new long[b[0].length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				for (int k = 0; k < b[0].length; k++) {
					c[i][k] = (c[i][k] + (a[i][j] * b[j][k]) % MOD) % MOD;
				}
			}
		}
		return c;
	}

	private static long[][] sum(long[][] a, long[][] b) {
		long[][] ret = new long[a.length][a[0].length];
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[0].length; c++)
				ret[r][c] = a[r][c] + b[r][c];
		}
		return ret;
	}

	private static long[][] pow(long[][] arr, long num) {
		if (num == 1)
			return arr;
		else if (num % 2 == 1)
			return mul(pow(arr, num - 1), arr);
		else
			return pow(mul(arr, arr), num / 2);
	}
}
