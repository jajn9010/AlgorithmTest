package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D10866 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            if(s.equals("push_front")) {
                list.add(0, Integer.parseInt(st.nextToken()));
            }
            if(s.equals("push_back")) {
                if(list.size() == 0) {
                    list.add(0, Integer.parseInt(st.nextToken()));
                } else {
                    list.add(Integer.parseInt(st.nextToken()));
                }
            }
            if(s.equals("pop_front")) {
                if(list.size() == 0) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(list.get(0)).append("\n");
                    list.remove(0);
                }
            }
            if(s.equals("pop_back")) {
                if(list.size() == 0) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(list.get(list.size()-1)).append("\n");
                    list.remove(list.size()-1);
                }
            }
            if(s.equals("size")) {
                sb.append(list.size()).append("\n");
            }
            if(s.equals("empty")) {
                if(list.size() == 0) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            if(s.equals("front")) {
                if(list.size() == 0) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(list.get(0)).append("\n");
                }
            }
            if(s.equals("back")) {
                if(list.size() == 0) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(list.get(list.size()-1)).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
