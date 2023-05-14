package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<>();
		
		int T = Integer.parseInt(br.readLine());
		
		int start = 0;
		
		while(T-- > 0) {
			int a = Integer.parseInt(br.readLine());
			
			if(a > start) {
				for (int i = start+1; i <= a; i++) {
					s.push(i);
					sb.append("+").append("\n");
				}
				start = a;
			} else if(s.peek() != a) {
				System.out.println("NO");
				System.exit(0);
			}
			
			s.pop();
			sb.append("-").append("\n");
		}
		System.out.println(sb);
	}
}
