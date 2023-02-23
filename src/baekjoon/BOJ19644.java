package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ19644 {

    static int L, mL, mK, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        arr = new int[L + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        mL = Integer.parseInt(st.nextToken());
        mK = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(br.readLine());

        for (int i = 1; i <= L; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 기관총을 모두 쏴본다.
        for (int i = 1; i <= mL && i <= L; i++) {
            arr[i] -= i * mK;
        }

        // 기관총을 모두 쏴본다.
        for (int i = mL + 1; i <= L; i++) {
            arr[i] -= mL * mK;
        }

        // 지뢰를 쏴본다.
        for (int i = 1; i <= L; i++) {

            if (arr[i] > 0) {

                if (C > 0) {

                    // 지뢰 개수 감소
                    C--;

                    // 지뢰를 쐈었다면 기관총을 못쐈을 것이기 때문에
                    // 기관총을 쏜 것은 없던 일로 처리해준다.
                    if (i + 1 <= L) {
                        if (i + 1 <= mL) { arr[i + 1] += i * mK; }
                        if (i + 1 > mL) { arr[i + 1] += mL * mK; }
                    }
                    if (i + 2 <= L) {
                        if (i + 2 <= mL) { arr[i + 2] += i * mK; }
                        if (i + 2 > mL) { arr[i + 2] += mL * mK; }
                    }
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }
}
