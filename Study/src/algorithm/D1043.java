package algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class D1043 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());
        HashSet<Integer> knowList = new HashSet<Integer>();
        if(know == 0) {
            System.out.println(P);
        }
        else{
            while(know-- > 0) {
                knowList.add(Integer.parseInt(st.nextToken()));
            }
            while(P-- > 0) {
                st = new StringTokenizer(br.readLine());
                int su = Integer.parseInt(st.nextToken());
                int[] pSu = new int [su];
                for(int i = 0; i < su; i++) {
                    pSu[i] = Integer.parseInt(st.nextToken());
                }
                for(int i = 0; i < su; i++) {
                    if(knowList.contains(pSu[i])) {
                        for (int j : pSu) {
                            knowList.add(j);
                        }
                    }
                }
            }
        }
    }
}
