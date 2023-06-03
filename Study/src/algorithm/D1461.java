package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minesQ = new PriorityQueue<>(Collections.reverseOrder());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num >= 0) plusQ.add(num);
            else minesQ.add(Math.abs(num));
        }

        int end;

        if(plusQ.isEmpty()) end = minesQ.peek();
        else if(minesQ.isEmpty()) end = plusQ.peek();
        else end = Math.max(plusQ.peek(), minesQ.peek());
    
        int ans = 0;

        while(!plusQ.isEmpty()) {
            ans += plusQ.peek() * 2;
            for(int i = 0; i < m; i++) plusQ.poll();
        }

        while(!minesQ.isEmpty()) {
            ans += minesQ.peek() * 2;
            for(int i = 0; i < m; i++) minesQ.poll();
        }

        ans -= end;
        System.out.println(ans);
    }
}
