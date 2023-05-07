package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class D4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String input = "";

		while (!(input = br.readLine()).equals("0 0 0")) {
			ArrayList<Integer> arr = new ArrayList<>();
			st = new StringTokenizer(input);

			for (int i = 0; i < 3; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}

			Collections.sort(arr);

			int w = arr.get(0);
			int h = arr.get(1);
			int v = arr.get(2);

			if (Math.pow(v, 2) == (Math.pow(w, 2) + Math.pow(h, 2)))
				sb.append("right").append("\n");
			else
				sb.append("wrong").append("\n");
		}
		System.out.println(sb);
	}
}
