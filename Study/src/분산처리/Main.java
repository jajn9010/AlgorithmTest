package 분산처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int result = 1;
			
			for (int i = 1; i <= b; i++) {
				result = result * a % 10;
			}
			
			result = (result == 0) ? 10 : result;
			sb.append(result + "\n");
		}

		System.out.println(sb);

	}
}
