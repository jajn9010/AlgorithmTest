package algorithm;

import java.util.Arrays;

public class 문자내림차순으로배열하기 {
    public static void main(String[] args) {
        String answer = "";
        String s = "Zbcdefg";
        char[] ch = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);
        }

        Arrays.sort(ch);
        answer = String.valueOf(ch);
        answer = new StringBuffer(answer).reverse().toString();

        System.out.println(answer);
        
    }
}
