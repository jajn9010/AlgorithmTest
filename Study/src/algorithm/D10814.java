package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class D10814 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        String[][] strs = new String[T][2];

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            strs[i][0] = st.nextToken();
            strs[i][1] = st.nextToken();
        }

        Arrays.sort(strs, new Comparator<String[]>() {

            @Override
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]); 
            }
        });

        for(int i = 0; i < T; i++) {
            sb.append(strs[i][0]).append(" ").append(strs[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}
