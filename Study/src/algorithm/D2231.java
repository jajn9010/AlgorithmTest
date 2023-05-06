package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2231 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int ans = Integer.parseInt(br.readLine());

        System.out.println(calc(ans));
    }

    public static int calc(int x) {
            for(int i = 1; i < 1000001; i++) {
                int sum = i;
                char[] ch = String.valueOf(i).toCharArray();
    
                for(int j = 0; j < ch.length; j++) {
                    sum += (ch[j] - '0');
                }
    
                if(sum == x) return i;
                else if(i == 1000000) return 0;
                else continue;
            }
        return -1;
    }
}
