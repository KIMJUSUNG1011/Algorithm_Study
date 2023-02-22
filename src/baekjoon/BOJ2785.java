package baekjoon;

import java.io.*;
import java.util.*;

// 도서관

// 세준이와 책은 모두 0 이 위치
// 각 책들의 원래 위치가 주어짐
// 책을 모두 제자리에 놔둘 때 드는 최소 걸음 수를 계산해라!!

// 세준이는 한 번에 최대 M 권의 책을 들 수 있음
// 한 걸음에 좌표 1 칸씩 이동
// -10000 <= 책의 원래 위치 <= 10000
// 1 <= N(책의 개수), M <= 50

// 접근 방법
// 1. 0 에서 거리가 가장 먼 책을 가장 마지막에 두어야함 -> 그리디
// 2. 음수 위치와 양수 위치를 구분
// 3. M 만큼 묶어내는 아이디어

public class BOJ2785 {

    static int N, M, answer;
    static List<Integer> plusList, minusList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        plusList = new ArrayList<>();
        minusList = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");

        int max = -1;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            max = Math.max(max, Math.abs(x));
            if (x > 0) {
                plusList.add(x);
            } else {
                minusList.add(x);
            }
        }

        Collections.sort(minusList);
        Collections.sort(plusList, Collections.reverseOrder());

        for (int i = 0; i < minusList.size(); i+=M) {
            int first = minusList.get(i);
            if (Math.abs(first) == max) {
                answer += Math.abs(first);
            } else {
                answer += Math.abs(first) * 2;
            }
        }

        for (int i = 0; i < plusList.size(); i+=M) {
            int first = plusList.get(i);
            if (Math.abs(first) == max) {
                answer += Math.abs(first);
            } else {
                answer += Math.abs(first) * 2;
            }
        }

        System.out.println(answer);
    }
}
