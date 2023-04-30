package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class D10828 {
    static Stack<Integer> s = new Stack<Integer>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();

            if(a.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                s.push(x);
            } else if(a.equals("pop")) {
                if(s.size() == 0) {
                    sb.append(-1 + "\n");
                } else {
                    int x = s.pop();
                    sb.append(x + "\n");
                }
            } else if(a.equals("size")) {
                sb.append(s.size() + "\n");
            } else if(a.equals("empty")) {
                if(s.size() == 0) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            } else if (a.equals("top")) {
                if(s.size() == 0) {
                    sb.append(-1 + "\n");
                } else {
                    int x = s.pop();
                    sb.append(x + "\n");
                    s.push(x);
                }
            }
        }
        System.out.println(sb);
    }
}
