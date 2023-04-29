package 네번째점;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int [] x = new int[3];
		int [] y = new int[3];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		sb.append(findAxis(x) + " " + findAxis(y));
		System.out.println(sb);
	}

	private static String findAxis(int[] x) {
		if(x[0] == x[1]) return Integer.toString(x[2]);
		else {
			return (x[0] == x[2]) ? Integer.toString(x[1]) : Integer.toString(x[0]);
		}
	}
}
