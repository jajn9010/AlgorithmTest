package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int ans = 0;

        int day = up-down;
        int bDay = v - up;

        if(bDay%day == 0) {
            ans = bDay/day + 1;
        } else {
            ans = bDay/day + 2;
        }

        System.out.println(ans);
    }
}
