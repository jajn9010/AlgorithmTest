package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1927_2 {
	static int[] heap = new int[100001];
	static int size = 0;
	static StringBuilder sb = new StringBuilder();

	public static void swap(int x, int y) {
		int temp = heap[x];
		heap[x] = heap[y];
		heap[y] = temp;
	}

	public static void push(int x) {
		heap[++size] = x;
		for (int i = size; i > 1; i /= 2) {
			if (heap[i / 2] > heap[i]) {
				swap(i / 2, i);
			} else {
				break;
			}
		}
	}

	public static void pop() {
		sb.append(heap[1]).append("\n");
		heap[1] = heap[size];
		size--;

		for (int i = 1; i * 2 <= size;) {
			if (heap[i] < heap[i * 2] && heap[i] < heap[i * 2 + 1]) {
				break;
			} else if (heap[i * 2] < heap[i * 2 + 1]) {
				swap(i, i * 2);
				i *= 2;
			} else {
				swap(i, i * 2 + 1);
				i = i * 2 + 1;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			if (k == 0) {
				if (size == 0)
					sb.append("0").append("\n");
				else
					pop();
			} else {
				push(k);
			}
		}
		System.out.println(sb);
	}
}
