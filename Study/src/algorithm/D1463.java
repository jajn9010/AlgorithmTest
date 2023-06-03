package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1463 {
    static Integer[] ans;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ans = new Integer[n + 1];
        ans[0] = ans[1] = 0;

        System.out.println(calc(n));
    }
    private static int calc(int n) {
        if(ans[n] == null) {
            if(n % 6 == 0) {
                ans[n] = Math.min(calc(n - 1), Math.min(calc(n / 3), calc(n / 2))) + 1;
            } else if(n % 3 == 0) {
                ans[n] = Math.min(calc(n / 3), calc(n - 1)) + 1;
            } else if(n % 2 == 0) {
                ans[n] = Math.min(calc(n / 2), calc(n - 1)) + 1;
            } else {
                ans[n] = calc(n - 1) + 1;
            }
        }
        return ans[n];
    }    
}
