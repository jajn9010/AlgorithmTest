package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2864 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		sb.append(Integer.parseInt(a.replaceAll("6", "5"))+Integer.parseInt(b.replaceAll("6", "5"))).append(" ")
			.append(Integer.parseInt(a.replaceAll("5", "6"))+Integer.parseInt(b.replaceAll("5", "6")));
		
		System.out.println(sb);
	}
}
