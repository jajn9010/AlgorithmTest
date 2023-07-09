package toss;

import java.util.ArrayList;
import java.util.Collections;

public class no1 {
    public static void main(String[] args) {
        String s = "1451232125";
        int N = 2;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < s.length() - N + 1; i++) {
            String sub = s.substring(i, i + N);
            boolean check = false;
            loop:
            for(int j = 0; j < N; j++) {
                if(0 < sub.charAt(j) - '0' && sub.charAt(j) - '0' <= N) check = true;
                else {
                    check = false;
                    break loop;
                }
            }

            if(check == true) list.add(Integer.parseInt(sub));
        }

        for(int i = 0; i < list.size(); i++) {
            String str = String.valueOf(list.get(i));
            loop:            
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k ++) {
                    if(j != k && str.charAt(j) == str.charAt(k)) {
                        list.remove(i);
                        i--;
                        break loop;
                    }
                }
            }
        }

        Collections.sort(list);
        Collections.reverse(list);

        int answer = 0;
        if(list.size() == 0) answer = -1;
        else answer = list.get(0);

        System.out.println(answer);
    }
}
