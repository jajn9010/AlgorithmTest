package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D9375 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            while(n-- > 0) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String name = st.nextToken();

                if(map.containsKey(name)) {
                    map.put(name, map.get(name) + 1);
                } else {
                    map.put(name, 1);
                }
            }
            int ans = 1;
            for (int value : map.values()) {
                ans *= (value + 1);
            }
            sb.append(ans-1).append("\n");
        }
        System.out.println(sb);
    }
}
