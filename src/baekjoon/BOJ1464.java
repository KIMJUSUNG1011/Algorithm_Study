package baekjoon;

import java.io.*;

public class BOJ1464 {

    static String s, reverse;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        for (int i = 2; i < s.length(); i++) {

            String sub = s.substring(0, i);
            reverse = new StringBuilder(sub).reverse().toString();

            boolean isReverse1 = (sub.compareTo(reverse) < 0) && (sub.charAt(0) >= s.charAt(i));
            boolean isReverse2 = (sub.compareTo(reverse) > 0) && (sub.charAt(i - 1) < s.charAt(i));

            // 뒤집어야 하는 경우
            if (isReverse1 || isReverse2) {
                s = reverse + s.substring(i);
            }
        }

        reverse = new StringBuilder(s).reverse().toString();
        String answer = s.compareTo(reverse) < 0 ? s : reverse;
        System.out.println(answer);
    }
}
