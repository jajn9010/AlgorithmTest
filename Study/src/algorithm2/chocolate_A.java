package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chocolate_A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			
			int n = (int) Math.ceil(str.length()/3.);
			
			String s = str.substring(0, n);
			String revS = sb.append(s).reverse().toString();
			String tailS = s.substring(1, n);
			String tailRS = revS.substring(1, n);
			
			String S1 = s + revS + s;
			String S2 = s + tailRS + s;
			String S3 = s + revS + tailS;
			String S4 = s + tailRS + tailS;
			
			if(str.equals(S1) || str.equals(S2) || str.equals(S3) || str.equals(S4)) System.out.println(1);
			else System.out.println(0);
		}
	}
}
