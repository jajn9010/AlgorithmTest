package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class D1644 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[N + 1];
        prime[0] = prime[1] = true;
        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i = 2; i * i <= N; i++) {
            if(!prime[i]) for(int j = i * i; j <= N; j += i) prime[j] = true;
        }

        for(int i = 1; i <= N; i++) {
            if(!prime[i]) numbers.add(i);
        }

        int start = 0, end = 0, sum = 0, cnt = 0;
        while(true) {
            if(sum >= N) sum -= numbers.get(start++);
            else if(end == numbers.size()) break;
            else sum += numbers.get(end++);
            if(N == sum) cnt++;
        }
        System.out.println(cnt);
    }
}
