package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D7696 {
	static boolean[] chk = new boolean[10];
	static int cnt = 0, num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[1000001];
		int ans = 0;

		while (cnt < 1000001) {
			if (calc(ans)) {
				arr[cnt] = ans;
				cnt++;
			}

			ans++;
		}
		while (true) {
			num = Integer.parseInt(br.readLine());
			if (num == 0)
				break;
			else {
				sb.append(arr[num]).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean calc(int ans) {
		for (int i = 0; i < 10; i++) {
			chk[i] = false;
		}

		while (ans != 0) {
			if (chk[ans % 10] == true) {
				return false;
			} else {
				chk[ans % 10] = true;
			}
			ans /= 10;
		}

		return true;
	}

}
