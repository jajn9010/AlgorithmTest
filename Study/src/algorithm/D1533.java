package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1533 {
    static int N, S, E, T;
    static int[][] arr, ans;
    static final int MOD = 1000003;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N * 5 + 1][N * 5 + 1];

        for(int i = 1; i <= N; i++) {
            String load = br.readLine();
            for(int j = 0; j < N; j++) {
                if(load.charAt(j) != '0') {
                    arr[i * 5][(j + 1) * 5 - (load.charAt(j) - '0' - 1)] = 1;
                }
            }

            for(int j = 1; j < 5; j++)
                arr[(i - 1) * 5 + j][(i - 1) * 5 + j + 1] = 1;
        }

        System.out.println(solve(arr, T)[5 * S][5 * E]);
    }

    private static int[][] solve(int[][] a, int n) {
        int[][] result = new int[N * 5 + 1][N * 5 + 1];
        for(int i = 1; i <= N * 5; i++) result[i][i] = 1;

        while(n != 0) {
            if(n % 2 == 1) {
                result = DC(result, a);
            }
            n /= 2;
            a = DC(a, a);
        }
        return result;
    }

    private static int[][] DC(int[][] a, int[][] b) {
        int[][] result = new int[N * 5 + 1][N * 5 + 1];
        for (int i = 1; i <= 5 * N; i++) {
            for (int j = 1; j <= 5 * N; j++) {
                for (int k = 1; k <= 5 * N; k++) {
                    result[i][j] += (a[i][k] * b[k][j]);
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}
