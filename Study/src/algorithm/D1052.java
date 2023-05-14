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

        calc(n, k);

        sb.reverse();
        String str = sb.toString();
        int ans = Integer.valueOf(str, 2);
        System.out.println(ans);
    }

    static void calc(int n, int k ) {
        if(n/2 < Math.pow(2, k) && n%2 == 1) {
            sb.append(1);
            return;
        }else if(n/2 < Math.pow(2, k) && n%2 == 0) {
            return;
        }

        if (n/2 == Math.pow(2, k) && n%2 == 0) {
            sb.append(0);
            return;
        } else if (n/2 == Math.pow(2, k) && n%2 == 1) {
            sb.append(1);
            return;
        } else if(n%2 == 0) {
            sb.append(0);
            calc(n/2, k);
        } else {
            sb.append(1);
            calc(n/2+1, k);
        }
        return;
    }
}
