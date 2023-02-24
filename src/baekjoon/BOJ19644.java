package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ19644 {

    static int L, mL, mK, C;
    static long[] zombieStamina;
    static boolean[] bombPosition;
    static String answer = "YES";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        zombieStamina = new long[L + 1];
        bombPosition = new boolean[L + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        mL = Integer.parseInt(st.nextToken());
        mK = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(br.readLine());

        for (int i = 1; i <= L; i++) {
            zombieStamina[i] = Integer.parseInt(br.readLine());
        }

        // 기관총을 모두 쐈을 때 데미지를 계산해본다.
        for (int i = 1; i <= L; i++) {
            if (i >= 1 && i <= mL) {
                zombieStamina[i] -= i * mK;
            } else {
                zombieStamina[i] -= mL * mK;
            }
            // 반드시 지뢰를 던져야하는 위치를 체크
            if (zombieStamina[i] > 0) {
                bombPosition[i] = true;
            }
        }

        int bombCount = 0;

        for (int i = 1; i <= L; i++) {

            // 슬라이딩 윈도우 -> 폭탄 개수 더하기
            if (bombPosition[i]) {
                bombCount++;
            }

            // 슬라이딩 윈도우 -> 폭탄 개수 빼기
            if (i > mL && bombPosition[i - mL]) {
                bombCount--;
            }

            // 기관총을 맞는 좀비 -> 나중에 폭탄을 맞게 될 수 있음
            if (!bombPosition[i]) {
//                System.out.println(i + " " + bombCount);
                zombieStamina[i] += bombCount * mK;
            }
        }

//        System.out.println("bombCount : " + bombCount);

//        for (int i = 1; i <= L; i++) {
//            System.out.print(zombieStamina[i] + " ");
//        }
//        System.out.println();

        for (int i = 1; i <= L; i++) {
            if (zombieStamina[i] > 0) {
                if (C == 0) {
                    answer = "NO";
                    break;
                }
                C--;
            }
        }

        System.out.println(answer);
    }
}
