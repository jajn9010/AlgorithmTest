package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1160 {
	static long MOD;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		MOD = Long.parseLong(st.nextToken());
		long a = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		long x = Long.parseLong(st.nextToken());
		long n = Long.parseLong(st.nextToken());
		long g = Long.parseLong(st.nextToken());

		long[][] A = { { a, c }, { 0, 1 } };

		long[][] result = mat_pow(A, n);

		long answer = (result[0][0] * x + result[0][1]) % MOD % g;

		System.out.println(answer);
	}

	static long[][] mat_mul(long[][] A, long[][] B) {
		int n = A.length;
		int m = B[0].length;
		int l = A[0].length;

		long[][] C = new long[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < l; k++) {
					C[i][j] = (C[i][j] + (A[i][k] * B[k][j]) % MOD) % MOD;
				}
			}
		}

		return C;
	}

	static long[][] mat_pow(long[][] A, long num) {
		if (num == 1) {
			return A;
		} else if (num % 2 == 1) {
			return mat_mul(mat_pow(A, num - 1), A);
		} else {
			return mat_pow(mat_mul(A, A), num / 2);
		}
	}
}
