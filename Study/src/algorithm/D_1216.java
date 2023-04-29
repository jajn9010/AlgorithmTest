package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class D_1216 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int num = Integer.parseInt(br.readLine());

		int[] arrA = new int[num];
		int[] arrB = new int[num];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arrA);

		int answer = 0;

		ArrayList<Integer> cloneB = new ArrayList<>();

		for (int item : arrB)
			cloneB.add(item);

		for (int i = 0; i < arrA.length; i++) {
			int max = Collections.max(cloneB);
			answer += arrA[i] * max;
			cloneB.remove(Integer.valueOf(max));
		}
		System.out.println(answer);

		br.close();
	}
}
