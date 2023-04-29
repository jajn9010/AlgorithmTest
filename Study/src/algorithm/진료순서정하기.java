package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 진료순서정하기 {
	public static void main(String[] args) {
		int[] emergency = {3, 76, 24};
		
		int[] answer = new int[emergency.length];
		ArrayList<Integer> copy = new ArrayList<>();
		for (int i : emergency) copy.add(i);
		
		Collections.sort(copy, Collections.reverseOrder());
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = copy.indexOf(emergency[i])+1;
		}
		System.out.println(Arrays.toString(answer));
	
	}
}
