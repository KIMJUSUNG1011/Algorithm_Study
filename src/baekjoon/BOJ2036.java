package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2036 {

    static int N;
    static long answer;
    static List<Integer> plus, minus;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        plus = new ArrayList<>();
        minus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 0) plus.add(x);
            else minus.add(x);
        }

        Collections.sort(plus);
        Collections.sort(minus);

        int p = plus.size() - 1;

        while (p > 0) {
            if (plus.get(p) == 1 && plus.get(p - 1) == 1)
                answer += plus.get(p) + plus.get(p - 1);
            else
                answer += plus.get(p) * plus.get(p - 1);
            p -= 2;
        }

        answer += p == 0 ? plus.get(p) : 0;

        p = 0;

        while (p < minus.size() - 1) {
            answer += minus.get(p) * minus.get(p + 1);
            p += 2;
        }

        answer += p == minus.size() - 1 ? minus.get(p) : 0;

        System.out.println(answer);
    }
}
