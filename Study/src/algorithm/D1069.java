package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        double len = Math.sqrt(x * x + y * y);
        double walk, jw, j;

        walk = len;
        if(len >= d) {
            int jump = (int) (len / d);
            jw = (t * jump) + (len - (d * jump));
            j = t * (jump + 1);
        } else {
            jw = t + (d - len);
            j = t * 2;
        }

        System.out.println(Math.min(walk, Math.min(jw, j)));
    }
}
