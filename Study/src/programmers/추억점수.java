package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class 추억점수 {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        int[] answer = new int[photo.length];

        HashMap<String, Integer> map  = new HashMap<>();

        for(int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photo.length; i++) {
            int ans = 0;
            for(int j = 0; j < photo[i].length; j++) {
                ans += map.get(photo[i][j]);
            }
            answer[i] = ans;
        }
        System.out.println(Arrays.toString(answer));
    }
}
