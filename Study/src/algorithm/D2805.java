package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int[] trees = new int [T];
		
		st = new StringTokenizer(br.readLine());
		int start = 0;
		int max = 0;
		
		for (int i = 0; i < T; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			
			if(max < trees[i]) {
				max = trees[i];
			}
		}
		
		while(start < max) {
			int mid = (start + max) / 2;
			long sum = 0;
			
			for(int tree : trees) {
				if(tree - mid > 0) {
					sum += (tree-mid);
				}
			}
			if(sum < target) {
				max = mid;
			} else {
				start = mid+1;
			}
		}
		
		System.out.println(start-1);
	}
}
