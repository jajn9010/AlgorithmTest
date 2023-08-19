package algorithm2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D17613 {
	static HashMap<Long, Long> dp = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			sb.append(recur(x, y)).append('\n');
		}
		System.out.println(sb);
	}

	static long recur(long l, long r) {
		
		if ((l | r) == 0) return 0L;
		if (dp.containsKey((l << 32) + r)) return dp.get((l << 32) + r);
		
		long ret = 0;
		
		for (int i = 1; i <= 32; i++) {
			long cl = Math.max(l, (1L << i) - 1), cr = Math.min(r, (1L << (i + 1)) - 2);
			if (cl > cr)
				continue;
			ret = Math.max(ret, i + recur(cl - (1L << i) + 1, cr - (1L << i) + 1));
		}
		dp.put((l << 32) + r, ret);
		return ret;
	}
}
