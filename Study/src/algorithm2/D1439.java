package algorithm2;

import java.io.*;

public class D1439 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		checked(str);
	}

	static void checked(String str) {
		int count = 0;
		char c = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			if (c != str.charAt(i)) {
				c = str.charAt(i);
				count++;
			}
		}
		System.out.println((count / 2) + count % 2);
	}
}
