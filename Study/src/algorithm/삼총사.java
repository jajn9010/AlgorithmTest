package algorithm;

public class 삼총사 {
    public static void main(String[] args) {
        int[] number = { -2, 3, 0, 2, -5 };

        int answer = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int x = j + 1; x < number.length; x++) {
                    if (number[i] + number[j] + number[x] == 0) {
                        answer += 1;
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
