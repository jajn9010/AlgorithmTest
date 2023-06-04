package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class problem {
	int score, time;
	
	public problem(int score, int time) {
		this.score = score;
		this.time = time;
	}
}

public class D17952 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int ans = 0;
		Stack<problem> s = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 1) {
				s.add(new problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			if(!s.isEmpty()) {
				problem p = s.peek();
				p.time--;
				if(p.time == 0) {
					ans += p.score;
					s.pop();
				}
			}
		}
		System.out.println(ans);
	}
}
