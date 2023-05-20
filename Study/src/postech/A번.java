package postech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A번 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int total = 0;
        if(n > 1){
            total = total + ((n-1) * 8);
        }
        
        st = new StringTokenizer(br.readLine());
        while(n-- > 0) {
            total += Integer.parseInt(st.nextToken());
        }

        int h = total / 24;
        int m = total % 24;
        sb.append(h).append(" ").append(m);
        System.out.println(sb);
    }
}
