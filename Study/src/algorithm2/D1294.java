package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class D1294 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			pq.add(br.readLine() + "[");
		}
		
		while(!pq.isEmpty()) {
			temp.setLength(0);
			temp.append(pq.poll());
			sb.append(temp.charAt(0));
			
			if(temp.length() == 2) continue;
			
			temp.deleteCharAt(0);
			pq.add(temp.toString());
		}
		
		System.out.println(sb);
	}
}
