package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D9733 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		HashMap<String, Integer> map = new HashMap<>();
		String[] arrS = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};
		
		String input = "";
		
		for (int i = 0; i < arrS.length; i++) {
			map.put(arrS[i], 0);
		}
		
		double total = 0;
		while((input = br.readLine()) != null && !input.isEmpty()) {
			st = new StringTokenizer(input);
			while(st.hasMoreTokens()) {
				String d = st.nextToken();
				if(map.containsKey(d)) {
					map.put(d, map.get(d) + 1);
				}
				total++;
			}
		}
		
		for (int i = 0; i < map.size(); i++) {
			String str = String.format("%.2f", map.get(arrS[i])/total);
			sb.append(arrS[i]).append(" ").append(map.get(arrS[i])).append(" ").append(str).append("\n");
		}
		sb.append("total").append(" ").append(Math.round(total)).append(" ").append("1.00");
		System.out.println(sb);
	}
}
