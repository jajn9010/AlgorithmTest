package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D_25304 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int total = 0;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			total += a * b;
		}

		if (X - total == 0)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
