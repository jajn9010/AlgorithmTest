package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sList;
        sList = (br.readLine().trim().split(" "));
        if(sList.length == 1 && sList[0].equals("")) {
            System.out.println(0);
        } else {
            System.out.println(sList.length);
        }
    }
}
