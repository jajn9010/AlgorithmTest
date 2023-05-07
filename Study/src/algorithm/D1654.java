package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		int[] rans = new int[T];

		long start = 0;
		long max = 0;

		for (int i = 0; i < T; i++) {
			rans[i] = Integer.parseInt(br.readLine());

			if (max < rans[i])
				max = rans[i];
		}
		
		max++;

		while (start < max) {
			int cnt = 0;
			long mid = (start + max) / 2;

			for (int ran : rans) {
				cnt += ran / mid;
			}

			if (cnt < target) {
				max = mid;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(start - 1);

	}
}
