package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1002 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double diag = Math.sqrt(((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))));
            
            if(diag == 0 && r1 != r2) {
                System.out.println(0); continue;
            }
            if(diag == 0 && r1==r2) {
                System.out.println(-1); continue;
            }

            if(Math.abs(r1-r2) < diag && diag < r1 + r2) {
                System.out.println(2);
            } else if (Math.abs(r1 - r2) == diag || diag == r1 + r2) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
