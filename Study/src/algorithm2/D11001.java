package algorithm2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D11001 {
	static int N, D;
	static long ans = -1;
	static long[] T, V;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		T = new long[N + 1];
		V = new long[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			T[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		solution(1, N, 1, N);
		
		bw.write(Long.toString(ans));
		bw.flush();
		bw.close();
	}
	private static void solution(int left, int right, int cLeft, int cRight) {
		if(left > right) return;
		int mid = (left + right) >> 1;
		int temp = Math.max(cLeft, mid - D);
		
		for (int i = temp; i <= Math.min(cRight, mid); i++) {
			if((mid - temp) * T[mid] + V[temp] >= (mid - i) * T[mid] + V[i]) continue;
			temp = i;
		}
		
		ans = Math.max(ans, (mid - temp) * T[mid] + V[temp]);
		solution(1, mid - 1, cLeft, temp);
		solution(mid + 1, right, temp, cRight);
	}
}
