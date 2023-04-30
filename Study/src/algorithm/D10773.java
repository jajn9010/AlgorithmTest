package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D10773 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int ans = 0;

        while(T-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                s.pop();
            } else {
                s.push(x);
            }
        }

        for (Integer integer : s) {
            ans += integer;
        }
        System.out.println(ans);
    }
}
