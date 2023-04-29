package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균은넘겠지 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int su = Integer.parseInt(st.nextToken());
			int[] num = new int[su];
			int total = 0;
			int cnt = 0;

			for (int i = 0; i < su; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				total += num[i];
			}

			for (int i = 0; i < su; i++) {
				if (num[i] > total / su) {
					cnt++;
				}
			}
			System.out.printf("%.3f%%\n", cnt / (double) su * 100);
		}

	}

}
