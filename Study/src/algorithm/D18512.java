package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D18512 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());

		int num = 0;
		int i1 = 0, i2 = 0;
		int ans1, ans2;

		while (true) {
			if (p1 == p2) {
				sb.append(p1);
				break;
			} else {
				if (num > 10000) {
					sb.append(-1);
					break;
				} else {
					ans1 = x * i1 + p1;
					ans2 = y * i2 + p2;

					if (ans1 == ans2) {
						sb.append(ans1);
						break;
					} else if (ans1 < ans2) {
						num = ans2;
						i1++;
					} else {
						num = ans1;
						i2++;
					}
				}
			}
		}
		System.out.println(sb);
	}
}
