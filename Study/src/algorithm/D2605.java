package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class D2605 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> ans = new ArrayList<>();
		
		for (int i = 1; i <= T; i++) {
			ans.add(Integer.parseInt(st.nextToken()), i);
		}
		
		Collections.reverse(ans);
		
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i) + " ");
		}
		System.out.println(sb);
	}
}
