package algorithm;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		int n = 3;
		int m = 12;

		int[] answer = { 0, 0 };

		int min = (n < m) ? n : m;
		int gcd = 0, lcm = 0;

		for (int i = 1; i <= min; i++) {
			if (n % i == 0 && m % i == 0) {
				gcd = i;
			}
		}
		lcm = (n * m) / gcd;

		answer[0] = gcd;
		answer[1] = lcm;

		System.out.println(Arrays.toString(answer));
	}
}
