package algorithm;

import java.util.Arrays;

public class 예산 {
    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int budget = 10, answer = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            if( budget - d[i] >= 0) {
                answer ++;
                budget -= d[i];
            }
            else break;
        }
        System.out.println(answer);
    }
}
