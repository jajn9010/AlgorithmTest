package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1052 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        
        while(true) {
        	int cnt = 0;
        	String bin = Integer.toBinaryString(n + ans);
        	for (int i = 0; i < bin.length(); i++) {
				if(bin.charAt(i) == '1') cnt ++;
			}
        	if(cnt <= k) break;
        	ans++;
        }
        System.out.println(ans);
    }
}
