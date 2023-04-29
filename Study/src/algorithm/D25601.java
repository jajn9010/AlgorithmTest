package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D25601 {
    static HashMap<String, ArrayList<String>> clas;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        clas = new HashMap<>();

        int T = Integer.parseInt(st.nextToken());

        while(T-- > 1) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if(!clas.containsKey(a)) {
                clas.put(a, new ArrayList<>());
            }

            clas.get(a).add(b);
        }

        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        System.out.println((bfs(a, b) || bfs(b, a)) ? 1 : 0);
    }

    static boolean bfs(String curr, String end) {
        if(curr.equals(end)) {
            return true;
        }
        if(clas.get(curr) == null) {
            return false;
        }
        for(String next : clas.get(curr)) {
            if(bfs(next, end)) {
                return true;
            }
        }

        return false;
    }
}
