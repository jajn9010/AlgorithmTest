package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1019 {
	static int[] cnt = new int[10];
	static int digit, start, end;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		start = 1;
		digit = 1;
		end = Integer.parseInt(br.readLine());

		while (start <= end) {
			while (start % 10 != 0 && start <= end) {
				count(start, digit);
				start++;
			}
			
			while (end % 10 != 9 && start <= end) {
				count(end, digit);
				end--;
			}
	
			if (end < start) {
				break;
			}
			
			start /= 10;
			end /= 10;
			
			for (int i = 0; i < 10; i++) {
				cnt[i] += (end - start +1) * digit;
			}
			
			digit *= 10;
		}
		
		for (int item : cnt) sb.append(item).append(" ");
		System.out.println(sb);
	}

	public static void count(int num, int digit2) {
		while (num > 0) {
			cnt[num % 10] += digit2;
			num /= 10;
		}
	}
}
