package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D1132 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Info[] calc = new Info[10];

        for(int i = 0; i < 10; i++) {
            calc[i] = new Info();
        }

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            calc[str.charAt(0) - 'A'].num += Math.pow(10, str.length() - 1);
            calc[str.charAt(0) - 'A'].first = true;
            for(int j = 1; j < str.length(); j++) calc[str.charAt(j) - 'A'].num += Math.pow(10, str.length() - 1 - j);
        }

        long ans = 0L;
        Arrays.sort(calc);

        int[] used = new int[10];

        for(int i = 0; i < 10; i++) {
            if(calc[i].first) {
                for(int j = 1; j < 10; j++) {
                    if(used[j] == 0) {
                        ans += calc[i].num * j;
                        used[j] = 1;
                        break;
                    }
                }
            } else {
                for(int j = 0; j < 10; j++) {
                    if(used[j] == 0) {
                        ans += calc[i].num * j;
                        used[j] = 1;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static class Info implements Comparable<Info>{
        long num = 0L;
        boolean first = false;

        @Override
        public int compareTo(Info o) {
            if(num > o.num) return 1;
            else if(num == o.num) return 0;
            else return -1;
        }
    }
}
