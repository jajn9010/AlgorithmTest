package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        int su = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        int cnt = 0;
        int temp = 0;

        for(int i = 2; i <= T; i++) {
            arr.add(i);
        }

        loop:
        for(int i = 0; i < T; i++) {
            int x = arr.get(0);
            for(int j = 0; j < arr.size(); j++) {
                if(arr.get(j)%x == 0) {
                    temp = arr.get(j);
                    arr.remove(j);
                    j--;
                    cnt++;
                }
                if(cnt == su) break loop;
            }
        }
        System.out.println(temp);
    }
}
