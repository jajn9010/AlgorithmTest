package toss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class no3 {
    public static void main(String[] args) {
        int maxSize = 3;
        String[] action = {"1", "2", "B", "B", "3"};

        String regExp = "^[0-9]+$";
        ArrayList<String> answer = new ArrayList<>();
        Stack<String> bStack = new Stack<>();
        Stack<String> fStack = new Stack<>();

        String now = "";
        for(int i = 0; i < action.length; i++) {
            String str = action[i];
            if(str.matches(regExp)) {
                if(answer.contains(str)) {
                    answer.remove(str);
                    answer.add(0, str);
                }else {
                    answer.add(0, str);
                }
                if(now != "") {
                    bStack.add(now);
                }
                now = str;
                if(answer.size() > maxSize) {
                    answer.remove(answer.size() - 1);
                }
                if(fStack.size() > 0) {
                    fStack.clear();
                }
            } else if(str.equals("B")) {
                if(bStack.size() == 0) {
                    continue;
                } else {
                    fStack.add(now);
                    now = bStack.peek();
                    String s = bStack.pop();
                    if(answer.contains(s)) {
                        answer.remove(s);
                        answer.add(0, s);
                    }else {
                        answer.add(0, s);
                    }
                }

            } else if(str.equals("F")) {
                if(fStack.size() == 0) {
                    continue;
                } else {
                    bStack.add(now);
                    now = fStack.peek();
                    String s = fStack.pop();
                    if(answer.contains(s)) {
                        answer.remove(s);
                        answer.add(0, s);
                    }else {
                        answer.add(0, s);
                    }
                }
            }
        }

        String[] ans = new String[answer.size()];

        for(int i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }

        System.out.println(Arrays.toString(ans));
    }
}
