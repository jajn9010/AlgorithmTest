package busanUniCodeRace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class E2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int[] nTime = new int[1000001];
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			q.add(Integer.parseInt(st.nextToken()));
			q.add(Integer.parseInt(st.nextToken()));
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
