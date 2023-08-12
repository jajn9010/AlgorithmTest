package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class utilcup_C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] list = new Integer[N]; 
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		int totalLevel = 0;
		int totalUnion = 0;
		if(N > 42) {
			for (int i = 0; i < 42; i++) {
				int level = list[i];
				int union = 0;
				
				if(level >= 60) union ++;
				if(level >= 100) union ++;
				if(level >= 140) union ++;
				if(level >= 200) union ++;
				if(level >= 250) union ++;
				
				totalLevel += level;
				totalUnion += union;
			}
		} else {
			for (int i = 0; i < N; i++) {
				int level = list[i];
				int union = 0;
				
				if(level >= 60) union ++;
				if(level >= 100) union ++;
				if(level >= 140) union ++;
				if(level >= 200) union ++;
				if(level >= 250) union ++;
				
				totalLevel += level;
				totalUnion += union;
			}
		}
		
		System.out.println(totalLevel + " " + totalUnion);
	}
}
