package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class utilcup_A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int level = Integer.parseInt(st.nextToken());
			if(level == 300) sb.append(1).append(" ");
			else if(level < 300 && level >= 275) sb.append(2).append(" ");
			else if(level < 275 && level >= 250) sb.append(3).append(" ");
			else sb.append(4).append(" ");
		}
		System.out.println(sb);
	}
}
