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
    static int[] sizeByColor, countBySize, answer;
    static Map<?, ?>[] countByColorBySize;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        balls = new Ball[N];
        sizeByColor = new int[N + 1];
        countBySize = new int[2001];
        countByColorBySize = new HashMap[2001];
        answer = new int[N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i, color, size);
            totalSize += size;
            sizeByColor[color] += size;
            countBySize[size]++;
            Map<Integer, Integer> countByColor = (Map<Integer, Integer>) countByColorBySize[size];
            if (countByColor == null) {
                countByColor = new HashMap<>();
            }
            Integer val = countByColor.get(color);
            countByColor.put(color, val == null ? 1 : val + 1);
        }

        Arrays.sort(balls, (ball1, ball2) -> ball2.size - ball1.size);

        for (int i = 0; i < N; i++) {
            Ball cur = balls[i];
            Map<Integer, Integer> map = ((Map<Integer, Integer>)countByColorBySize[cur.size]);
            Integer count = map.get(cur.color);
            int countSameSizeByOtherColor = countBySize[cur.size] - count;
            answer[cur.number] = totalSize - sizeByColor[cur.color] - countSameSizeByOtherColor * cur.size;
            totalSize -= cur.size;
            sizeByColor[cur.color] -= cur.size;
            countBySize[cur.size]--;
            map.put(cur.color, count - 1);
        }

        for (int i = 0; i < N; i++) {
            sb.append(answer[i] + "\n");
        }

        System.out.print(sb);
    }
}
