package baekjoon;

import java.io.*;
import java.util.*;

// N 개의 마을이 수직선 상에 있음
// i 번째 마을은 X[i] 에 위치해 있으며, A[i] 명의 사람이 살고 있음
// 각 사람들까지의 거리의 합이 최소가 되는 위치에 우체국을 세우기로 결정함
// 가능한 경우가 여러 가지인 경우에는 더 작은 위치를 출력

// 1 <= N(마을의 개수) <= 100000
// -10억 <= X[i](마을의 위치) <= 10억
// 1 <= A[i](사람 수) <= 10억

// 그리디 + 이분 탐색
// 1. 우선 반드시 마을에 우체국을 세워야함
// 2. 우체국을 세운 마을을 기준으로 양 쪽에 있는 사람들의 수의 차가 최대한 작아야함

public class BOJ2141 {

    static class Town {

        int townIdx, numberOfPeople;

        Town(int townIdx, int numberOfPeople) {
            this.townIdx = townIdx;
            this.numberOfPeople = numberOfPeople;
        }
    }

    static int N;
    static Town[] towns;
    static long[] sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        towns = new Town[N + 1];
        sum = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int townIdx = Integer.parseInt(st.nextToken());
            int numberOfPeople = Integer.parseInt(st.nextToken());
            towns[i] = new Town(townIdx, numberOfPeople);
        }

        Arrays.sort(towns, 1, N + 1, (town1, town2) -> {
            return town1.townIdx - town2.townIdx;
        });

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + (long)towns[i].numberOfPeople;
        }

        System.out.println(binarySearch());
    }

    static int binarySearch() {

        int low = 1;
        int high = N;
        int retIdx = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (sum[mid] < sum[N] - sum[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
                retIdx = Math.min(retIdx, towns[mid].townIdx);
            }
        }

        return retIdx;
    }
}
