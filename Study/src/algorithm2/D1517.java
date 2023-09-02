package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1517 {
	static int n;
	static int[] arr, temp;
	static long ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		temp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sort(0, n - 1);
		
		System.out.println(ans);
	}

	private static void sort(int start, int end) {
		if(start >= end) return;
		int mid = (start + end) >> 1;
		sort(start, mid);
		sort(mid + 1, end);
		
		int p = start;
		int q = mid + 1;
		int idx = p;
		
		while(p <= mid || q <= end) {
			if(q > end || (p <= mid && arr[p] <= arr[q])) {
				temp[idx++] = arr[p++];
			} else {
				ans += mid + 1 - p;
				temp[idx++] = arr[q++];
			}
		}
		
		for (int i = start; i <= end; i++) {
			arr[i] = temp[i];
		}
	}
}
