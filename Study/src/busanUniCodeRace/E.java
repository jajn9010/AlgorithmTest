package busanUniCodeRace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int[] nTime = new int[1000001];
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for (int j = a; j <= b; j++) {
				nTime[j]++;
			}
		}
		
		int Q = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int a = Integer.parseInt(st.nextToken());
			
			sb.append(nTime[a]).append("\n");
		}
		
		System.out.println(sb);
	}
}
