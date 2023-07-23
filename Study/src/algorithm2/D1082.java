package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D1082 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Number[] arr = new Number[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = new Number(i, Integer.parseInt(st.nextToken()));
			map.put(i, arr[i].price);
		}

		int m = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr, new Comparator<Number>() {
			@Override
			public int compare(Number o1, Number o2) {
				if(o1.price == o2.price) return o1.num - o2.num;
				return o1.price - o2.price;
			}
		});
		
		int cnt = 0;
		int[] res = new int[100];
		if(arr[0].num == 0) {
			if(n == 1 || arr[1].price > m) {
				System.out.println(0);
				return;
			}
			res[cnt++] = arr[1].num;
			m -= arr[1].price;
		}
		
		while(m - arr[0].price >= 0) {
			res[cnt++] = arr[0].num;
			m -= arr[0].price;
		}
		
		for (int i = 0; i < cnt; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if(i == 0 && j == 0) continue;
				int tmp = m + map.get(res[i]) - map.get(j);
				if(tmp >= 0) {
					m = tmp;
					res[i] = j;
					break;
				}
			}
		}
		
		for (int i = 0; i < cnt; i++) {
			sb.append(res[i]);
		}
		System.out.println(sb);
	}

	private static class Number {
		int num, price;

		public Number(int num, int price) {
			this.num = num;
			this.price = price;
		}
	}
}
