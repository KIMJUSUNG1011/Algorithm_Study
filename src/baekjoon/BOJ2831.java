package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2831 {

    static int N, answer;
    static List<Integer> boyPlus, boyMinus, girlPlus, girlMinus;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boyPlus = new ArrayList<>();
        boyMinus = new ArrayList<>();
        girlPlus = new ArrayList<>();
        girlMinus = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    if (x > 0) boyPlus.add(x);
                    else boyMinus.add(x);
                } else {
                    if (x > 0) girlPlus.add(x);
                    else girlMinus.add(x);
                }
            }
        }

        Collections.sort(boyMinus);
        Collections.sort(girlMinus);
        Collections.sort(boyPlus, Collections.reverseOrder());
        Collections.sort(girlPlus, Collections.reverseOrder());

        int p1 = 0;
        int p2 = 0;

        while (p1 < boyMinus.size() && p2 < girlPlus.size()) {

            int boyHeight = boyMinus.get(p1);
            int girlHeight = girlPlus.get(p2);

            if (Math.abs(boyHeight) > girlHeight) {
                p1++;
                answer++;
            }

            p2++;
        }

        p1 = 0;
        p2 = 0;

        while (p1 < girlMinus.size() && p2 < boyPlus.size()) {

            int girlHeight = girlMinus.get(p1);
            int boyHeight = boyPlus.get(p2);

            if (Math.abs(girlHeight) > boyHeight) {
                p1++;
                answer++;
            }

            p2++;
        }

        System.out.println(answer);
    }
}
