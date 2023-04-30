package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2577 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int A = Integer.parseInt(br.readLine());
		int B= Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		String total = String.valueOf(A * B * C);
		int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0, j = 0;
		
		for (int x = 0; x < total.length(); x++) {
			if(total.charAt(x) -'0' == 0) a++;
			else if(total.charAt(x) -'0' == 1) b++;
			else if(total.charAt(x) -'0' == 2) c++;
			else if(total.charAt(x) -'0' == 3) d++;
			else if(total.charAt(x) -'0' == 4) e++;
			else if(total.charAt(x) -'0' == 5) f++;
			else if(total.charAt(x) -'0' == 6) g++;
			else if(total.charAt(x) -'0' == 7) h++;
			else if(total.charAt(x) -'0' == 8) i++;
			else j++;
		}
		sb.append(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g + "\n" + h + "\n" + 
				i + "\n" + j + "\n");
		
		System.out.println(sb);
	}
}
