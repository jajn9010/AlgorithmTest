package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2675 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				for (int j = 0; j < N; j++) {
					sb.append(ch);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
