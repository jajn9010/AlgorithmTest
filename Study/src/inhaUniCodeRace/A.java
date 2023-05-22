package inhaUniCodeRace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Character> s = new HashSet<>();
        
        char[] ch = br.readLine().toCharArray();

        for(int i = 0; i < ch.length; i++) {
            s.add(ch[i]);
        }
        
        if(s.contains('M') && s.contains('O') && s.contains('I') && s.contains('B') && s.contains('S')) System.out.println("YES");
        else System.out.println("NO");
    }
}
