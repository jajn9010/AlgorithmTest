package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class utilcup_B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] now = br.readLine().split("-");
		int nowY = Integer.parseInt(now[0]);
		int nowM = Integer.parseInt(now[1]);
		int nowD = Integer.parseInt(now[2]);
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String[] coupon = br.readLine().split("-");
			int couponY = Integer.parseInt(coupon[0]);
			int couponM = Integer.parseInt(coupon[1]);
			int couponD = Integer.parseInt(coupon[2]);
			
			if(couponY > nowY) {
				cnt++;
			} else if (couponY == nowY) {
				if(couponM > nowM) {
					cnt++;
				} else if(couponM == nowM) {
					if(couponD >= nowD) cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
