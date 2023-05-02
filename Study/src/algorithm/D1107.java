package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1107 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[] broken = new boolean[10];

		int chan = Integer.parseInt(br.readLine());

		int bNum = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		if (bNum != 0) {
			for (int i = 0; i < bNum; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		System.out.println(calc(chan, broken));
	}

	static int calc(int chan, boolean[] broken) {
		int result = Math.abs(100 - chan);

		for (int i = 0; i <= 999999; i++) {
			String curr = Integer.toString(i);
			boolean check = false;

			for (int j = 0; j < curr.length(); j++) {
				if (broken[curr.charAt(j) - '0']) {
					check = true;
					break;
				}
			}

			if (!check) {
				result = Math.min(result, curr.length() + Math.abs(i - chan));
			}
		}
		return result;
	}
}
