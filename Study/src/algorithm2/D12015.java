package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D12015 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] s = new int [N];
		int[] LIS = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		LIS[0] = s[0];
		
		int cnt = 1;
		
		for (int i = 1; i < N; i++) {
			int key = s[i];
			
			if(LIS[cnt - 1] < key) {
				cnt++;
				LIS[cnt - 1] = key;
			} else {
				int low = 0;
				int high = cnt;
				
				while(low < high) {
					int mid = (low + high) / 2;
					
					if(LIS[mid] < key) {
						low = mid + 1;
					} else {
						high = mid;
					}
				}
				LIS[low] = key;
			}
		}
		System.out.println(cnt);
	}
}
