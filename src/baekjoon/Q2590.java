package baekjoon;

import java.io.*;

// 정사각형 모양의 6 종류의 색종이가 있음
// n 번 색종이 -> 한 변의 길이가 n cm
// 색종이를 6 * 6 판에 붙임. 색종이가 겹쳐서는 안됨
// 하나의 색종이는 하나의 판에만 붙여야됨

// 각 종류별로 색종이의 장수가 주어질 때, 색종이를 모두 붙이기 위해 6 * 6 판이 최소 몇 개가 필요한 지 구하시오.

// 1 <= n <= 6
// 0 <= 색종이 장수 <= 100

// 일단 6 * 6 에 최대한 많이 구겨넣어보자

public class Q2590 {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}
