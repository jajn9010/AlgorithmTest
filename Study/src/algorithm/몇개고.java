package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 몇개고 {
	public static void main(String[] args) throws IOException {

	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      StringTokenizer st = new StringTokenizer(br.readLine()); // 예외발생

	      int time = Integer.parseInt(st.nextToken());
	      int beer = Integer.parseInt(st.nextToken());

	      if (time <= 16 && time >= 12 && beer == 0) {
	         System.out.println("320");
	      } else
	         System.out.println("280");
	   }
}
