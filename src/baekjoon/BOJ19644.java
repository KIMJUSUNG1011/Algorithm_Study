package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ19644 {

    static int L, mL, mK, C, usedBombCount;
    static long[] zombieStamina;
    static String answer = "YES";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        zombieStamina = new long[L + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        mL = Integer.parseInt(st.nextToken());
        mK = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(br.readLine());

        for (int i = 1; i <= L; i++) {
            zombieStamina[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= L; i++) {

            // 현재 위치의 기관총 데미지 계산
            long damage = i >= 1 && i <= mL ? i * mK : mL * mK;

            // 슬라이딩 윈도우 -> 사용된 지뢰 개수 감소
            if (i > mL && zombieStamina[i - mL] > 0) {
                usedBombCount--;
            }

            // 지뢰로 인해 기관총을 맞지 못한 경우 데미지 재계산
            damage -= usedBombCount * mK;

            // 지뢰가 필요한 경우
            if (zombieStamina[i] > damage) {
                if (C == 0) {
                    answer = "NO";
                    break;
                }
                // 슬라이딩 윈도우 -> 사용된 지뢰 개수 증가
                usedBombCount++;
                C--;
            }

            // 지뢰를 사용한 경우에는 좀비의 체력이 0 보다 클 것
            zombieStamina[i] -= damage;
        }

        System.out.println(answer);
    }
}
