package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ10800 {

    static class Ball {
        int number, color, size;
        Ball(int number, int color, int size) {
            this.number = number;
            this.color = color;
            this.size = size;
        }
    }

    static int N, totalSize;
    static Ball[] balls;
    static int[] sizeByColor, answer;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        balls = new Ball[N];
        sizeByColor = new int[N + 1];
        answer = new int[N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i, color, size);
            totalSize += size;
            sizeByColor[color] += size;
        }

        Arrays.sort(balls, (ball1, ball2) -> ball2.size - ball1.size);

        for (int i = 0; i < N; i++) {
            Ball cur = balls[i];
            answer[cur.number] = totalSize - sizeByColor[cur.color];
            totalSize -= cur.size;
            sizeByColor[cur.color] -= cur.size;
        }

        for (int i = 0; i < N; i++) {
            sb.append(answer[i] + "\n");
        }

        System.out.print(sb);
    }
}
