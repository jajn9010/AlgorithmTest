package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class D3033 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int now, dup;
		Deque<int[]> q = new LinkedList<>();
		long ans = 0L;
		for (int i = 0; i < N; i++) {
			now = Integer.parseInt(br.readLine());
			dup = 1;
			while(!q.isEmpty() && q.peekFirst()[0] < now) ans += q.pollFirst()[1];
			if(!q.isEmpty()) {
				if(q.peekFirst()[0] == now) {
					dup = q.pollFirst()[1];
					ans += dup++;
					if(!q.isEmpty()) ans++;
				} else {
					ans++;
				}
			}
			q.offerFirst(new int[] {now, dup});
		}
		System.out.println(ans);
	}
}
