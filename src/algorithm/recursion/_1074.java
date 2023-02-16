package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 2^nX2^n 배열
        int r = Integer.parseInt(st.nextToken()); // 행
        int c = Integer.parseInt(st.nextToken()); // 열

        System.out.println(func(n, r, c));
    }

    private static int func(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = 1<<(n-1);

        if (r < half && c < half) {return func(n - 1, r, c);}
        if (r < half && c >= half) {return half * half + func(n - 1, r, c - half);}
        if (r >= half && c < half) {return 2 * half * half + func(n - 1, r - half, c);}
        return 3 * half * half + func(n - 1, r - half, c - half);
    }

}
