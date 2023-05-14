package busanUniCodeRace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		int ans = 1;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < T; i++) {
			if(arr[i-1] <= arr[i]) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
